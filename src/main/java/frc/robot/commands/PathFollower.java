/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.team319.trajectory.Path;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardComponent;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Auto.GenPathSetup;
//import frc.paths.straight10ft;
import frc.robot.Framework.Logging.CSVServer;
import frc.robot.Framework.Logging.LoadPath;
import frc.robot.subsystems.Drivetrain;

import java.util.Map;

public class PathFollower extends CommandBase {
  public enum CSVValues{
    DT(0),X(1),Y(2), POSITION(3),VELOCITY(4),ACCELERATION(5),JERK(6),HEADING(7);
    private int value;
    private static Map map = new HashMap<>();
    private CSVValues(int value) {
        this.value = value;
    }
    static {
        for (CSVValues pageType : CSVValues.values()) {
            map.put(pageType.value, pageType);
        }
    }
    public static CSVValues valueOf(int pageType) {
        return (CSVValues) map.get(pageType);
    }
    public int getValue() {
        return value;
    }
}
  GenPathSetup pathinst;
  Path pathToFollow;
  int currentLine = 0;
  double feetPerSecondToRpm = ((120*10.666667)/Math.PI);
  double RpmToFeetPerSecond = (Math.PI/(120*10.666667));
  double startTime = 0;
  double endTime = 0;
  private final Drivetrain m_dDrivetrain;
  CSVServer serv;

  ArrayList<String[]> left;
  ArrayList<String[]> right;
  ArrayList<String[]> center;
  ArrayList<String[]> points;
  boolean resetGyro = false;
  /**
   * Creates a new PathFollower.
   */
  public PathFollower(Drivetrain rContainerDriveTrain, String fname, boolean resetGyroOnInit) {
    LoadPath loader = new LoadPath();
    left = loader.loadCSV("/home/lvuser/deploy/paths/"+fname+".left"+".csv");
    
    right = loader.loadCSV("/home/lvuser/deploy/paths/"+fname+".right"+".csv");
    
    center = loader.loadCSV("/home/lvuser/deploy/paths/"+fname+".center"+".csv");
    points = new ArrayList<String[]>();
    // Use addRequirements() here to declare subsystem dependencies.
    m_dDrivetrain = rContainerDriveTrain;
    serv = new CSVServer();
    
    String[] header = { "right vel", "real right vel", " left vel", " real left vel", "real heading","path heading" };
    points.add(header);
    resetGyro = resetGyroOnInit;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriverStation.reportError("Path has been initialized(scheduler has run it) ", false);
    m_dDrivetrain.setCoast();
    pathinst = new GenPathSetup();
    
    startTime = System.currentTimeMillis();//Change to fpga timestamp? 
    if(resetGyro){
      m_dDrivetrain.calibrateIMU();
    }
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double m_currentHeading = m_dDrivetrain.returnAngle();
    double path_heading = Double.parseDouble(center.get(currentLine)[GenPathSetup.heading()]);
    double heading_difference = m_currentHeading - Math.toDegrees(path_heading);
    //SmartDashboard.putNumber("heading difference", heading_difference);
    //SmartDashboard.putNumber("your angle", m_currentHeading);
    //SmartDashboard.putNumber("path heading", Math.toDegrees(path_heading));
    //SmartDashboard.putNumber("smaple heading diff", Math.toDegrees(heading_difference));
    double leftVelocity= Double.parseDouble(left.get(currentLine)[GenPathSetup.vel()]) * feetPerSecondToRpm;
    double rightVelocity = Double.parseDouble(right.get(currentLine)[GenPathSetup.vel()])*feetPerSecondToRpm;
    double heading = 0;//heading_difference*1.75;
    double leftAcc = Double.parseDouble(left.get(currentLine)[GenPathSetup.acc()]);
    double rightAcc  = Double.parseDouble(right.get(currentLine)[GenPathSetup.acc()]);

    //SmartDashboard.putNumber("Left Velociyt difference ", leftVelocity + trains.returnLeftVelocity());
    //SmartDashboard.putNumber("Left Velocity", trains.returnLeftVelocity());
    //SmartDashboard.putNumber("Path left velocity", leftVelocity);
    
    //heading for now 
    m_dDrivetrain.setVelocity(leftVelocity,rightVelocity, heading, leftAcc,rightAcc);
    String[] currentVels = new String[6];

    currentVels[0] = "" + rightVelocity*RpmToFeetPerSecond;
    currentVels[1] = "" + -m_dDrivetrain.returnRightVelocity()*RpmToFeetPerSecond;
    currentVels[2] = "" + -leftVelocity*RpmToFeetPerSecond;
    currentVels[3] = "" + m_dDrivetrain.returnLeftVelocity()*RpmToFeetPerSecond;
    currentVels[4] = "" + (m_currentHeading);
    currentVels[5] = ""+ Math.toDegrees(path_heading);
    points.add(currentVels);
    currentLine++;
    
  }
  public void executeAndRun(){
    if(!isFinished()){
      execute();

    }else{
      end(false);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
    m_dDrivetrain.arcadeDrive(0, 0);
    m_dDrivetrain.setBrake();
    double endTime = System.currentTimeMillis();
    String timeDiff = Double.toString(endTime - startTime);
    try {
      points.add(m_dDrivetrain.getPIDVariables());
      serv.sendDataAccrossNetwork(points);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    DriverStation.reportError("Time difference between start and end of path" + timeDiff ,false);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Double.parseDouble(left.get(currentLine)[4])<0.01&&m_dDrivetrain.returnLeftVelocity()*RpmToFeetPerSecond<0.01&&currentLine>50){
      SmartDashboard.putNumber("current line ",currentLine);
      SmartDashboard.putNumber("drive train vel at end", m_dDrivetrain.returnLeftVelocity()*RpmToFeetPerSecond);
      return true;
    }
      return (currentLine>=left.size()-1);
    
  }
}

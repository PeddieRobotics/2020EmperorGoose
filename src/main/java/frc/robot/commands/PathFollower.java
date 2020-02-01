/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.io.IOException;
import java.util.ArrayList;

import com.team319.io.TrajectoryExporter;
import com.team319.trajectory.Path;

import org.opencv.videoio.VideoCapture;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.paths.GenPathSetup;
//import frc.paths.straight10ft;
import frc.robot.CSVServer;
import frc.robot.LoadCSV;
import frc.robot.LoadPath;
import frc.robot.subsystems.Drivetrain;

public class PathFollower extends CommandBase {
  GenPathSetup pathinst;
  Path pathToFollow;
  int currentLine = 0;
  double startTime = 0;
  double endTime = 0;
  private final Drivetrain trains;
  CSVServer serv;

  ArrayList<String[]> left;
  ArrayList<String[]> right;
  ArrayList<String[]> center;
  ArrayList<String[]> points;
  
  /**
   * Creates a new PathFollower.
   */
  public PathFollower(Drivetrain train, String fname) {
    LoadPath loader = new LoadPath();
    left = loader.loadCSV("/home/lvuser/deploy/paths/"+fname+".left"+".csv");
    
    right = loader.loadCSV("/home/lvuser/deploy/paths/"+fname+".right"+".csv");
    
    center = loader.loadCSV("/home/lvuser/deploy/paths/"+fname+".center"+".csv");
    points = new ArrayList<String[]>();
    // Use addRequirements() here to declare subsystem dependencies.
    trains = train;
    serv = new CSVServer();
    addRequirements(train);
    String[] header = { "right vel", "real right vel", "left vel", "real left vel", "real heading","path heading" };
    points.add(header);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    trains.setCoast();
    pathinst = new GenPathSetup();
    
    trains.resetNavX();
    startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double m_currentHeading = trains.returnAngle();
    double path_heading = Double.parseDouble(center.get(currentLine)[7]);
    double heading_difference = m_currentHeading + Math.toDegrees(path_heading);
    //SmartDashboard.putNumber("heading difference", heading_difference);
    //SmartDashboard.putNumber("your angle", m_currentHeading);
    //SmartDashboard.putNumber("path heading", Math.toDegrees(path_heading));
    //SmartDashboard.putNumber("smaple heading diff", Math.toDegrees(heading_difference));
    double leftVelocity= Double.parseDouble(left.get(currentLine)[4]) * (120 * 11.111 / Math.PI);
    //SmartDashboard.putNumber("Left Velociyt difference ", leftVelocity + trains.returnLeftVelocity());
    //SmartDashboard.putNumber("Left Velocity", trains.returnLeftVelocity());
    //SmartDashboard.putNumber("Path left velocity", leftVelocity);
    
    trains.setVelocity(Double.parseDouble(left.get(currentLine)[4]) * (120 * 11.111 / Math.PI)
    ,Double.parseDouble(right.get(currentLine)[4]) * (120 * 11.111 / Math.PI), 1.75*Double.parseDouble(center.get(currentLine)[4])  * heading_difference);
    String[] currentVels = new String[6];

    currentVels[0] = "" + Double.parseDouble(right.get(currentLine)[4]);
    currentVels[1] = "" + trains.returnRightVelocity()*(Math.PI/(120*11.111111));
    currentVels[2] = "" + -leftVelocity*(Math.PI/(120*11.111111));
    currentVels[3] = "" + trains.returnLeftVelocity()*(Math.PI/(120*11.111111));
    currentVels[4] = "" + (-1*m_currentHeading);
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
    trains.arcadeDrive(0, 0);
    trains.setBrake();
    double endTime = System.currentTimeMillis();
    String timeDiff = Double.toString(endTime - startTime);
    try {
      points.add(trains.getPIDVariables());
      serv.testings(points);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    DriverStation.reportError("Time difference between start and end of path" + timeDiff ,false);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Double.parseDouble(left.get(currentLine)[4])<0.01&&trains.returnLeftVelocity()*(Math.PI/(120*11.111111))<0.01&&currentLine>50){
      return true;
    }
      return (currentLine>=left.size()-1);
    
  }
}

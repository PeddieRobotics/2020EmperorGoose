/**
 * Peddie 5895 FIRST Robotics
 * FollowPath.java
 * Command to load an autonomous path from .csv file and execute the path using
 * the drivetrain subsystem.
 *
 */

package frc.robot.commands.AutoCommands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.team319.trajectory.Path;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Auto.GenPathSetup;
import frc.robot.Framework.Logging.CSVServer;
import frc.robot.Framework.Logging.LoadPath;
import frc.robot.subsystems.Drivetrain;

import java.util.Map;

public class FollowPath extends CommandBase {

  public enum CSVValues {
    DT(0), X(1), Y(2), POSITION(3), VELOCITY(4), ACCELERATION(5), JERK(6), HEADING(7);

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
  
  private int currentLine = 0;
  private double feetPerSecondToRpm =(60.0*10.6666)/(Math.PI*(6.25/12.0));
  private double RpmToFeetPerSecond = (Math.PI*(6.25/12.0))/(60.0*10.6666);
  private double startTime = 0.0;
  private double endTime = 0.0;
  private Drivetrain m_drivetrain;
  CSVServer serv;

  ArrayList<String[]> left;
  ArrayList<String[]> right;
  ArrayList<String[]> center;
  ArrayList<String[]> points;
  boolean resetGyro = false;
  boolean areReportingValues = false;
  boolean isReversed = false;
  /**
   * 
   * @param drivetrain      we need to make the drive train move so we are using
   *                        this
   * @param fname           jus the name of the path in bobTrajectory. So if you
   *                        name your path straight10, then fname should be
   *                        straight10 bob will name files fname.side.csv and as
   *                        you can see in the loader it handles it there for you
   * @param resetGyroOnInit tells us whether or not we want to reset the gyro on
   *                        init, for example when we first run our auto routine
   *                        we will want to reset our gyro but after we will want
   *                        to keep the same angle
   * @param reportValues tells DriveTrain whether or not we want to report the CSV it recorded or not
   */
  public FollowPath(Drivetrain drivetrain, String fname, boolean resetGyroOnInit, boolean reportValues, boolean isReversed) {
    LoadPath loader = new LoadPath();
    this.isReversed = isReversed;
    areReportingValues = reportValues;
    /**
     * How files work on rio
      * /home/lvuser is the location of the rio directory, everything in the deploy folder will get put into the rios 
      deploy folder. So all paths from bob are put on our src/main/deploy folder, and then when we deploy they get moved to 
      deploy. So if our paths are under deploy/paths, on rio they will be put in 
      /home/lvuser/deploy/paths, and then we can load them in there
      Thus below we are loading the csv file into an arraylist of points, we can't use the class because 200hz paths are so large
      that we run into java's double limit so we use the csvs
     */
    left = loader.loadCSV("/home/lvuser/deploy/paths/" + fname + ".left" + ".csv");

    right = loader.loadCSV("/home/lvuser/deploy/paths/" + fname + ".right" + ".csv");

    center = loader.loadCSV("/home/lvuser/deploy/paths/" + fname + ".center" + ".csv");
    //we wills store our recorded points here to be logged + sent across the network
    points = new ArrayList<String[]>();
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drivetrain;
    serv = new CSVServer();// generate a server

    String[] header = { "right vel", "real right vel", " left vel", " real left vel", "real heading", "path heading" };
    points.add(header);
    resetGyro = resetGyroOnInit;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriverStation.reportError("Path has been initialized(scheduler has run it) ", false);
    m_drivetrain.setBrake();

    if (resetGyro) {
      m_drivetrain.calibrateIMU();
    }
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double m_currentHeading = m_drivetrain.returnAngle();//our angle
    double path_heading = Double.parseDouble(center.get(currentLine)[GenPathSetup.heading()]);//what the path thinks that we should be at
    double heading_difference = m_currentHeading - Math.toDegrees(path_heading); //diff  btwn our heading and path heading
    //SmartDashboard.putNumber("heading difference", heading_difference);
    //SmartDashboard.putNumber("your angle", m_currentHeading);
    //SmartDashboard.putNumber("path heading", Math.toDegrees(path_heading));
    //SmartDashboard.putNumber("smaple heading diff", Math.toDegrees(heading_difference));
    //takes the velocity from the left and right csvs and converts from fps to rpm
    double leftVelocity= Double.parseDouble(left.get(currentLine)[GenPathSetup.vel()]) * feetPerSecondToRpm;
    double rightVelocity = Double.parseDouble(right.get(currentLine)[GenPathSetup.vel()])*feetPerSecondToRpm;
    double heading = 0;//heading_difference*1.75; // we are not using heading for now
    double leftAcc = Double.parseDouble(left.get(currentLine)[GenPathSetup.acc()]); //same as vel. get acc from path
    double rightAcc  = Double.parseDouble(right.get(currentLine)[GenPathSetup.acc()]);

    //SmartDashboard.putNumber("Left Velociyt difference ", leftVelocity + trains.returnLeftVelocity());
    //SmartDashboard.putNumber("Left Velocity", trains.returnLeftVelocity());
    //SmartDashboard.putNumber("Path left velocity", leftVelocity);
    
    //heading for now 
    if(!isReversed){
          m_drivetrain.setVelocity(leftVelocity,rightVelocity, heading, leftAcc,rightAcc);
    }
    if(isReversed){
      m_drivetrain.setVelocity(-leftVelocity,-rightVelocity,heading,-leftAcc,-rightAcc);
    }
          String[] currentVels = new String[6];

    currentVels[0] = "" + rightVelocity*RpmToFeetPerSecond;
    currentVels[1] = "" + -m_drivetrain.returnRightVelocity()*RpmToFeetPerSecond;
    currentVels[2] = "" + -leftVelocity*RpmToFeetPerSecond;
    currentVels[3] = "" + m_drivetrain.returnLeftVelocity()*RpmToFeetPerSecond;
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
    m_drivetrain.arcadeDrive(0, 0, Constants.DRIVETRAIN_DEADBAND, Constants.DRIVETRAIN_USE_SQUARED);
    m_drivetrain.setCoast();
    m_drivetrain.run();
    endTime = System.currentTimeMillis();
    String timeDiff = Double.toString(endTime - startTime);
    /**
     * Report values only if you need to tune
     */
    if(areReportingValues){
      DriverStation.reportError("sending data",false);
      try {
        points.add(m_drivetrain.getPIDVariables());
        serv.sendDataAccrossNetwork(points);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }else{
      DriverStation.reportError("not sending values",false);
      points = null;//free memory? 
    }
    left = null;// we don't really need to have large files hanging around
    right = null;
    center = null;
    DriverStation.reportError("Time difference between start and end of path" + timeDiff ,false);
  }
  
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Double.parseDouble(left.get(currentLine)[4]) < 0.01 && 
      m_drivetrain.returnLeftVelocity()*RpmToFeetPerSecond<0.01 && 
      currentLine>50){
      SmartDashboard.putNumber("current line ",currentLine);
      SmartDashboard.putNumber("drive train vel at end", m_drivetrain.returnLeftVelocity()*RpmToFeetPerSecond);
      return true;
    }
      return (currentLine>=left.size()-1);
    
  }
}

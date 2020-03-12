/**
 * FRC 5895 (Peddie School Robotics)
 * The Drivetrain subsystem runs the motors for all
 * wheels and deals with implementing joystick control of the robot.
 */

package frc.robot.subsystems;

import com.analog.adis16470.frc.ADIS16470_IMU;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Auto.PIDClasses.NEO;

public class Drivetrain extends SubsystemBase {

  // Useful values???
  // May be old and should be either deleted or moved (constants?)
  private static final int kTicksPerRev = 1;
  private static final double kWheelDiameter = 6.0 / 12.0 / 11.11 / Math.PI;
  private static final double kMaxVelocity = 7.5;
  
  private Joystick driverXboxController, leftJoystick, rightJoystick;

  private NEO leftDriveMaster, rightDriveMaster, leftDriveFollower, rightDriveFollower;

  private CANPIDController m_pidController, m_pidController2;
  
  // For the gyro
  public int smartMotionSlot = 0;
  private final ADIS16470_IMU imu;

  private double m_speedScale, m_turnScale;

  /* Value between -1.0 and 1.0 (units?) that were last given to left and right master
  CANSparkMax motor controllers during teleop (ArcadeDrive).
  */
  double leftStartTick = 0;
  double rightStartTick=0;
  private double leftDriveInputSpeed, leftDriveInputTurn, rightDriveInputSpeed, rightDriveInputTurn;

  public Drivetrain(){

    // Set up the gyro
    imu = new ADIS16470_IMU();
   
    leftDriveMaster = new NEO(1);
    rightDriveMaster = new NEO(3);
    leftDriveFollower = new NEO(2);
    rightDriveFollower = new NEO(4);
    leftDriveFollower.follow(leftDriveMaster);
    rightDriveFollower.follow(rightDriveMaster);

    rightDriveMaster.addPIDController( Constants.DRIVETRAIN_P, Constants.FLYWHEEL_D, Constants.DRIVETRAIN_I, Constants.DRIVETRAIN_FF + Constants.DRIVETRAIN_FF_OFFSET, 0 );
    leftDriveMaster.addPIDController( Constants.DRIVETRAIN_P, Constants.FLYWHEEL_D, Constants.DRIVETRAIN_I, Constants.DRIVETRAIN_FF, 0 );
    
    // Default to full speed and turn
    m_speedScale = 1.0;
    m_turnScale = 1.0;
    
    leftDriveMaster.changeControlFramePeriod(3);
    rightDriveMaster.changeControlFramePeriod(3);
  
    leftStartTick = leftDriveMaster.getEncoder().getPosition();
    rightStartTick = rightDriveMaster.getEncoder().getPosition();
  }

  public void setJoysticks(Joystick left, Joystick right){
    leftJoystick = left;
    rightJoystick = right;
  }

  public void setDriverXboxController(Joystick xbox){
    driverXboxController = xbox;
  }
  public void resetEncoders(){
    leftStartTick=leftDriveMaster.getEncoder().getPosition();
    rightStartTick = rightDriveMaster.getEncoder().getPosition();
  }

  /**
   * Query the gyro for the robot's heading.
   * Normalized to -180 to 180 range.
   * From a zeroed gyro, positive angles are counterclockwise, negative angles are clockwise.
   * @return The robot's current angle in degrees
   */
  public double returnAngle() {
    return Math.IEEEremainder(imu.getAngle(), 360);
  }
  public double unBoundedAngle(){
    return imu.getAngle();
  }
  /**
   * Set the left and right wheel velocity (in RPM) using the
   * acceleration and heading information to inform
   * the calculation. 
   * @param left_velocity the velocity to send to the left motor in rpm
   * @param right_velocity the velocity to send to the right motor in rpm
   * @param heading the heading to send(arbitrary units)
   * @param leftAccel the acceleration in m/s/s
   * @param rightAccel the acceleration in m/s/s
   */

  public void setVelocity( double left_velocity, double right_velocity, double heading, double leftAccel, double rightAccel ) {

    leftDriveMaster.setArbFF( -0.0 + ( -leftAccel * Constants.DRIVETRAIN_ACC ) ); //0.05 is the deadband
    rightDriveMaster.setArbFF( 0.0 + ( rightAccel * Constants.DRIVETRAIN_ACC ) );
    
    leftDriveMaster.setSmartVelocity( -left_velocity + heading );
    rightDriveMaster.setSmartVelocity( right_velocity + heading );

  }

  /**
   * 
   * @return velocity of the left drive master
   */
  public double returnLeftVelocity() {

    return leftDriveMaster.getVelocity();

  }
  /**
   * 
   * @return velocity of the right drive master
   */
  public double returnRightVelocity() {

    return -rightDriveMaster.getVelocity();

  }
  /**
   * 
   * @return report pid vars as a string that can be added to csv
   */
  public String[] getPIDVariables() {

    String[] variables = new String[6];
    variables[0] = "variables";

    variables[1] = "p" + Constants.DRIVETRAIN_P;
    
    variables[2] = "i" + Constants.DRIVETRAIN_I;
    
    variables[3] = "d" + Constants.DRIVETRAIN_D;
    
    variables[4] = "f" + Constants.DRIVETRAIN_FF;

    variables[5] = "accl" + Constants.DRIVETRAIN_ACC;

    return variables;

  }
  
  public void setBrake() {

    leftDriveMaster.setIdleMode(IdleMode.kBrake);
    rightDriveMaster.setIdleMode(IdleMode.kBrake);

    leftDriveFollower.setIdleMode(IdleMode.kBrake);
    rightDriveFollower.setIdleMode(IdleMode.kBrake);

  }
  public void setCoast() {

    leftDriveMaster.setIdleMode(IdleMode.kCoast);
    rightDriveMaster.setIdleMode(IdleMode.kCoast);

    leftDriveFollower.setIdleMode(IdleMode.kCoast);
    rightDriveFollower.setIdleMode(IdleMode.kCoast);
  }
  public void setTurn(double turn){
    leftDriveInputTurn = -turn;
    rightDriveInputTurn = -turn;
  }
  public void setSpeed(double speed){
    leftDriveInputSpeed = speed;
    rightDriveInputSpeed = -speed;
  }
  public void addToSpeed(double speed){
    leftDriveInputSpeed += speed;
    rightDriveInputSpeed-=speed;
  }
  public void addToTurn(double turn){
    leftDriveInputTurn -= turn;
    rightDriveInputTurn -= turn;
  }
  
  public void arcadeDrive( double speed, double turn ) {
    double deadband = 0.0;

    if(Constants.USE_XBOX_CONTROLLER){
      deadband = Constants.XBOX_JOYSTICK_DEADBAND;
    }
    else{
      deadband = Constants.JOYSTICK_DEADBAND;
    }

    if( Math.abs(speed) < deadband ) {
      speed = 0;
    }
    if ( Math.abs(turn) < deadband ) {
      turn = 0;
    }

    if (Constants.DRIVETRAIN_USE_SQUARED){
      addToSpeed(speed*Math.abs(speed));
      addToTurn(turn*Math.abs(turn)); 
    }
    else{
      addToSpeed(speed);
      addToTurn(turn);  
    }
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("angle " , returnAngle());
    SmartDashboard.putNumber("unbounded angle " , unBoundedAngle());

  }

  /**
   * Resets yaw to zero
   */
  public void resetADIS() {
    DriverStation.reportError("resseting",false);
    imu.reset();

  }
  /**
   * 
   * @return the position of the left encoder 
   */
 
  /**
   * Calibrates imu, only call if imu hasn't move, movement will show up as drift in so don't calibrate if moved! 
   * If moved then just restart robot code
   */
  public void calibrateIMU() {

    imu.calibrate();

  }

  public double getSpeed() {
    double speed = 0.0;
    if(Constants.USE_XBOX_CONTROLLER){
      speed = m_speedScale*Constants.XBOX_SPEED_SCALE_FACTOR*driverXboxController.getRawAxis(1);
    }
    else{
      speed = m_speedScale*Constants.JOYSTICK_TURN_SCALE_FACTOR*leftJoystick.getRawAxis(1);
    }
    return speed;
  }

  public double getTurn() {
    double turn = 0.0;
    if(Constants.USE_XBOX_CONTROLLER){
      turn = m_turnScale*Constants.XBOX_TURN_SCALE_FACTOR*driverXboxController.getRawAxis(4);
    }
    else{
      turn = m_turnScale*Constants.JOYSTICK_TURN_SCALE_FACTOR*rightJoystick.getRawAxis(0);
    }
    return turn;
  }
  /**
   * We set the left and right motors to the inputs, then reset them so that they don't add up too much
   */
  public void run(){
    
    leftDriveMaster.set(leftDriveInputSpeed+leftDriveInputTurn);
   
    rightDriveMaster.set(rightDriveInputSpeed+rightDriveInputTurn);

    setSpeed(0);//reset vars
    setTurn(0);
  
  }

  //new arcade drive refractoring
  public double getAverageDistance() {
	  return ((-leftDriveMaster.getEncoder().getPosition()+leftStartTick)+(rightDriveMaster.getEncoder().getPosition()-rightStartTick))/2.0;
  }
  
  public double getAverageHeading() {
    return 0;
  }

  public void setScale(double speedScale, double turnScale){
    m_speedScale = speedScale;
    m_turnScale = turnScale;
  }

}

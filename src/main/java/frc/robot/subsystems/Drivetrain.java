/*
*Pid tuning methods tried
* random guess: didn't work
* double p until no oscilatoin, then double i

*/
package frc.robot.subsystems;

import com.analog.adis16470.frc.ADIS16470_IMU;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANPIDController.AccelStrategy;
import com.revrobotics.CANPIDController.ArbFFUnits;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Auto.PIDClasses.NEO;
import frc.robot.Auto.PIDClasses.NEOPIDWithSmartDashboard;


public class Drivetrain extends SubsystemBase {

  private static final int kTicksPerRev = 1;
  private static final double kWheelDiameter = 6.0 / 12.0 / 11.11 / Math.PI;
  private static final double kMaxVelocity = 7.5;

  private static final String pathName = "output/hi5";
  private NEO leftDriveMaster, rightDriveMaster, leftDriveFollower1, rightDriveFollower1;
  private double leftspeed, rightspeed;

  CANPIDController m_pidController, m_pidController2;
  
  private boolean atDistances;
  private boolean atAngle;

  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM, maxVel, minVel, maxAcc, allowedErr;
  public double kP2, kI2, kD2, kIz2, kFF2, kMaxOutput2, kMinOutput2, maxRPM2, maxVel2, minVel2, maxAcc2, allowedErr2;

  public int smartMotionSlot = 0;
  private final ADIS16470_IMU imu;

  private double leftNyoom;
  private double rightNyoom;

  public Drivetrain() {

    imu = new ADIS16470_IMU();
    
    leftDriveMaster = new NEO(1);
    rightDriveMaster = new NEO(3);
    leftDriveFollower1=new NEO(2, leftDriveMaster );
    rightDriveFollower1 = new NEO(4, rightDriveMaster );

    rightDriveMaster.addPIDController( Constants.DRIVETRAIN_P, Constants.FLYWHEEL_D, Constants.DRIVETRAIN_I, Constants.DRIVETRAIN_FF + Constants.DRIVETRAIN_FF_OFFSET, 0 );
    leftDriveMaster.addPIDController( Constants.DRIVETRAIN_P, Constants.FLYWHEEL_D, Constants.DRIVETRAIN_I, Constants.DRIVETRAIN_FF, 0 );
    //NEOPIDWithSmartDashboard leftDriveMaster = new NEOPIDWithSmartDashboard(1);
   
    //  NEOPIDWithSmartDashboard rightDriveMaster = new NEOPIDWithSmartDashboard(2);
    
    // NEOPIDWithSmartDashboard leftDriveFollower1 = new NEOPIDWithSmartDashboard(3);
    
    // NEOPIDWithSmartDashboard rightDriveFollower2 = new NEOPIDWithSmartDashboard(4);
  }

  /**
   * 
   * @return Returns the angle in degrees
   */
  public double returnAngle() {

    return imu.getAngle();
    
  }

  /**
   * 
   * @param left_velocity the velocity to send to the left motor in rpm
   * @param right_velocity the velocity to send to the right motor in rpm
   * @param heading the heading to send(arbitrary units)
   * @param leftAccel the acceleration in m/s/s
   * @param rightAccel the acceleration in m/s/s
   */

  public void setVelocity( double left_velocity, double right_velocity, double heading, double leftAccel, double rightAccel ) {

    leftDriveMaster.setArbFF( -0.05 + ( -leftAccel * Constants.DRIVETRAIN_ACC ) ); //0.05 is the deadband
    rightDriveMaster.setArbFF( 0.05 + ( rightAccel * Constants.DRIVETRAIN_ACC ) );

    leftDriveMaster.setVelocity( -left_velocity + heading );
    rightDriveMaster.setVelocity( right_velocity + heading );

  }

  /**
   * 
   * @return Velocity of the left Drive master
   */
  public double returnLeftVelocity() {

    return leftDriveMaster.getVelocity();

  }
  /**
   * 
   * @return Velocity of the right drive master
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

    leftDriveFollower1.setIdleMode(IdleMode.kBrake);
    rightDriveFollower1.setIdleMode(IdleMode.kBrake);

  }
  public void setCoast() {

    leftDriveMaster.setIdleMode(IdleMode.kCoast);
    rightDriveMaster.setIdleMode(IdleMode.kCoast);

    leftDriveFollower1.setIdleMode(IdleMode.kCoast);
    rightDriveFollower1.setIdleMode(IdleMode.kCoast);
  }
  public void arcadeDrive( double speed, double turn ) {

    
    double deadband = 0.08;

    if( Math.abs( speed ) < deadband ) {
      speed = 0;
    }
    if ( Math.abs( turn ) < deadband ) {
      turn = 0;
    }

    leftNyoom = ( speed - turn );
    rightNyoom = ( -speed - turn );
    
    leftDriveMaster.set( leftNyoom );
    rightDriveMaster.set( rightNyoom );
    
  }

  @Override
  public void periodic() {
  }

  /**
   * Resets yaw to zero
   */
  public void resetADIS() {

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

}

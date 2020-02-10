/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
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

  public Drivetrain() {
    imu = new ADIS16470_IMU();
    
    leftDriveMaster = new NEO(1);
    rightDriveMaster = new NEO(3);
    leftDriveFollower1=new NEO(2,leftDriveMaster);
    rightDriveFollower1 = new NEO(4,rightDriveMaster);
    rightDriveMaster.addPIDController(Constants.p,Constants.d,Constants.i,Constants.ff,0);
    leftDriveMaster.addPIDController(Constants.p,Constants.d,Constants.i,Constants.ff,0);
    
  }
  /**
   * 
   * @return Returns the angle in degrees
   */
  public double returnAngle(){
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

  public void setVelocity(double left_velocity,double right_velocity, double heading, double leftAccel, double rightAccel){
    leftDriveMaster.setArbFF(-0.05+(-leftAccel*Constants.accMultiplier));//0.05 is the deadband
    rightDriveMaster.setArbFF(0.05+(-rightAccel*Constants.accMultiplier));
    leftDriveMaster.setVelocity(-left_velocity+heading);
    rightDriveMaster.setVelocity(right_velocity+heading);
  }

  /**
   * 
   * @return Velocity of the left Drive master
   */
  public double returnLeftVelocity(){
    return leftDriveMaster.getVelocity();
  }
  /**
   * 
   * @return Velocity of the right drive master
   */
  public double returnRightVelocity(){
    return -rightDriveMaster.getVelocity();
  }
  /**
   * 
   * @return report pid vars as a string that can be added to csv
   */
  public String[] getPIDVariables(){
    String[] variables = new String[5];
    variables[0] = "variables";
    variables[1] = "p" + Constants.p;
    
    variables[2] = "i" + Constants.i;
    
    variables[3] = "d" + Constants.d;
    
    variables[4] = "f" + Constants.ff;
    return variables;
  }
  
  public void setBrake(){
    leftDriveMaster.setIdleMode(IdleMode.kBrake);
    rightDriveMaster.setIdleMode(IdleMode.kBrake);
    leftDriveFollower1.setIdleMode(IdleMode.kBrake);
    rightDriveFollower1.setIdleMode(IdleMode.kBrake);

  }
  public void setCoast(){
    leftDriveMaster.setIdleMode(IdleMode.kCoast);
    rightDriveMaster.setIdleMode(IdleMode.kCoast);
    leftDriveFollower1.setIdleMode(IdleMode.kCoast);
   
    rightDriveFollower1.setIdleMode(IdleMode.kCoast);
  }
  public void arcadeDrive(double speed ,double turn){
    leftDriveMaster.set(speed - turn);
    rightDriveMaster.set(-speed- turn);
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
  public void calibrateIMU(){
    imu.calibrate();
  }

}

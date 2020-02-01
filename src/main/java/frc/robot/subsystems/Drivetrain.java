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

import edu.wpi.first.wpilibj.spline.QuinticHermiteSpline;

import com.analog.adis16470.frc.ADIS16470_IMU;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANPIDController.AccelStrategy;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Drivetrain extends SubsystemBase {
  private static final int kTicksPerRev = 1;
  private static final double kWheelDiameter = 6.0 / 12.0 / 11.11 / Math.PI;
  private static final double kMaxVelocity = 7.5;

  private static final String pathName = "output/hi5";
  private CANSparkMax leftDriveMaster, rightDriveMaster, leftDriveFollower1, rightDriveFollower1;
  private double leftspeed, rightspeed;

  CANEncoder leftEncoder, rightEncoder;
  CANPIDController m_pidController, m_pidController2;
  private boolean atDistances;
  private boolean atAngle;

  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM, maxVel, minVel, maxAcc, allowedErr;
  public double kP2, kI2, kD2, kIz2, kFF2, kMaxOutput2, kMinOutput2, maxRPM2, maxVel2, minVel2, maxAcc2, allowedErr2;

  ADIS16470_IMU imu = new ADIS16470_IMU();
  public Drivetrain() {
    //leftDriveMaster.setControlFramePeriodMs(2); test this later when have time 
    DriverStation.reportError("this is Insert my name here code",false);
    leftDriveMaster = new CANSparkMax(Constants.LEFT_MASTER, MotorType.kBrushless);
    leftDriveFollower1 = new CANSparkMax(Constants.LEFT_FOLLOWER, MotorType.kBrushless);
    rightDriveMaster = new CANSparkMax(Constants.RIGHT_MASTER, MotorType.kBrushless);
    rightDriveFollower1 = new CANSparkMax(Constants.RIGHT_FOLLOWER, MotorType.kBrushless);
    leftDriveMaster.restoreFactoryDefaults();
    rightDriveMaster.restoreFactoryDefaults();
    leftDriveFollower1.restoreFactoryDefaults();
    rightDriveFollower1.restoreFactoryDefaults();
        
    leftDriveFollower1.follow(leftDriveMaster);
    rightDriveFollower1.follow(rightDriveMaster);

    leftEncoder = leftDriveMaster.getEncoder();
    rightEncoder = rightDriveMaster.getEncoder();
  
    leftDriveMaster.setIdleMode(IdleMode.kCoast);
    rightDriveMaster.setIdleMode(IdleMode.kCoast);
    
    leftDriveFollower1.setIdleMode(IdleMode.kCoast);
    //rightDriveFollower1.setIdleMode(IdleMode.kCoast);
    leftDriveMaster.setControlFramePeriodMs(1);
    rightDriveMaster.setControlFramePeriodMs(1);
    leftDriveFollower1.setControlFramePeriodMs(1);
    rightDriveFollower1.setControlFramePeriodMs(1);
    
    m_pidController = leftDriveMaster.getPIDController();
    m_pidController2 = rightDriveMaster.getPIDController();


    // PID coefficients
    double p = 0.00186;//0.00040
    double i = 0.00000;//0.00000295
    double d  = 0.0004;//0.000162
    double f = 0.00018;
    
    kP = p; 
    kI = i;
    kD = d; 
  
    kIz = 0.0; 
    kFF = 0.0001625; //loeft =0.0001505 
    kMaxOutput = 1; 
    kMinOutput = -1;
    maxRPM = 3500;

    // Smart Motion Coefficients
    maxVel = 5500; // rpm
    maxAcc = 3000;

    kP2 = p;//0.000065
    kI2 = i;// 0.0000029
    kD2 = d; //0.00095
    kIz2 = 0; 
    kFF2 = 0.0001669;// working ff 0.0001549; //right motor
    kMaxOutput2 = 1; 
    kMinOutput2 = -1;
    maxRPM2 = 3500;

    // Smart Motion Coefficients
    maxVel2 = 5500; // rpm
    maxAcc2 = 3000;
    // set PID coefficients
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);

    //leftDriveMaster.setControlFramePeriodMs(periodMs);
    //m_pidController.
    leftDriveMaster.getOutputCurrent();
    leftDriveMaster.setPeriodicFramePeriod(PeriodicFrame.kStatus1, 5);
    rightDriveMaster.setPeriodicFramePeriod(PeriodicFrame.kStatus1,5);
    
    leftEncoder.getVelocity();
    m_pidController2.setP(kP2);
    m_pidController2.setI(kI2);
    m_pidController2.setD(kD2);
    m_pidController2.setIZone(kIz2);
    m_pidController2.setFF(kFF2);
    m_pidController2.setOutputRange(kMinOutput2, kMaxOutput2);
    /**
     * Smart Motion coefficients are set on a CANPIDController object
     * 
     * - setSmartMotionMaxVelocity() will limit the velocity in RPM of
     * the pid controller in Smart Motion mode
     * - setSmartMotionMinOutputVelocity() will put a lower bound in
     * RPM of the pid controller in Smart Motion mode
     * - setSmartMotionMaxAccel() will limit the acceleration in RPM^2
     * of the pid controller in Smart Motion mode
     * - setSmartMotionAllowedClosedLoopError() will set the max allowed
     * error for the pid controller in Smart Motion mode
     */
    int smartMotionSlot = 0;
    m_pidController.setSmartMotionMaxVelocity(maxVel, smartMotionSlot);
    m_pidController.setSmartMotionMinOutputVelocity(minVel, smartMotionSlot);
    m_pidController.setSmartMotionMaxAccel(maxAcc, smartMotionSlot);
    m_pidController.setSmartMotionAllowedClosedLoopError(allowedErr, smartMotionSlot);

    m_pidController2.setSmartMotionMaxVelocity(maxVel2, smartMotionSlot);
    m_pidController2.setSmartMotionMinOutputVelocity(minVel2, smartMotionSlot);
    m_pidController2.setSmartMotionMaxAccel(maxAcc2, smartMotionSlot);
    m_pidController2.setSmartMotionAllowedClosedLoopError(allowedErr2, smartMotionSlot);
    m_pidController.setSmartMotionAccelStrategy(AccelStrategy.kSCurve, smartMotionSlot);
    m_pidController2.setSmartMotionAccelStrategy(AccelStrategy.kSCurve, smartMotionSlot);
    //leftDriveMaster.setClosedLoopRampRate(.5);

    // gyro/pigeon/navx

  }
  public double returnAngle(){
    return imu.getAngle();
  }
  
  public void setVelocity(double left_velocity,double right_velocity, double heading){
    m_pidController.setReference(-left_velocity+heading,ControlType.kVelocity);
    m_pidController2.setReference(right_velocity+heading,ControlType.kVelocity);
  }
  public double returnLeftVelocity(){
    return leftEncoder.getVelocity();
  }
  public double returnRightVelocity(){
    return rightEncoder.getVelocity();
  }
  public String[] getPIDVariables(){
    String[] variables = new String[5];
    variables[0] = "variables";
    variables[0] = "p" + leftDriveMaster.getPIDController().getP();
    
    variables[1] = "i" + leftDriveMaster.getPIDController().getI();
    
    variables[2] = "d" + leftDriveMaster.getPIDController().getD();
    
    variables[3] = "f" + leftDriveMaster.getPIDController().getFF();
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
    leftDriveMaster.set(speed + turn);
    rightDriveMaster.set(-speed+turn);
  }

  @Override
  public void periodic() {
    
  }
  public void resetNavX() {
    imu.reset();
  }
  public double reportEncoder(){
    return leftEncoder.getPosition();
  }
  public void calibrateIMU(){
    imu.calibrate();
  }

}

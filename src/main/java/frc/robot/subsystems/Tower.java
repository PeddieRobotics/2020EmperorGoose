/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Auto.PIDClasses.NEO;
import frc.robot.Framework.MovingAverage;

public class Tower extends SubsystemBase {

  public static enum TowerModeType {
    INDEXING, DISABLED, REVERSE
  }

  private TowerModeType currentMode;

  private NEO topMotor, bottomMotor;
  private AnalogInput m_topSensor0, m_topSensor1, m_bottomSensor2, m_bottomSensor3;
  private DigitalInput testTop0, testTop1, testBottom2, testBottom3;

  private MovingAverage bottom3Avg, bottom2Avg, top1Avg, top0Avg;

  public Tower() {
    
    /*currentMode = TowerModeType.DISABLED;

    topMotor = new NEO( Constants.TOWER_BOTTOM );
    bottomMotor = new NEO( Constants.TOWER_TOP );
    topMotor.setBrake();
    bottomMotor.setBrake();
    
    bottom3Avg = new MovingAverage(5);
    
    bottom2Avg = new MovingAverage(20);
    top1Avg = new MovingAverage(5);
    top0Avg = new MovingAverage(5);

    m_topSensor0 = new AnalogInput(0);
    m_topSensor1 = new AnalogInput(1);
    m_bottomSensor2 = new AnalogInput(2);
    m_bottomSensor3 = new AnalogInput(3);
    topMotor.setSmartCurrentLimit(15);
    bottomMotor.setSmartCurrentLimit(15);*/

    testTop0 = new DigitalInput(0);
    testTop1 = new DigitalInput(1);
    testBottom2 = new DigitalInput(2);
    testBottom3 = new DigitalInput(3);
  }

  @Override
  public void periodic() {
    SmartDashboard.putBoolean("Top Sensor 0", testTop0.get());
    SmartDashboard.putBoolean("Top Sensor 1", testTop1.get());
    SmartDashboard.putBoolean("Top Sensor 2", testBottom2.get());
    SmartDashboard.putBoolean("Top Sensor 3", testBottom3.get());
  }

  public void reverse(double percent){

    topMotor.set(-percent);
    bottomMotor.set(percent);
  }

  public void sampleSensors(){
    top0Avg.add(m_topSensor0.getVoltage());
    top1Avg.add(m_topSensor1.getVoltage());
    bottom2Avg.add(m_bottomSensor2.getVoltage());
    bottom3Avg.add(m_bottomSensor3.getVoltage());

  }

  /**
   * runs the top motor
   * @param speed speed of motor
   */
  public void runTopMotor( double speed ) {

    topMotor.set( speed );
    

  }

  
  /**
   * runs the bottom motor
   * @param speed speed of motor
   */
  public void runBottomMotor(double speed)
  {
    bottomMotor.set(-speed);
  }
  
  /**
   * runs both motors at the same speed
   * @param speed speed of motors
   */
  public void runMotors( double speed ) {

    topMotor.set( speed );
    bottomMotor.set( -speed );
    
    if(speed > 0.0){
      currentMode = TowerModeType.INDEXING;
    }
    else if(speed == 0.0){
      currentMode = TowerModeType.DISABLED;
    }
    else{
      currentMode = TowerModeType.REVERSE;
    }
     }

  /**
   * does the base of the tower sense a ball inside it?
   * @return boolean of whether there is a ball at the base of the tower or not
   */
  public boolean senses_ball_Bottom() {
    bottom2Avg.add(m_bottomSensor2.getVoltage()+m_bottomSensor3.getVoltage());

    if ( bottom2Avg.get()< 7) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * does the top of the tower sense a ball inside it?
   * @return boolean of whether there is a ball at the top of the tower or not
   */
  public boolean senses_ball_Top0() {
    top0Avg.add(m_topSensor0.getVoltage());
    if ( top0Avg.get() < 3.0 ) {
      return true;
    } else {
      return false;
    }

  }
  public boolean senses_ball_Top1() {
    top1Avg.add(m_topSensor1.getVoltage());
    if ( top1Avg.get() < 3.0 ) {
      return true;
    } else {
      return false;
    }
  }

  public void stopAll(){
    runMotors(0.0);
  }
  public double topMotorSpeed(){
    return topMotor.getEncoder().getVelocity();
  }

  public double bottomMotorSpeed(){
    return bottomMotor.getEncoder().getVelocity();
  }

  public double getTopMotorSpeed(){
    return topMotor.getEncoder().getVelocity();
  }

  public double getBottomMotorSpeed(){
    return bottomMotor.getEncoder().getVelocity();
  }

  public TowerModeType getCurrentMode(){
    return currentMode;
  }

}
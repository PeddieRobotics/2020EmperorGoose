/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Auto.PIDClasses.NEO;

public class Tower extends SubsystemBase {
  private NEO topMotor, bottomMotor;
  private final AnalogInput m_topSensor0, m_topSensor1, m_bottomSensor2, m_bottomSensor3;
  
   public Tower() {
    topMotor = new NEO(Constants.TOWER_TOP);
    bottomMotor = new NEO(Constants.TOWER_BOTTOM);
    topMotor.setBrake();
    bottomMotor.setBrake();
    m_topSensor0 = new AnalogInput(0);
    m_topSensor1 = new AnalogInput(1);
    m_bottomSensor2 = new AnalogInput(2);
    m_bottomSensor3 = new AnalogInput(3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runTopMotor(double speed){
    topMotor.set(speed);
    bottomMotor.set(0);
  }
  public void runBottomMotor(double speed) {
    topMotor.set(0);
    bottomMotor.set(-speed);
  }
  
  public void runMotors(double speed) {
    topMotor.set(speed);
    bottomMotor.set(-speed);
  }
  public boolean senses_ball_Bottom()
  {
    if (m_bottomSensor2.getVoltage() < 3||m_bottomSensor3.getVoltage()<3) 
    {
      return true;
    }
    else 
    {
      return false;
    }
  }
  public void printSensorVolts(){
    SmartDashboard.putNumber("volatage of one", m_topSensor0.getVoltage());
    SmartDashboard.putNumber("volatage of two", m_topSensor1.getVoltage());
    SmartDashboard.putNumber("volatage of three", m_bottomSensor2.getVoltage());
    SmartDashboard.putNumber("volatage of four", m_bottomSensor3.getVoltage());
  
  }
  public boolean senses_ball_Top()
  {

    if (m_topSensor0.getVoltage() < 3||m_topSensor1.getVoltage()<3) 
    {
      return true;
    }
    else 
    {
      return false;
    }
  }

}
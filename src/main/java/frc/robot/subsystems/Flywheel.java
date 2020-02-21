/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANPIDController;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Auto.PIDClasses.NEO;
import frc.robot.Auto.PIDClasses.NEOPIDWithSmartDashboard;
import frc.robot.Constants;

public class Flywheel extends SubsystemBase {
  /**
   * Creates a new Flywheel.
   */
  NEO leftMotor, rightMotor;
  CANPIDController m_pidController, m_pidController2;
  public Flywheel() {
    leftMotor = new NEO(Constants.FLYWHEEL_1);
    rightMotor = new NEO(Constants.FLYWHEEL_2);
    //NEOPIDWithSmartDashboard left = new NEOPIDWithSmartDashboard(Constants.FLYWHEEL_1);
    //NEOPIDWithSmartDashboard right = new NEOPIDWithSmartDashboard(Constants.FLYWHEEL_2);
    leftMotor.addPIDController(Constants.flywheelP, Constants.flywheelD, Constants.flywheelI, Constants.flywheelFF, 0);
    rightMotor.addPIDController(Constants.flywheelP, Constants.flywheelD, Constants.flywheelI, Constants.flywheelFF, 0);
    //NEOPIDWithSmartDashboard tower1 = new NEOPIDWithSmartDashboard(11);
    //NEOPIDWithSmartDashboard tower2 = new NEOPIDWithSmartDashboard(12);

    
  }

  /**
   * runs the flywheel
   * @param setpoint speed of the flywheel
   */
  public void setSpeed( double setpoint ) {

    leftMotor.setVelocity(setpoint);
    rightMotor.setVelocity(-setpoint);

  }

  @Override
  public void periodic() {
    //leftMotor.set(0.1);
    //rightMotor.set(-0.1);
    //DriverStation.reportError("running perioidic",false);
    // This method will be called once per scheduler run
  }
}

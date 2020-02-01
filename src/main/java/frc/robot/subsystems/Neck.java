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
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Neck extends SubsystemBase {
  private final CANSparkMax topMotor, bottomMotor;
  
  public Neck() {
    topMotor = new CANSparkMax(0, MotorType.kBrushless);
    bottomMotor = new CANSparkMax(1, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void runBottomMotor(double speed) {
    bottomMotor.set(speed);
  }

  public void runMotors(double speed) {
    topMotor.set(speed);
    bottomMotor.set(speed);
  }
}
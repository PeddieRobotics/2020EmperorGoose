/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Auto.PIDClasses.NEOPIDWithSmartDashboard;
import frc.robot.Auto.PIDClasses.TalonSRXWithSmartDashboard;

public class TestSubsytem extends SubsystemBase {
  /**
   * Creates a new TestSubsytem.
   */
Solenoid solenoid1;
Solenoid solenoid2;
Solenoid solenoid3;
Solenoid solenoid4;
TalonSRX one;
TalonSRX two;
TalonSRX three;
  public TestSubsytem() {
    SmartDashboard.putNumber("onePercent",0.0);
    SmartDashboard.putNumber("twoPercent",0.0);
    SmartDashboard.putNumber("threePercent",0.0);
    SmartDashboard.putNumber("fourPercent",0.0);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

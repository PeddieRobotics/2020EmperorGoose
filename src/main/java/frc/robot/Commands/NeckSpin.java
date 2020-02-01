/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Neck;

public class NeckSpin extends CommandBase {
  private final Neck m_neck;
  private final AnalogInput analogT, analogB;

  public NeckSpin(Neck neck) {
    m_neck = neck;
    analogT = new AnalogInput(0);
    analogB = new AnalogInput(1);
    addRequirements(neck);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (analogT.getVoltage() < 3 && analogB.getVoltage() <3) {
      m_neck.runMotors(15.0);
    }

    if (analogT.getVoltage() < 3 && analogB.getVoltage() > 3) {
      m_neck.runMotors(15.0);
    }

    if (analogT.getVoltage() > 3 && analogB.getVoltage() < 3) {
      m_neck.runBottomMotor(15.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (analogT.getVoltage() > 4 && analogB.getVoltage() > 4);
  }
}

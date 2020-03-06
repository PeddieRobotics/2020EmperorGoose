/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tower;

public class StopIntake extends CommandBase {
  
  private Intake m_intake;
  private Hopper m_hopper;
  private double motorTimer;

  public StopIntake(Intake intake, Hopper hopper) {
    m_intake = intake;
    m_hopper = hopper;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intake.raiseIntake();
    m_hopper.stopAll();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motorTimer = Timer.getFPGATimestamp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (motorTimer > Constants.INTAKE_MOTOR_OFF_DELAY);
  }
}

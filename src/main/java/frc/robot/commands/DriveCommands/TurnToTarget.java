/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TurnToTarget extends CommandBase {
  /**
   * Creates a new TurnToTarget.
   */
  Drivetrain m_drivetrain;
  double goalAngle = 0;

  double headingErrorToRpmConstant = 5;
  public TurnToTarget(Drivetrain drivetrain, double angle) {
    m_drivetrain = drivetrain;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    goalAngle = m_drivetrain.returnAngle() + goalAngle;// add current angle to where we want to be
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //use the velocity pid
    m_drivetrain.setVelocity(0, 0, headingErrorToRpmConstant*(goalAngle - m_drivetrain.returnAngle()), 0, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class ButtonAim extends CommandBase {
  /**
   * Creates a new buttonAim.
   */
  Limelight m_limelight;
  Drivetrain m_drivetrain;
  double tx;
  double heading_error;
  double Kp = -0.1;
  double min_command = 0.05;
  double steering_adjust;

  public ButtonAim(Drivetrain d, Limelight l) {
    m_limelight = l;
    m_drivetrain = d;
    addRequirements(d);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    tx = m_limelight.getTx();
    heading_error = -tx;

    if(tx > 1.0)
      steering_adjust = Kp * heading_error -  min_command;
    else if(tx < 1.0)
      steering_adjust = Kp*heading_error + min_command;
    m_drivetrain.arcadeDrive(-steering_adjust, steering_adjust);
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

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

public class TurnUntilSeesTarget extends CommandBase {
  /**
   * Creates a new TurnUntilSeesTarget.
   */
  Limelight m_limelight; 
  Drivetrain m_drivetrain;
  double count = 5;
  public TurnUntilSeesTarget(Drivetrain drivetrain, Limelight limelight) {
    m_limelight = limelight;
    m_drivetrain = drivetrain;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    count = 5;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_limelight.hasTarget()){
      count--;
    }
    m_drivetrain.setTurn(.2);
    m_drivetrain.run();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setSpeed(0);
    m_drivetrain.setTurn(0);
    m_drivetrain.run();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return count<=0;
  }
}
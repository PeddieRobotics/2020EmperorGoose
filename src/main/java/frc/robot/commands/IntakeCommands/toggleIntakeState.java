package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class toggleIntakeState extends CommandBase {
  /**
   * Creates a new toggleHopperState.
   */
  Intake m_Intake;

  /**
   * @param rcIntake Intake subsystem
   */
  public toggleIntakeState( Intake rcIntake ) {
 
    m_Intake = rcIntake;
    addRequirements( rcIntake );

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_Intake.startIntake();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Intake.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

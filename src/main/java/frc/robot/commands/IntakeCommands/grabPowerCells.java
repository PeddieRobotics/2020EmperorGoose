package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class grabPowerCells extends CommandBase {
  /**
   * Creates a new grabPowerCells.
   */
  Intake m_Intake;

  /**
   * @param rcIntake Intake subsystem
   */
  public grabPowerCells( Intake rcIntake ) {

    m_Intake = rcIntake;
    addRequirements(rcIntake);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_Intake.startIntake();
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    DriverStation.reportError( "Has been interupted", false );

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class Intaking extends CommandBase {

  private Intake intake;

  public Intaking() {
    // Use addRequirements() here to declare subsystem dependencies.

    intake = new Intake();

    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  public void initialize() {

    intake.intake( true );

  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  public void end(boolean interrupted) {

    intake.intake( false );

  }

  // Returns true when the command should end.
  public boolean isFinished() {

    return false;
    
  }
}

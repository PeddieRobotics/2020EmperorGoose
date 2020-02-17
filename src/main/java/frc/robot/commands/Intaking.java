package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class Intaking extends CommandBase {

  private Intake intake;
  private boolean reverse1;
  private boolean moving;
  public Intaking(Intake intake1, boolean move, boolean reverse) {
    // Use addRequirements() here to declare subsystem dependencies.
    reverse1 = reverse;
    intake = intake1;
    moving = move;

    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    if (moving && reverse1) {
      intake.reverse();
    }
    else if (!moving) {
      intake.disable();
    }
    else if (moving && !reverse1) {
      intake.intaking();
    }
  }

  // Called once the command ends or is interrupted.
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  public boolean isFinished() {

    return false;
    
  }
}

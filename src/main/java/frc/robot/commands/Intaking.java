package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

public class Intaking extends CommandBase {

  private Intake intake;
  private boolean isReversing;
  private boolean isMoving;
  public Intaking(Intake intakeSubsystem, boolean move, boolean reverse) {
    // Use addRequirements() here to declare subsystem dependencies.
    isReversing = reverse;
    intake = intakeSubsystem;
    isMoving = move;

    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    if (isMoving && isReversing) {  //call intake command with it moving AND reversing -> it reverses
      intake.reverse();
    }
    else if (!isMoving) {           //say moving is false and it stops spinning
      intake.disable();
    }
    else if (isMoving && !isReversing) {  //normal intake if moving and not reversing
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

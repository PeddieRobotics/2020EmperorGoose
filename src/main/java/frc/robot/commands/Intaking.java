package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;

/**                                  *****                                              *
 *                                                                                      *
 *                                                                                      *
 * NOTE: THIS COMMAND IS JANKY. Needs organization, and to be moved to "IntakeCommands" *
 *                                                                                      *
 *                                                                                      *
 *                                   *****                                              */

public class Intaking extends CommandBase {

  private Intake intake;
  private boolean isReversing;
  private boolean isMoving;

  /**
   * @param rcIntake Intake subsystem
   * @param b_IsMoving if true, the intake is moving
   * @param b_IsReversing if true, the intake is REVERSING
   */
  public Intaking(Intake rcIntake, boolean b_IsMoving, boolean b_IsReversing) {
    // Use addRequirements() here to declare subsystem dependencies.
    isReversing = b_IsReversing;
    isMoving = b_IsMoving;
    intake = rcIntake;

    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    if (isMoving && isReversing) {
      intake.reverse();
    }
    else if (!isMoving) {
      intake.disable();
    }
    else if (isMoving && !isReversing) {
      intake.intake();
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

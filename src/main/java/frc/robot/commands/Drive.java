package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.RobotContainer;


public class Drive extends CommandBase {
  /**
   * Creates a new ArcadeDrive.
   */
  private final Drivetrain drive;
  private final RobotContainer rContainer;


  public Drive( Drivetrain drivetrain, RobotContainer rC ) {

    drive = drivetrain;
    rContainer = rC;
    addRequirements( drivetrain );

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    drive.periodic( rContainer.getSpeed(), rContainer.getTurn());

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

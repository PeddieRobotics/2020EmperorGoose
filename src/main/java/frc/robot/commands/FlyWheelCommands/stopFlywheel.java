package frc.robot.commands.FlyWheelCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class stopFlywheel extends CommandBase {
  /**
   * Creates a new stopFlywheel.
   */
  Shooter m_Shooter;

  /**
   * @param rcShooter shooter subsystem
   */
  public stopFlywheel( Shooter rcShooter ) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_Shooter = rcShooter;
    addRequirements(rcShooter);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
<<<<<<< HEAD

    m_Shooter.disable();  //disables

=======
    m_Shooter.disable();
>>>>>>> 16945688bb9e4d3489cc4444ec1136fd21f2c9e4
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

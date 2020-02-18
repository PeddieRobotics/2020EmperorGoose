package frc.robot.commands.FlyWheelCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class startFlywheel extends CommandBase {
  /**
   * Creates a new startFlywheel.
   */
  Shooter m_Shooter; 

  /**
   * @param rcShooter Shooter subsystem
   */
  public startFlywheel( Shooter rcShooter ) {

    m_Shooter = rcShooter;
    addRequirements( rcShooter );
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putNumber( "setpoint", 0.0 );
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_Shooter.setMotors(SmartDashboard.getNumber( "setpoint", 0.0 ) );

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

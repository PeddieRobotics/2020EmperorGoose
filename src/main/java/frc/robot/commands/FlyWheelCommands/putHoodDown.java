package frc.robot.commands.FlyWheelCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hood;

public class putHoodDown extends CommandBase {
  /**
   * Creates a new putHoodDown.
   */
  Hood m_Hood;

  /**
   * @param hoodRC Hood subsystem
   */
  public putHoodDown( Hood hoodRC ) {

    m_Hood = hoodRC;
    addRequirements( hoodRC );
    // Use addRequirements() here to declare subsystem dependencies.

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
<<<<<<< HEAD

    m_Hood.setUp(false);  //puts hood down

=======
    m_Hood.setUp(false);
>>>>>>> 16945688bb9e4d3489cc4444ec1136fd21f2c9e4
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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

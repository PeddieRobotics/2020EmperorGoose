package frc.robot.commands.JoystickCommandGroups;
 
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.subsystems.Tower;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Hopper;
import frc.robot.commands.HopperCommands.stopHopper;
import frc.robot.commands.TowerCommands.stopTower;
import frc.robot.commands.FlyWheelCommands.stopFlywheel;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DisableShootingSubsystems extends ParallelCommandGroup {
  /**
   * Creates a new DisableShootingSubsystems.
   */
  Tower m_Tower;
  Shooter m_Shooter;
  Hopper m_Hopper;

  /**
   * @param rcTower Tower subsystem
   * @param rcShooter Flywheel subsystem
   * @param rcHopper Hopper subsystem
   */
  public DisableShootingSubsystems( Tower rcTower, Shooter rcShooter, Hopper rcHopper ) {
    
    super();
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();

    addCommands ( new stopHopper( m_Hopper ) );
    addCommands( new stopFlywheel( m_Shooter ) );
    addCommands( new stopTower( m_Tower ) );

  }
}

package frc.robot.commands.JoystickCommandGroups;
 
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

import frc.robot.subsystems.Tower;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hopper;
import frc.robot.commands.HopperCommands.StopHopper;
import frc.robot.commands.TowerCommands.StopTower;
import frc.robot.commands.FlywheelCommands.StopFlywheel;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DisableShootingSubsystems extends ParallelCommandGroup {
  /**
   * Creates a new DisableShootingSubsystems.
   */
  Tower m_tower;
  Flywheel m_flywheel;
  Hopper m_hopper;

  /**
   * @param rcTower Tower subsystem
   * @param rcShooter Flywheel subsystem
   * @param rcHopper Hopper subsystem
   */
  public DisableShootingSubsystems( Tower rcTower, Flywheel rcFlywheel, Hopper rcHopper ) {
    
    super();
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();

    addCommands ( new StopHopper( m_hopper ) );
    addCommands( new StopFlywheel( m_flywheel ) );
    addCommands( new StopTower( m_tower ) );

  }
}

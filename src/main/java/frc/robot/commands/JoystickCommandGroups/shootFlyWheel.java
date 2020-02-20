/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.JoystickCommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FlyWheelCommands.runFlywheel;
import frc.robot.commands.FlyWheelCommands.startFlywheel;
import frc.robot.commands.HopperCommands.stopHopper;
import frc.robot.commands.TowerCommands.runAllSystems;
import frc.robot.commands.TowerCommands.stopTower;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tower;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class shootFlyWheel extends SequentialCommandGroup {
  /**
   * Creates a new shootFlyWheel.
   */
  Tower m_Tower;
  Shooter m_Shooter;
  Hopper m_Hopper;
  public shootFlyWheel(Tower towerRC, Shooter shooterRC, Hopper hopperRC) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new ParallelCommandGroup(new startFlywheel(shooterRC), 
    new stopTower(towerRC), new stopHopper(hopperRC)), new ParallelCommandGroup(new runAllSystems(towerRC, hopperRC), 
    new runFlywheel(shooterRC)));

    m_Tower=towerRC;
    m_Shooter = shooterRC;
    m_Hopper = hopperRC;

  }
}

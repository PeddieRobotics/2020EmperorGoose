/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.AutoCommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.PathFollower;
import frc.robot.commands.sendStuffToDS;
import frc.robot.commands.JoystickCommandGroups.shootFlyWheel;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tower;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class testAuto extends SequentialCommandGroup {
  /**
   * Creates a new testAuto.
   */
  public testAuto(Hopper hopperRC, Tower towerRC, Shooter shooterRC, PathFollower path) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super( new ParallelRaceGroup(new shootFlyWheel(towerRC,shooterRC,hopperRC), path, new WaitCommand(5)));
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.AutoCommands.FollowPath;
import frc.robot.commands.MiscCommands.SendStuffToDS;
import frc.robot.commands.JoystickCommands.ShootFlywheel;
import frc.robot.commands.TowerCommands.RunTowerBasedOffFlyWheel;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Tower;
import frc.robot.commands.FlywheelCommands.*;

public class TestAuto extends SequentialCommandGroup {

  public TestAuto(Hopper hopper, Tower tower, Flywheel flywheel, Hood hood) {

    super( new ParallelRaceGroup(new ShootFlywheel(tower, flywheel, hopper, 3350),
          new FlywheelHasShot(tower, 3, flywheel),
          new RaiseHood(hood)));
  }
}

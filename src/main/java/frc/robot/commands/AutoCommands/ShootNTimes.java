/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.AutoCommands.FollowPath;
import frc.robot.commands.DriveCommands.driveOffLine;
import frc.robot.commands.JoystickCommands.ShootFlywheel;
import frc.robot.commands.TowerCommands.RunTowerBasedOffFlyWheel;
import frc.robot.commands.TowerCommands.ShootCounter;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Tower;
import frc.robot.commands.FlywheelCommands.*;

public class ShootNTimes extends SequentialCommandGroup {

  public ShootNTimes(Tower tower, Flywheel flywheel, double rpm, int numberOfBalls) {
    
    super(new ParallelRaceGroup(new ShootFromFar(flywheel, rpm, true), new ShootCounterWithFlywheel(flywheel, numberOfBalls)));
    
  }
}

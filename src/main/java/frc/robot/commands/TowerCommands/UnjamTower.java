/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// REDUNDANT COMMAND -- add m_Tower.runMotors(0) to the end() methods of the other tower commands

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Tower;

public class UnjamTower extends CommandBase {
  
  private final Tower m_tower;
  private final Hopper m_hopper;
  private final double m_percent;

  public UnjamTower(final Tower tower, final Hopper hopper, final double percent) {
    m_tower = tower;
    m_hopper = hopper;
    m_percent = percent;
    addRequirements(tower, hopper);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_tower.reverse(m_percent);
    m_hopper.reverse(m_percent);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
      //will index powerCells automatically, its default command
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

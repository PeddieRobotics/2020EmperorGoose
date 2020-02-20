/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.HopperCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Tower;

public class stopHopper extends CommandBase {
  /**
   * Creates a new feedToTower.
   */
  Hopper m_Hopper;
  public stopHopper(Hopper hopperRC) {
    m_Hopper = hopperRC;
    addRequirements(hopperRC);
  
  }
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Hopper.setLeftWall(0);
    m_Hopper.setRightWall(0);
    m_Hopper.setFloor(0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}

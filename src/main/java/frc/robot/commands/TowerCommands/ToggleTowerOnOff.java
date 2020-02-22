/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;

public class ToggleTowerOnOff extends CommandBase {
  
  private Tower m_tower;

  public ToggleTowerOnOff(Tower tower) {
    m_tower = tower;
    addRequirements(tower);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Depending on whether the tower motors are on, switch to the opposite state
    // Should not be actively indexing either way
    if(m_tower.isRunningForward()){
        m_tower.runMotors(0.0);
        m_tower.setCurrentMode(Tower.TowerModeType.DISABLED);
    }
    else{
        m_tower.runMotors(0.5);
        m_tower.setCurrentMode(Tower.TowerModeType.FORWARD);
    }
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
    return true;
  }
}

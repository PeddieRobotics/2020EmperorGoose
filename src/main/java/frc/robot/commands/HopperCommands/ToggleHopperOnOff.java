/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.HopperCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class ToggleHopperOnOff extends CommandBase {

  private Hopper m_hopper;

  public ToggleHopperOnOff(Hopper hopper) {
    m_hopper = hopper;
    addRequirements(hopper);
  
  }
  @Override
  public void initialize() {
      // Depending on whether the hopper is sending power cells to the tower, switch to the opposite state
    if(m_hopper.isIntaking()){
        m_hopper.setLeftWall(-.2);
        m_hopper.setRightWall(-.5);
        m_hopper.setFloor(-.32);
    }
    else{
        m_hopper.stopAll();
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
    return false;
  }
}

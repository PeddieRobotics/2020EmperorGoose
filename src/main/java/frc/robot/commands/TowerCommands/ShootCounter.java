/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;

public class ShootCounter extends CommandBase {
  
  private boolean prevSenseBall0;
  private Tower m_tower;
  private int shotsToFire;
  private int counter;
   
  public ShootCounter(Tower tower, int shots) {
    m_tower = tower;
    counter = 0;
    
    shotsToFire = shots;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    counter = 0;
    prevSenseBall0 = m_tower.senses_ball_Top0(); // Track the initial state of the top sensor
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean isTopSensorActive = m_tower.senses_ball_Top0();
    SmartDashboard.putBoolean("TopSensorActive", isTopSensorActive);
    
    // If the top sensor is off, but last time, it was on, a ball left the tower
    if(!isTopSensorActive && prevSenseBall0){
      counter++;
    }
  
    // Track the most recent state of the top sensor
    prevSenseBall0 = isTopSensorActive;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return (counter >= shotsToFire);
  }
}

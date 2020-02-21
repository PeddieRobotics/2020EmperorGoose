/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Framework.Logging.CSVLogger;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Tower;

public class runTowerBasedOffFlyWheel extends CommandBase {
  /**
   * Creates a new runTowerBasedOffFlyWheel.
   */
  Hopper m_Hopper;
  Tower m_Tower;
  Shooter m_Shooter;
  public runTowerBasedOffFlyWheel(Hopper rcHopper, Tower rcTower, Shooter rcShooter) {
  
    m_Shooter = rcShooter;
    m_Tower = rcTower;
    m_Hopper = rcHopper;
  
  }
  

@Override
  public void initialize() {
  }

  @Override
  public void execute() {
    
    if(Math.abs(m_Shooter.getAvgVelocity()-3300)<40){
      m_Tower.runMotors(.5);
      m_Hopper.runAll(-.5,.5,-.2);
    }  
    else {
      m_Tower.runMotors(0);
      m_Hopper.runAll(0,0,0);
    }

  }

  @Override
  public void end(boolean interrupted) {
  
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

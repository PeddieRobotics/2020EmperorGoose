/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Tower;

public class RunTowerBasedOffFlyWheel extends CommandBase {
  /**
   * Creates a new runTowerBasedOffFlyWheel.
   */
  private Hopper m_hopper;
  private Tower m_tower;
  private Flywheel m_flywheel;
  double rpm;
  public RunTowerBasedOffFlyWheel(Hopper hopper, Tower tower, Flywheel flywheel, double rpm) {
    this.rpm = rpm;
    m_flywheel = flywheel;
    m_tower = tower;
    m_hopper = hopper;
  
  }
  
@Override
  public void initialize() {
  }

  @Override
  public void execute() {
    DriverStation.reportError("running",false);
    if(Math.abs(m_flywheel.getAvgVelocity()-rpm)<1000){
      m_tower.runMotors(.5);
      m_hopper.runAll(); 
    }  
    else {
      m_tower.runMotors(0);
      m_hopper.stopAll();
    }

  }

  @Override
  public void end(boolean interrupted) {
    m_tower.runMotors(0);
    m_hopper.stopAll();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

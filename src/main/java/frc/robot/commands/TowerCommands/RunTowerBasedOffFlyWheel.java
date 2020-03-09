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
import frc.robot.subsystems.Hopper;
import frc.robot.Constants;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Tower;

public class RunTowerBasedOffFlyWheel extends CommandBase {
  /**
   * Creates a new runTowerBasedOffFlyWheel.
   */
  private Hopper m_hopper;
  private Tower m_tower;
  private Flywheel m_flywheel;
  private double setpoint;
  private int shootingThreshold;

  public RunTowerBasedOffFlyWheel(Hopper hopper, Tower tower, Flywheel flywheel) {
    m_flywheel = flywheel;
    m_tower = tower;
    m_hopper = hopper;
    addRequirements(hopper);
    addRequirements(tower);
    
  }
  
@Override
  public void initialize() {
    m_hopper.runAll(-0.5, 0.5, 0.5); 
  }

  @Override
  public void execute() {
    setpoint = m_flywheel.getSetpoint();

  //if robot is shooting from trench or behind init line, 
  //need a higher accuracy. if layup, range of error is larger. 
  if(m_flywheel.isHoodUp()) 
    shootingThreshold = Constants.THRESHOLD_FAR;
  else  
    shootingThreshold = Constants.THRESHOLD_LAYUP;

    //Checking whether the speed of flywheel is good enough to shoot
    if(Math.abs(m_flywheel.getAvgVelocity()-setpoint)<shootingThreshold){
      m_tower.runMotors(Constants.TOWER_SHOT_SPEED);
      m_hopper.runAll(-0.2, 0.8, 0.5); 
    }
    else {
      m_tower.runTopMotor(0.0);
    }

  }

  @Override
  public void end(boolean interrupted) {
    m_tower.stopAll();
    m_hopper.stopAll();
  }
 
  @Override
  public boolean isFinished() {
    return false;
  }
}

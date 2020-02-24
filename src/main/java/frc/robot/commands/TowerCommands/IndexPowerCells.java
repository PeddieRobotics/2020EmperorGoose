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
import frc.robot.subsystems.Tower;

public class IndexPowerCells extends CommandBase {
  
  private Tower m_tower;
  private Hopper m_hopper; 
  
  public IndexPowerCells(Tower tower, Hopper hopper) {
    m_hopper = hopper;
    m_tower = tower;
    addRequirements(hopper);
    addRequirements(tower);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    m_tower.printSensorVolts();
    // top sensor 1 does not detect a ball
    if(!m_tower.senses_ball_Top1()){
      DriverStation.reportError("running all",false);
      m_tower.runMotors(.8);
      m_hopper.runAll();
    }
    // top sensors 0 and 1 both detect a ball
    else if(m_tower.senses_ball_Top0()){
      DriverStation.reportError("sense top, reversing", false);
      m_tower.runMotors(-.15);
      m_hopper.stopAll();
    }
    // top sensor 1 detects a ball, but not top sensor 0
    // also, the bottom sensors don't detect a ball
    else if(!m_tower.senses_ball_Bottom()){
      m_tower.runBottomMotor(0.8);
      DriverStation.reportError("running bottom", false);
      m_hopper.runAll();
    }
    // top sensor 0 detects a ball
    // also, bottom sensors do detect a ball
    else{
      DriverStation.reportError("nothing on all, stopping", false);
      m_tower.runMotors(0.0);
      m_hopper.stopAll();
    }
  
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tower.stopAll();
    m_hopper.stopAll();
    DriverStation.reportError("ending", false);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
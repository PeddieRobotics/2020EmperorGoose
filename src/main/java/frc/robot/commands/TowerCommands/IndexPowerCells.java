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
  private boolean reversing = false;
  private int ballTimeCount = 0;

  public IndexPowerCells(Tower tower, Hopper hopper) {
    m_hopper = hopper;
    m_tower = tower;
    addRequirements(hopper);
    addRequirements(tower);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_tower.setCurrentMode(Tower.TowerModeType.INDEXING);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    m_tower.printSensorVolts();
    if(!m_tower.senses_ball_Top()){
      m_tower.runMotors(0.5);
      //DriverStation.reportError("no balls running all", false);
      m_hopper.runAll(-0.3,0.5,-0.3);
    }
    
    else if(m_tower.senses_ball_Top() && !m_tower.senses_ball_Bottom()&&!reversing){
    
      reversing = true;
      
      m_hopper.runAll(-0.3,0.5,-0.3);
      //DriverStation.reportError("no balls running all", false);
      ballTimeCount = 0;
    
    }
    else if(reversing&&ballTimeCount<10){
      ballTimeCount++;
      
    //  DriverStation.reportError("no balls running all", false);
      m_tower.runTopMotor(-0.5);
      m_tower.runBottomMotor(0);
      m_hopper.runAll(0, 0, 0);
    }
    else if(!m_tower.senses_ball_Bottom()){
      m_tower.runBottomMotor(0.5);
      
    //  DriverStation.reportError("no balls running all", false);
      m_hopper.runAll(-0.3, 0.5,-0.3);
    }
    else{
      m_tower.runMotors(0.0);
      
      m_hopper.stopAll();
    }
  
    // if it has seen a ball and it hasn't been 2 seconds, do nothing
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tower.runMotors(0.0);
    m_hopper.stopAll();
    m_tower.setCurrentMode(Tower.TowerModeType.DISABLED);

    DriverStation.reportError("ending", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tower;

public class IndexPowerCells extends CommandBase {
  
  private Tower m_tower;
  private Hopper m_hopper; 
  private Intake m_intake;
  
  public IndexPowerCells(Tower tower, Hopper hopper, Intake intake) {
    m_hopper = hopper;
    m_tower = tower;
    m_intake = intake;
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
      if(m_intake.isIntaking()){
        // Control the bottom roller
        if(!m_tower.senses_ball_Bottom()){ // If there is no ball at the bottom of the tower
          m_tower.runBottomMotor(0.35);
        }


        else{
          if(m_tower.senses_ball_Top0() || m_tower.senses_ball_Top1())  // If there are two balls in the tower
            m_tower.runBottomMotor(0.0);
          else  // if there is a ball at the bottom but no ball at the top
            m_tower.runBottomMotor(0.35);  
        }

      // Control the tower belts
      // If there is a ball at the top of the tower, but not being sensed by the highest sensor
      if(m_tower.senses_ball_Top0()){
        m_tower.runTopMotor(0.0);
      }

      // If there is a ball at the highest sensor
      else{
        if(m_tower.senses_ball_Top1())
          m_tower.runTopMotor(0.2);
        else
          m_tower.runTopMotor(0.25);
      }

      if( (m_tower.senses_ball_Top0() || m_tower.senses_ball_Top1()) && m_tower.senses_ball_Bottom()){
        m_hopper.stopAll();
      }
      else{
        m_hopper.runAll(-0.5, 0.5, 0.5);
      }
    }
    else{
      m_tower.stopAll();
      m_hopper.stopAll();
    }
    // if it has seen a ball and it hasn't been 2 seconds, do nothing
    
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tower.stopAll();
    m_hopper.stopAll();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
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
    SmartDashboard.putNumber("Tower Lower Current", m_tower.getBottomMotorCurrent());
    //m_tower.isBottomMotorJammed();

    //if(m_tower.isBottomMotorJammed()){
      //m_tower.reverse(Constants.REVERSE_PERCENT_TOWER);
      //m_hopper.reverse(Constants.REVERSE_PERCENT_HOPPER);
    //}
    //In the following code, here is what each sensor is. There are 4 sensors in total.

    // There are two top sensors on the tower:
    // Top 0: First sensor (the top of the top sensors)
    // Top 1: Second Sensor (the bottom of the top sensors)

    // There are also two bottom sensors on the tower:
    // Bottom 2: Third Sensor (the top of the bottom sensors)
    // Bottom 3: Fouth Sensor (the bottom of the bottom sensors)
    //else{
      if(m_intake.isIntaking()){ // Checks if the intake is running

        // Control the bottom roller

        if(!m_tower.senses_ball_Bottom()){ // If there is no ball at the bottom of the tower
          m_tower.runBottomMotor(0.35); // Runs the bottom motor at 35% speed
        }


        else{ // Since we are at the else, this means the bottom sensors detected a ball
          if(m_tower.senses_ball_Top0() || m_tower.senses_ball_Top1())  // If there is ball at the top 
            m_tower.runBottomMotor(0.0); //Stop the bottom motor. The tower is full
          else  // if there is a ball at the bottom but no ball at the top
            m_tower.runBottomMotor(0.35); // keep running the bottom motor
        }

        // Control the tower belts
        
        if(m_tower.senses_ball_Top0()){ // If there is a ball at the highest sensor at the top of the tower
          m_tower.runTopMotor(0.0); // Stop running the top motor
        }
        else{
          if(m_tower.senses_ball_Top1()) // If there is a ball at the top, but not at the very top sensor
            m_tower.runTopMotor(0.2); // run a little slower to Top 0
          else
            m_tower.runTopMotor(0.25); // run the top motor a little faster to bring the ball to the top
        }

        if( (m_tower.senses_ball_Top0() || m_tower.senses_ball_Top1()) && m_tower.senses_ball_Bottom()){ //If there is a ball in the top and the bottom (aka the tower is full)
          m_hopper.stopAll(); // stop the hopper
        }
        else{
          m_hopper.runAll(); // keep the hopper moving if the tower is not full 
        }
    }
    else{ //If the intake is not down and intaking, then we want the tower and the hopper to stop
      m_tower.stopAll();
      m_hopper.stopAll();
    }

  } 
    
  //}
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
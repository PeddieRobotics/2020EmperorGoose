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
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tower;

public class IndexPowerCells extends CommandBase {
  
  private Tower m_tower;
  private Hopper m_hopper; 
  private Intake m_intake;
  private boolean reversing = false;
  private int ballTimeCount = 0;
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
    m_tower.printSensorVolts();
      if(m_intake.isIntaking()){
        m_tower.printSensorVolts();
        if(!m_tower.senses_ball_Top1()){
          DriverStation.reportError("running all",false);
          m_tower.runMotors(.25); // reduced to prevent over-indexing when the flywheel is spinning down
          m_hopper.runAll();
        }
        /*else if(m_tower.senses_ball_Top0()){
          DriverStation.reportError("sense top, reversing",false);
          m_tower.runMotors(-.15);
          m_hopper.stopAll();
        }*/
        else if(!m_tower.senses_ball_Bottom()){
          m_tower.runBottomMotor(0.35); // reduced to prevent over-indexing when the flywheel is spinning down
          DriverStation.reportError("running bottom", false);
          m_hopper.runAll();
        }
        else{
          DriverStation.reportError("noting hon all, stopping", false);
          m_tower.stopAll();
          m_hopper.stopAll(); // changed from run hopper to stop hopper
        }
    }else{
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
    DriverStation.reportError("ending", false);
  }
  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
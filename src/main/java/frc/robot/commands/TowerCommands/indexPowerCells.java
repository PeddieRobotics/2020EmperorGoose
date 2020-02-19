/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.util.WPILibVersion;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Tower;

public class indexPowerCells extends CommandBase {
  /**
   * Creates a new indexPowerCells.
   */
  Tower m_Tower;
  Hopper m_Hopper; 
  boolean reversing=false;
  double startWaitTime = 0;
  int ballTimeCount = 0;
  public indexPowerCells(Tower rcTower, Hopper rcHopper) {
    m_Hopper = rcHopper;
    m_Tower = rcTower;
    addRequirements(rcHopper);
    addRequirements(rcTower);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Tower.printSensorVolts();
    if(!m_Tower.senses_ball_Top()){
      m_Tower.runMotors(1.0);
      //DriverStation.reportError("no balls running all", false);
      m_Hopper.runAll(-0.3,-0.5,-0.2);
    }
    
    else if(m_Tower.senses_ball_Top()&&!m_Tower.senses_ball_Bottom()&&!reversing){
    
      reversing = true;
      
      //DriverStation.reportError("no balls running all", false);
      ballTimeCount = 0;
    
    }
    else if(reversing&&ballTimeCount<4){
      ballTimeCount++;
      
    //  DriverStation.reportError("no balls running all", false);
      m_Tower.runTopMotor(-0.5);
      m_Tower.runBottomMotor(0);
      m_Hopper.runAll(0, 0, 0);
    }
    else if(!m_Tower.senses_ball_Bottom()){
      m_Tower.runBottomMotor(1.0);
      
    //  DriverStation.reportError("no balls running all", false);
      m_Hopper.runAll(-0.3,0.2,-0.3);
    }
    else{
      m_Tower.runMotors(0.0);
      
      m_Hopper.runAll(0.0, 0.0, 0.0);
    }
  
    // if it has seen a ball and it hasn't been 2 seconds, do nothing
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriverStation.reportError("ending", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

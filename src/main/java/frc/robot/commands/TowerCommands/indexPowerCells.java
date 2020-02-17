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
  boolean hasSeenBall=false;
  double startWaitTime = 0;
  
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
    // if it has seen a ball and it hasn't been 2 seconds, do nothing
    if(hasSeenBall&&!(Timer.getFPGATimestamp()-startWaitTime>=2.0)){
      m_Hopper.runAll();    
      // do nothing
    }
    //if it has seen a ball and been more than two seconds but less than 2.2 seconds, run backwards
    else if(hasSeenBall&&(Timer.getFPGATimestamp()-startWaitTime>=2)&&!(Timer.getFPGATimestamp()-startWaitTime>=2.2)){
      m_Tower.runTopMotor(-1.0);
      m_Hopper.runAll();
    }
    //if it hasn't seen a ball and doesn't sense a top keep intaking the balls
    else if (!hasSeenBall&&!m_Tower.senses_ball_Top()) {
      m_Tower.runMotors(1.0);
      m_Hopper.runAll();
    }
    //if it hasn't seen a ball but it does sense a top ball then let it know we've seen a ball, and start the counter
    else if(!hasSeenBall){
      hasSeenBall = true;
      startWaitTime=Timer.getFPGATimestamp();
    }
    // if there's a ball on the top and no ball on the bottom, 
    // then run only the bottom motors and stop the top motors
    else if (m_Tower.senses_ball_Top() && !m_Tower.senses_ball_Bottom()){
      m_Tower.runTopMotor(0);
      m_Tower.runBottomMotor(1.0);
    }

    // if there's a ball on top and bottom, stop everything
    else if (m_Tower.senses_ball_Top() && m_Tower.senses_ball_Bottom()){
      m_Tower.runMotors(0);
      hasSeenBall=false;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
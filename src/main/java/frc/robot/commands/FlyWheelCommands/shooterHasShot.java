/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.FlyWheelCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;
import frc.robot.subsystems.Shooter;

public class shooterHasShot extends CommandBase {
  /**
   * Creates a new flyWheelHasShot.
   */
  Shooter m_Shooter;
  Tower m_Tower;
  int amountOfBallsWeWantToShoot;
  boolean lastState = false;
  
  int currentBallsShot;
  public shooterHasShot(Tower rcTower, int shotCount, Shooter rcShooter) {
    amountOfBallsWeWantToShoot = shotCount;
    m_Tower = rcTower;
    m_Shooter = rcShooter;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      lastState = m_Tower.senses_ball_Bottom();
      currentBallsShot = 0; 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(lastState == true&&!m_Tower.senses_ball_Top()){
      currentBallsShot++;
    }
    lastState= m_Tower.senses_ball_Top();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (currentBallsShot>=amountOfBallsWeWantToShoot);
  }
}

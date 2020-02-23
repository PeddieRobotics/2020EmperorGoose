/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.FlywheelCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;
import frc.robot.subsystems.Flywheel;

public class FlywheelHasShot extends CommandBase {
  
  private Flywheel m_flywheel;
  private Tower m_tower;
  private int amountOfBallsWeWantToShoot;
  private boolean lastState = false;
  
  int currentBallsShot;
  public FlywheelHasShot(Tower tower, int shotCount, Flywheel flywheel) {
    amountOfBallsWeWantToShoot = shotCount;
    m_tower = tower;
    m_flywheel = flywheel;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
      lastState = m_tower.senses_ball_Bottom();
      currentBallsShot = 0; 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(lastState == true&&!m_tower.senses_ball_Top1()){
      currentBallsShot++;
    }
    lastState= m_tower.senses_ball_Top1();

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

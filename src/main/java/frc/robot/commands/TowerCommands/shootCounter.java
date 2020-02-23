/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;

public class ShootCounter extends CommandBase {
  /**
   * Creates a new shootCounter.
   */
  boolean currentTopState; 
  boolean lastTopState;
   Tower m_tower;
  int amountOfShotsWeWant = 0;
  int counter;
   public ShootCounter(Tower tower, int shotCount) {
    m_tower = tower;
    counter = 0;
    amountOfShotsWeWant = shotCount;
    addRequirements(tower);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lastTopState = m_tower.senses_ball_Top0();
    currentTopState = m_tower.senses_ball_Top0();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(currentTopState!=lastTopState){
      counter ++;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return (counter > amountOfShotsWeWant);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;

public class shootCounter extends CommandBase {
  /**
   * Creates a new shootCounter.
   */
  boolean currentTopState; 
  boolean lastTopState;
   Tower m_tower;
  int amountOfShotsWeWant = 0;
  int counter;
   public shootCounter(Tower tower, int shotCount) {
    m_tower = tower;
    counter = 0;
    
    amountOfShotsWeWant = 2*shotCount;// 2 changes for each shot
    addRequirements(tower);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    lastTopState = m_tower.senses_ball_Top0();
    if(lastTopState==true){
      amountOfShotsWeWant -=1; // sub tract one if we already have a ball chambered
    }
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //increment our changes
    //DriverStation.reportError("running it",false);
    if(m_tower.senses_ball_Top0()!=lastTopState){
      counter ++;
    }
    DriverStation.reportError("count"+counter,false);
    lastTopState = m_tower.senses_ball_Top0();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return (counter >= amountOfShotsWeWant);
  }
}

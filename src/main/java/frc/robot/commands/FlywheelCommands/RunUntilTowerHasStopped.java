/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.FlywheelCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Tower;

public class RunUntilTowerHasStopped extends CommandBase {
  /**
   * Creates a new RunUntilTowerHasStopped.
   */
  Tower m_tower;
  Flywheel m_flywheel;
  boolean hasStoppedFlywheel;
  public RunUntilTowerHasStopped(Tower tower, Flywheel flywheel) {
    m_tower = tower;
    m_flywheel = flywheel;
    addRequirements(flywheel);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //get rid of any leftover balls
    if(m_tower.senses_ball_Top0()){
      m_tower.runTopMotor(.8);
      m_flywheel.setMotors(m_flywheel.getSetpoint());
    }
    //if no balls try and stop the tower(100 to ignore any noise in motorspeed)
    else if(m_tower.topMotorSpeed()<=100&&m_tower.bottomMotorSpeed()<=100){
      hasStoppedFlywheel = true;
      m_flywheel.setMotorPercentOutput(0);
      m_tower.runMotors(0);
    
    }
    //run flywheel until motors have pretty much stopped
    else{
      m_flywheel.setMotors(m_flywheel.getSetpoint());
      m_tower.runMotors(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_tower.runMotors(0);
    m_flywheel.setMotorPercentOutput(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return hasStoppedFlywheel;
  }
}

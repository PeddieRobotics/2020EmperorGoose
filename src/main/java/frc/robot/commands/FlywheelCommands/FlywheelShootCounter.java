/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.FlywheelCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Tower;

public class FlywheelShootCounter extends CommandBase {
  /**
   * Creates a new FlywheelShootCounter.
   */
  Flywheel m_flywheel;
  Tower m_tower;
  boolean wasAtSetpoint;
  boolean hasReachedSetpointOnce;
  double lastState = 0;
  double shotCount; 
  public FlywheelShootCounter(Flywheel flywheel, Tower tower, double count) {
    m_flywheel = flywheel;
    shotCount = count;
     m_tower = tower;
     addRequirements(tower);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    wasAtSetpoint = false;
    hasReachedSetpointOnce = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //turn on for rising edge
    if(Math.abs(m_flywheel.getAvgVelocity()-m_flywheel.getSetpoint())<100){
      hasReachedSetpointOnce = true;
      wasAtSetpoint = true;
    
    }

    //falling edge
    if(hasReachedSetpointOnce&&Math.abs(m_flywheel.getAvgVelocity()-m_flywheel.getSetpoint())>200&&Math.abs(lastState-m_flywheel.getSetpoint())<200&&wasAtSetpoint){
      
      wasAtSetpoint = false;
      DriverStation.reportError("detected an edge", false);      
      shotCount--;
    
    }
    SmartDashboard.putNumber("lastState",lastState);
    lastState = m_flywheel.getAvgVelocity();
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

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
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Framework.MovingAverage;
import frc.robot.subsystems.Flywheel;

public class StopFlywheel extends CommandBase {
  
  private Flywheel m_flywheel;

  public StopFlywheel(Flywheel flywheel) {
    m_flywheel = flywheel;
    addRequirements(flywheel);
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_flywheel.disable();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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

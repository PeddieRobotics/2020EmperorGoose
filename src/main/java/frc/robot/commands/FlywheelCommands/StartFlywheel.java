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

public class StartFlywheel extends CommandBase {
  
  private Flywheel m_flywheel;
  private MovingAverage avgOfSpeed;

  public StartFlywheel(Flywheel flywheel) {
    m_flywheel = flywheel;
    addRequirements(flywheel);
    avgOfSpeed = new MovingAverage(10);
    SmartDashboard.putNumber("setpoint",0.0);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    avgOfSpeed.clearInitialize();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  
    m_flywheel.setMotors(3350);
    avgOfSpeed.add(m_flywheel.getSpeed());
    SmartDashboard.putNumber("avg of speed", avgOfSpeed.get());
    SmartDashboard.putNumber("avg value",avgOfSpeed.get());
    CommandScheduler.getInstance().schedule();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriverStation.reportError("done here", false);
    m_flywheel.disable();
  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return ((Math.abs(avgOfSpeed.get()-3350)<100)&&avgOfSpeed.isFull());  
  }

}

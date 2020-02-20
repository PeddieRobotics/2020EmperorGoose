/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.FlyWheelCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Framework.MovingAverage;
import frc.robot.subsystems.Shooter;

public class startFlywheel extends CommandBase {
  /**
   * Creates a new startFlywheel.
   */
  Shooter m_Shooter;
  MovingAverage avgOfSpeed;
  public startFlywheel(Shooter rcShooter) {
    m_Shooter = rcShooter;
    addRequirements(rcShooter);
    avgOfSpeed= new MovingAverage(10);
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
  
    m_Shooter.setMotors(3300);
    avgOfSpeed.add(m_Shooter.getSpeed());
    SmartDashboard.putNumber("avg of speed", avgOfSpeed.get());
    SmartDashboard.putNumber("avg value",avgOfSpeed.get());
    CommandScheduler.getInstance().schedule();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriverStation.reportError("done here", false);
    m_Shooter.setMotorPercentOutput(0.0);
  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return ((Math.abs(avgOfSpeed.get()-3300)<100)&&avgOfSpeed.isFull());  
  
  }

}

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

public class runFlywheel extends CommandBase {
  /**
   * Creates a new startFlywheel.
   */
  Shooter m_Shooter;
  MovingAverage avgOfSpeed;
  public runFlywheel(Shooter rcShooter) {
    m_Shooter = rcShooter;
    addRequirements(rcShooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //avgOfSpeed.clearInitialize();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_Shooter.setMotors(1400);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(!interrupted){DriverStation.reportError("is interupted",false);
  }
    m_Shooter.setMotorPercentOutput(0.0);
  
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}

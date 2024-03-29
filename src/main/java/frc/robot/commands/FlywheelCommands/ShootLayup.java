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
import frc.robot.Constants;
import frc.robot.subsystems.Flywheel;

public class ShootLayup extends CommandBase {
  
  private Flywheel m_flywheel;

  private double speed;

  private boolean stopFlywheelPostShot;

  public ShootLayup(Flywheel flywheel, double rpm, boolean shouldStopFlywheelPostShot) {
    stopFlywheelPostShot = shouldStopFlywheelPostShot;
    m_flywheel = flywheel;
    speed = rpm;
    addRequirements(m_flywheel);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    if(SmartDashboard.getNumber("ShootLayup Setpoint", speed) != 0.0){
      m_flywheel.updateSetpoint(SmartDashboard.getNumber("ShootLayup Setpoint", speed));
    }
    else{
      m_flywheel.updateSetpoint(speed);
    }
    m_flywheel.setHood(false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_flywheel.runMotors();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(!interrupted){
      //DriverStation.reportError("is interupted",false);
    }

    //DriverStation.reportError("is interupted false",false);
    if(stopFlywheelPostShot){
      m_flywheel.setMotorPercentOutput(0.0);
    }
    m_flywheel.setHood(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

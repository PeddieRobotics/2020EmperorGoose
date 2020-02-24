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
import frc.robot.Framework.MovingAverage;
import frc.robot.subsystems.Flywheel;

public class ShootFromFar extends CommandBase {

  private Flywheel m_flywheel;
  private double speed;
  private MovingAverage avgOfSpeed;

  public ShootFromFar(Flywheel flywheel) {
    m_flywheel = flywheel;
    speed = Constants.RPM_FAR;
    addRequirements(flywheel);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_flywheel.updateSetpoint(speed);
    m_flywheel.setHood(true);
    //avgOfSpeed.clearInitialize();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_flywheel.getSetpointFromSmartDashboard(speed);
    m_flywheel.runMotors();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(!interrupted){
      DriverStation.reportError("is interupted",false);
    }

    DriverStation.reportError("is interupted",false);
    m_flywheel.setMotorPercentOutput(0.0);
    m_flywheel.setHood(false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}

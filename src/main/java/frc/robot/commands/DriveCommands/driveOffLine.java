/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class driveOffLine extends CommandBase {
  /**
   * Creates a new driveOffLine.
   */
  Drivetrain m_driveTrain;
  double startTime =0;
  public driveOffLine(Drivetrain driveTrain) {
    m_driveTrain = driveTrain;
    addRequirements(driveTrain);  
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // just drive for 2 seconds 
    m_driveTrain.arcadeDrive(.2, 0, Constants.DRIVETRAIN_DEADBAND, Constants.DRIVETRAIN_USE_SQUARED);
    m_driveTrain.run();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.setSpeed(0);
    m_driveTrain.setTurn(0);
    m_driveTrain.run();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Timer.getFPGATimestamp()-startTime>1);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.MiscCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class WaitAndStopCommand extends CommandBase {
  /**
   * Creates a new WaitAndStopCommand.
   */
  double waitTimeSeconds;
  double startTime =0;
  Drivetrain m_drivetrain;
  public WaitAndStopCommand(double waitTime, Drivetrain drivetrain) {
    waitTimeSeconds= waitTime;
    
    m_drivetrain = drivetrain;
    
    addRequirements(drivetrain);

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
    m_drivetrain.setTurn(0);
    m_drivetrain.setSpeed(0);
    m_drivetrain.run();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Timer.getFPGATimestamp()-startTime>=waitTimeSeconds);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class ResetGyro extends CommandBase {
  Drivetrain train; 
  boolean finish = false;
  double waitTime = 0; 
  /**
   * Creates a new ResetGyro.
   */
  public ResetGyro(Drivetrain drivetrain) {
    train = drivetrain;
    
    // Use addRequirements() here to declare subsystem dependencies.
  }
  @Override 
  public boolean runsWhenDisabled() {
    return true;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    finish = false;
    waitTime = Timer.getFPGATimestamp();
    
    train.resetADIS();
    DriverStation.reportError("resseting",false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //callibration takes .15 seconds
    if(Timer.getFPGATimestamp()-waitTime>.15){
      finish = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(finish)return true;
    else return false;
  }
}
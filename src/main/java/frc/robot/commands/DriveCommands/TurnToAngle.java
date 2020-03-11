/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class TurnToAngle extends CommandBase {

  private Drivetrain m_drivetrain;
  private double goalAngle;
  private double realGoalAngle;
  private double startAngle; 
  private double velocityConst = 45;
  private double maxVel = 2700;
  public TurnToAngle(Drivetrain drivetrain, double angle) {
    goalAngle = angle;
    realGoalAngle = angle;
    m_drivetrain = drivetrain;
    SmartDashboard.putNumber("vel we're giving it",0);
    SmartDashboard.putNumber("ang diff",0);
     
    addRequirements(drivetrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startAngle = m_drivetrain.unBoundedAngle();
    goalAngle= startAngle+realGoalAngle;

    m_drivetrain.setCoast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    
    double velocity = Math.min(maxVel,(goalAngle-m_drivetrain.unBoundedAngle())*velocityConst); 
    SmartDashboard.putNumber("vel we're giving it",velocity);
    m_drivetrain.setVelocity(-velocity, velocity, 0, 0, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setBrake();
    m_drivetrain.setSpeed(0);
    m_drivetrain.setTurn(0);
    m_drivetrain.run();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    SmartDashboard.putNumber("ang diff",goalAngle-m_drivetrain.unBoundedAngle());
    
    return Math.abs(goalAngle-m_drivetrain.unBoundedAngle()) < 1;
  }
}

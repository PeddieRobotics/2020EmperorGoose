/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.team319.trajectory.Path;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Auto.GenPathSetup;
import frc.robot.subsystems.Drivetrain;

public class RunAuto extends CommandBase {
  private GenPathSetup gps;
  private final Drivetrain drivetrain;
  private int currentLine;
  private Path path;
  
  public RunAuto(Drivetrain driveT) {
    drivetrain = driveT;
    addRequirements(drivetrain);  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    currentLine = 0;
    gps = new GenPathSetup();
   // drivetrain.resetNavX();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double m_currentHeading = drivetrain.returnAngle();
    double path_heading = path.getPath()[currentLine][gps.heading()];
    double heading_difference = m_currentHeading+Math.toDegrees(path_heading);
    // put numbers into SmartDashboard network table
    SmartDashboard.putNumber("heading difference",heading_difference);
    SmartDashboard.putNumber("your angle" , m_currentHeading);
    SmartDashboard.putNumber("path heading", Math.toDegrees(path_heading));
    SmartDashboard.putNumber("sample heading diff",heading_difference);
   // SmartDashboard.putNumber("right velocity",path.getPath()[currentLine][gps.rightVel()]);
   // drivetrain.setVelocity(path.getPath()[currentLine][gps.leftVel()]*(120*11.111/Math.PI),6.25*heading_difference);
          
    currentLine++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.setBrake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (currentLine >= path.getPath().length-1);
  }

  public void setPath(Path p) {
    path = p;
  }

  public Path getPath() {
    return path;
  }
}

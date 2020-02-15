/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Tower;

public class Shoot extends CommandBase {
  /**
   * Creates a new Shoot.
   */
  private Flywheel m_fly;
  private Tower m_tower;
  private double setpoint = 0.0;
  public Shoot(Flywheel f, Tower n) {
    m_fly = f;
    m_tower = n;
    addRequirements(f);
    addRequirements(n);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //SmartDashboard.putNumber("setpoint", setpoint);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   // setpoint = SmartDashboard.getNumber("setpoint", 0.0);
    setpoint = 1000;
    m_tower.runMotors(0.1);
    m_fly.setSpeed(setpoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

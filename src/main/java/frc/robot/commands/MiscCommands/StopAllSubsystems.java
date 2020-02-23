/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands  .MiscCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tower;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hopper;

public class StopAllSubsystems extends CommandBase {
  /**
   * Creates a new StopAllSubsystems.
   */
  private Intake m_intake;
  private Tower m_tower;
  private Hopper m_hopper;
  private Flywheel m_flywheel;

  public StopAllSubsystems(Intake i, Tower t, Hopper h, Flywheel f) {
    m_intake = i;
    m_tower = t;
    m_hopper = h;
    m_flywheel = f;
    addRequirements(i,t,h,f);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intake.stopIntake();
    m_hopper.stopAll();
    m_tower.stopAll();
    m_flywheel.disable();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
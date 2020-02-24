/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tower;

public class ToggleIntakeOnOff extends CommandBase {

  private Intake m_intake;
  Tower m_tower;
  Hopper m_hopper;
  public ToggleIntakeOnOff(Intake intake) {
    m_intake = intake;
  
    addRequirements(intake);
    // Use addRequirements() here to declare subsystem dependencies.
  }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {
   // m_tower.runMotors(0);
    m_hopper.runAll();  
    m_intake.startIntake();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intake.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

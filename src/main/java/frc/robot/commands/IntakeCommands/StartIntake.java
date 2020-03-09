/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.IntakeCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Tower;
import frc.robot.subsystems.Tower.TowerModeType;

public class StartIntake extends CommandBase {
 
  private Intake m_intake;
  private Hopper m_hopper;
  private Tower m_tower;

  public StartIntake(Intake intake, Hopper hopper, Tower tower) {
    m_intake = intake;
    m_hopper = hopper;
    m_tower = tower;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_intake.startIntake();

    if(m_tower.getCurrentMode() == TowerModeType.INDEXING){

      m_hopper.runAll(-0.5, 0.5, 0.5);

    }

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

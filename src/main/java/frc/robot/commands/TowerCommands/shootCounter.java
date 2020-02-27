/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.TowerCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Tower;

public class ShootCounter extends CommandBase {
  /**
   * Creates a new shootCounter.
   */
  boolean prevSensesBall0;
  Tower m_tower;
  int shotsToFire;
  int counter;

  public ShootCounter(Tower tower, int shotCount) {
    m_tower = tower;
    counter = 0;
    
    shotsToFire = shotCount;
    addRequirements(tower);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    prevSensesBall0 = m_tower.senses_ball_Top0();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("Sensing Ball", prevSensesBall0);
    //increment our negative edges
    if (!m_tower.senses_ball_Top0() && prevSensesBall0){
      counter++;
    }
    DriverStation.reportError("count"+counter,false);
    prevSensesBall0 = m_tower.senses_ball_Top0();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return (counter >= shotsToFire);
  }
}

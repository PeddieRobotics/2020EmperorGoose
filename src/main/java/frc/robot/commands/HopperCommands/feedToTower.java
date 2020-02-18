package frc.robot.commands.HopperCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class feedToTower extends CommandBase {
  /**
   * Creates a new feedToTower.
   */
  Hopper m_Hopper;

  /**
   * @param hopperRC Hopper subsystem
   */
  public feedToTower( Hopper hopperRC ) {

    m_Hopper = hopperRC;
    addRequirements( hopperRC );

  
  }
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_Hopper.setLeftWall(.2);
    m_Hopper.setRightWall(-.32);
    m_Hopper.setFloor(-.32);

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

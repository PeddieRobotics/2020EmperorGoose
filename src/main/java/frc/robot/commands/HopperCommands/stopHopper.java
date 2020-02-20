// need to merge contents of execute() to feedToTower.end(), redundant command 

package frc.robot.commands.HopperCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class stopHopper extends CommandBase {
  /**
   * Creates a new feedToTower.
   */
  Hopper m_Hopper;

  /**
   * @param hopperRC Hopper subsystem
   */
  public stopHopper( Hopper hopperRC ) {

    m_Hopper = hopperRC;
    addRequirements( hopperRC );

  
  }
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    m_Hopper.setLeftWall(0);
    m_Hopper.setRightWall(0);
    m_Hopper.setFloor(0);
    
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

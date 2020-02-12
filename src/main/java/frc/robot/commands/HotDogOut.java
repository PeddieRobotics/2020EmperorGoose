package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HotDog;

public class HotDogOut extends CommandBase {
  
  private HotDog hotDogOut;
  
  //this command tells the hopper belts to run "out" (away from the tower)
  public HotDogOut() {
   
    hotDogOut = new HotDog();
    addRequirements(hotDogOut);

  }
  
  //called when the command is initially scheduled
  @Override
  public void initialize() {
    hotDogOut.rollingB(true);

  }

  @Override
  public void execute() {

  }

  //called when the command ends/interrupted 
  @Override
  public void end(boolean interrupted) {

    hotDogOut.rollingB(false);

  }

  //returns true when the command should end
  @Override
  public boolean isFinished() {
    
    return false;

  }
}

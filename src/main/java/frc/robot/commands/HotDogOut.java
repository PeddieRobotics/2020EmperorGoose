package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;

public class HotDogOut extends CommandBase {
  
  private Hopper hotDogOut;
  
  public HotDogOut() {
   
    hotDogOut = new HotDog();
    addRequirements(hotDogOut);

  }

  @Override
  public void initialize() {
    
    hotDogOut.rollingB(true);

  }

  @Override
  public void execute() {

  }

  @Override
  public void end(boolean interrupted) {

    hotDogOut.rollingB(false);

  }

  @Override
  public boolean isFinished() {
    
    return false;

  }
}

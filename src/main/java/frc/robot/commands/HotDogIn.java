package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HotDog;

public class HotDogIn extends CommandBase {
  
  private HotDog hotDogIn;

  public HotDogIn() {

    hotDogIn = new HotDog();
    addRequirements(hotDogIn);
  }

  @Override
  public void initialize() {

    hotDogIn.rollingF(true);

  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {

    hotDogIn.rollingF(false);
    
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}

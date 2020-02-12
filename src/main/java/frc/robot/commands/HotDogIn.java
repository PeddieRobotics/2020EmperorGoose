package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HotDog;

public class HotDogIn extends CommandBase {
  
  private HotDog hotDogIn;
  
  //this command tells the hopper belts to run "in" (towards the tower)
  public HotDogIn() {

    hotDogIn = new HotDog();
    addRequirements(hotDogIn);
  }

  //called when the command is initally scheduled
  @Override
  public void initialize() {

    hotDogIn.rollingF(true);

  }

  @Override
  public void execute() {
  }

  //called when the command ends/interrupted
  @Override
  public void end(boolean interrupted) {

    hotDogIn.rollingF(false);
    
  }

  //called when the command should end
  @Override
  public boolean isFinished() {
    return false;
  }
}

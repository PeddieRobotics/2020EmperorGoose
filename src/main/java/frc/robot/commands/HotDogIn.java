package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HotDog;

public class HotDogIn extends CommandBase {
  
  private HotDog hotDog;
  private boolean Run;
  private boolean Rrun;
  
  public HotDogIn(HotDog hd, Boolean TF, Boolean TFR) {
    hotDog = hd;
    addRequirements(hotDog);
    Run = TF;
    Rrun = TFR;
  }

  //called when the command is initally scheduled
  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    if (Run && Rrun) {
      hotDog.HDReverse();
    }
    else if (Run && !Rrun) {
      hotDog.HDIntaking();
    }
    else if (!Run && !Rrun) {
      hotDog.HDDisabled();
    }
  }

  //called when the command ends/interrupted
  @Override
  public void end(boolean interrupted) {    
  }

  //called when the command should end
  @Override
  public boolean isFinished() {
    return false;
  }
}

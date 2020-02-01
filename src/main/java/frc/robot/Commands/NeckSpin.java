package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Neck;

public class NeckSpin extends CommandBase {

  private Neck neck;
  private final AnalogInput analogT, analogB;

  public NeckSpin() {
    
    neck = new Neck();
    addRequirements(neck);

    analogT = new AnalogInput(0);
    analogB = new AnalogInput(1);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (analogT.getVoltage() < 3 && analogB.getVoltage() <3) {
      neck.runMotors(15.0);
    }

    if (analogT.getVoltage() < 3 && analogB.getVoltage() > 3) {
      neck.runMotors(15.0);
    }

    if (analogT.getVoltage() > 3 && analogB.getVoltage() < 3) {
      neck.runBottomMotor(15.0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (analogT.getVoltage() > 4 && analogB.getVoltage() > 4);
  }
}

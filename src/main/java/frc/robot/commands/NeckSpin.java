package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Neck;

public class NeckSpin extends CommandBase {

  private Neck m_neck;
  private final AnalogInput analogT, analogB;

  public NeckSpin() {
    
    m_neck = new Neck();
    addRequirements(m_neck);

    analogT = new AnalogInput(0);
    analogB = new AnalogInput(1);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  // tells whether sensor sees bol
  private boolean senses_ball(AnalogInput sensor)
  {
    if (sensor.getVoltage() > 3) 
    {
      return true;
    }
    else 
    {
      return false;
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!senses_ball(analogT) && !senses_ball(analogB)) {
     // m_neck.runMotors(15.0);
    }

    if (analogT.getVoltage() < 3 && analogB.getVoltage() > 3) {
    //  m_neck.runMotors(15.0);
    }

    if (analogT.getVoltage() > 3 && analogB.getVoltage() < 3) {
      //m_neck.runBottomMotor(15.0);
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

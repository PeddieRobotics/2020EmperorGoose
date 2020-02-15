package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Neck;

public class NeckSpin extends CommandBase {

  private Neck m_neck;
  private final AnalogInput m_topSensor, m_bottomSensor;

  public NeckSpin(Neck neck) {
    m_neck = neck;
    addRequirements(m_neck);

    m_topSensor = new AnalogInput(0);
    m_bottomSensor = new AnalogInput(1);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }
  // tells whether sensor sees a ball

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("working");
    // if the top doesn't sense a ball, everything runs
    if (!m_neck.senses_ball(m_topSensor)) {
      m_neck.runMotors(1.0);
      System.out.println("running both");
    }

    // if there's a ball on the top and no ball on the bottom, 
    // then run only the bottom motors and stop the top motors
    else if (m_neck.senses_ball(m_topSensor) && !m_neck.senses_ball(m_bottomSensor)) {
      m_neck.runBottomMotor(1.0);
      System.out.println("running bottom");
    }

    // if there's a ball on top and bottom, stop everything
    else if (m_neck.senses_ball(m_topSensor) && m_neck.senses_ball(m_bottomSensor)) {
      m_neck.runMotors(0);
    }

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

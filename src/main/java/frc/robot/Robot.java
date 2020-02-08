package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  RobotContainer m_RobotContainer;

  public void robotInit() {

    m_RobotContainer = new RobotContainer();

  }

  public void robotPeriodic() {

    CommandScheduler.getInstance().run();

  }

  
  public void disabledInit() {
    m_RobotContainer.setBrakeMode();
  }
 
  public void disabledPeriodic() {
  }
  
  public void autonomousInit() {
    m_RobotContainer.getAutonomousCommand();
  }

  public void autonomousPeriodic() {
  }

  public void teleopInit() {
    m_RobotContainer.setCoastMode();
  }

  public void teleopPeriodic() {
  }

  public void testInit() {
  }

  public void testPeriodic() {
  }
}

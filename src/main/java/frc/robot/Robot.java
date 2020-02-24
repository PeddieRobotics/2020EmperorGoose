package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpiutil.net.PortForwarder;

public class Robot extends TimedRobot {

  RobotContainer m_RobotContainer;

  public void robotInit() {
    PortForwarder.add(5801,"10.58.95.11",5801);
    PortForwarder.add(5805,"10.58.95.11",5805);
    m_RobotContainer = new RobotContainer();

  }

  public void robotPeriodic() {

    CommandScheduler.getInstance().run();

  }

  
  public void disabledInit() {
    m_RobotContainer.setCoastMode();
  }
 
  public void disabledPeriodic() {
  }
  
  public void autonomousInit() {
    if(!(m_RobotContainer.getAutonomousCommand()==null)){
      CommandScheduler.getInstance().schedule(m_RobotContainer.getAutonomousCommand());
    }   
  }

  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
    m_RobotContainer.setBrakeMode();
  }
  
  public void teleopInit() {
    m_RobotContainer.setCoastMode();

    m_RobotContainer.configureButtonBindings();
    m_RobotContainer.setCoastMode();
    m_RobotContainer.configureDefaultBehaviors();
  }

  public void teleopPeriodic() {
  }

  public void testInit() {
    m_RobotContainer.setTestMode(true);
    m_RobotContainer.configureTestButtonBindings();
    m_RobotContainer.configureDefaultBehaviors();
  }

  public void testPeriodic() {
  }
}

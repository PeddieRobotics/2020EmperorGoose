package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpiutil.net.PortForwarder;

public class Robot extends TimedRobot {

  RobotContainer m_RobotContainer;
  static boolean isCompetitionRobot = true;

  public void robotInit() {
    PortForwarder.add(5801,"10.58.95.11",5801);
    PortForwarder.add(5805,"10.58.95.11",5805);
    m_RobotContainer = new RobotContainer();

  }
  public static boolean isCompetitionRobot(){
    return isCompetitionRobot;
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
    m_RobotContainer.getAutonomousCommand();
  }

  public void autonomousPeriodic() {
  }
  
  public void teleopInit() {
   // isCompetitionRobot = true;// in teleop we are competing
    m_RobotContainer.setCoastMode();
  }

  public void teleopPeriodic() {
  }

  public void testInit() {
   // isCompetitionRobot = false; // in test we are using the practice robot;
  }

  public void testPeriodic() {
  }
}

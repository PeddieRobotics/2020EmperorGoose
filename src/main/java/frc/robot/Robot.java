package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpiutil.net.PortForwarder;

public class Robot extends TimedRobot {

  RobotContainer m_RobotContainer;
  static boolean isCompetitionRobot = false;

  public void robotInit() {
    PortForwarder.add(5800,"10.58.95.11",5800);
    PortForwarder.add(5801,"10.58.95.11",5801);
    PortForwarder.add(5802,"10.58.95.11",5802);
    PortForwarder.add(5803,"10.58.95.11",5803);
    PortForwarder.add(5804,"10.58.95.11",5804);
    PortForwarder.add(5805,"10.58.95.11",5805);
    PortForwarder.add(5806,"10.58.95.11",5806);
    PortForwarder.add(5807,"10.58.95.11",5807);
    PortForwarder.add(5808,"10.58.95.11",5808);
    PortForwarder.add(5809,"10.58.95.11",5809);
    m_RobotContainer = new RobotContainer();

  }
  public static boolean isCompetitionRobot(){
    return isCompetitionRobot;
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

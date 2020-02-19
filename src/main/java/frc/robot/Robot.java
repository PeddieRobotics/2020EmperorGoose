package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  RobotContainer m_RobotContainer;
  static boolean isCompetitionRobot = false;

  public void robotInit() {

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

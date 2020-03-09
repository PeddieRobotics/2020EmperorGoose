package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpiutil.net.PortForwarder;

public class Robot extends TimedRobot {

  RobotContainer m_RobotContainer;

  public void robotInit() {
    PortForwarder.add(5801, "10.58.95.11", 5801);// web interface
    PortForwarder.add(5805, "10.58.95.11", 5805);// back end data for web interface
    PortForwarder.add(5800, "10.58.95.11", 5800);// stream for web interface
    m_RobotContainer = new RobotContainer();

    UsbCamera driverCamera = CameraServer.getInstance().startAutomaticCapture(0);
    driverCamera.setExposureAuto();
    driverCamera.setFPS(24);
    
    m_RobotContainer.calibrateGyro();

    SmartDashboard.putNumber("lastState", 0);
  }

  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  public void disabledInit(){
    clearCommmandScheduler();
  }

  public void disabledPeriodic() {
  }

  public void autonomousInit() {
    clearCommmandScheduler();
    m_RobotContainer.configureDefaultBehaviors(false);
    m_RobotContainer.resetGyro();
    if(!(m_RobotContainer.getAutonomousCommand()==null)){
      CommandScheduler.getInstance().schedule(m_RobotContainer.getAutonomousCommand());
    }   
  }

  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  public void clearCommmandScheduler(){
    try{
      CommandScheduler.getInstance().cancelAll();
    
    }catch(Exception e){
      String error = e.toString();
    }
  }
  
  public void teleopInit() {
    clearCommmandScheduler();
    m_RobotContainer.configureDefaultBehaviors(false);
    m_RobotContainer.setCoastMode();
  }

  public void teleopPeriodic() {
    CommandScheduler.getInstance().run();
  }

  public void testInit() {
    m_RobotContainer.configureDefaultBehaviors(true);
    m_RobotContainer.setCoastMode();
    m_RobotContainer.configureSmartDashboardTest();
  }

  public void testPeriodic() {
  }
}

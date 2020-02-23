package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Auto.PIDClasses.NEO;
import frc.robot.Framework.MovingAverage;
import frc.robot.Framework.Logging.CSVLogger;

public class Flywheel extends SubsystemBase {

  private static enum FlywheelModeType {
    SHOOTING, DISABLED, REVERSE
  }

  private FlywheelModeType currentMode;

  private boolean isHoodUp;

  private NEO flyWheelForward, flyWheelBackward;
  private double m_setpoint;
  private MovingAverage avgOfFlyWheelSpeeds;
  Solenoid hSolenoid;

  public Flywheel() {
    currentMode = FlywheelModeType.DISABLED;

    m_setpoint = 0.0;

    hSolenoid=new Solenoid(Constants.SOLENOID_HOOD);

    avgOfFlyWheelSpeeds = new MovingAverage(10);
    flyWheelForward = new NEO( Constants.FLYWHEEL_1 );
    flyWheelBackward = new NEO( Constants.FLYWHEEL_2 );

    flyWheelForward.addPIDController( Constants.FLYWHEEL_P, Constants.FLYWHEEL_D, Constants.FLYWHEEL_I, Constants.FLYWHEEL_FF, 0 );
    flyWheelBackward.addPIDController( Constants.FLYWHEEL_P, Constants.FLYWHEEL_D, Constants.FLYWHEEL_I, Constants.FLYWHEEL_FF, 0 );
    
    CSVLogger.getInstance().addStringToHeader("velocity");
    CSVLogger.getInstance().addVariablesToRecored(this::getAvgVelocity);
    
  } 

  /**
   * sets shooter motors
   * @param setpoint shooter speed
   */
  public void runMotors() {
  
    flyWheelBackward.setVelocity(-m_setpoint);
    flyWheelForward.setVelocity(m_setpoint);
    avgOfFlyWheelSpeeds.add(flyWheelForward.getVelocity());

  }

  public void setHood(boolean isUp){
   
    hSolenoid.set(isUp);
    isHoodUp = isUp;
  
  }

  public double getSpeed(){
  
    return flyWheelForward.getVelocity();
  
  }
  
  public double getAvgVelocity(){

    return avgOfFlyWheelSpeeds.get();
  }
  
  public void setMotorPercentOutput(double setpoint){
    m_setpoint = 0.0;
    
    if(setpoint > 0.0){
      currentMode = FlywheelModeType.SHOOTING;
    }
    else if(setpoint == 0.0){
      currentMode = FlywheelModeType.DISABLED;
    }

    flyWheelBackward.set(setpoint);
    flyWheelForward.set(setpoint);
  }

  public boolean isShooting(){
    return (currentMode == FlywheelModeType.SHOOTING);
  }

  /**
   * disables shooter
   */
  public void disable() {
    this.setMotorPercentOutput(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void updateSetpoint(double setpoint){
    m_setpoint = setpoint;
  }

  public void setpointWithSmartDashboard(double defaultSetpoint){
    m_setpoint = SmartDashboard.getNumber("Flywheel Setpoint", defaultSetpoint);
    if(m_setpoint < 999 || m_setpoint > 5000)
        m_setpoint = defaultSetpoint;
    
    SmartDashboard.putNumber("Flywheel Setpoint", m_setpoint);
    
  }
}

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Auto.PIDClasses.NEO;
import frc.robot.Auto.PIDClasses.NEOPIDWithSmartDashboard;
import frc.robot.Framework.MovingAverage;
import frc.robot.Framework.LookupTable;
import frc.robot.Framework.Logging.CSVLogger;

public class Flywheel extends SubsystemBase {

  public static enum FlywheelModeType {
    SHOOTING, DISABLED, REVERSE
  }

  private FlywheelModeType currentMode;

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
    flyWheelBackward = new NEO(Constants.FLYWHEEL_2);
    
    flyWheelBackward.follow(flyWheelForward, true);
   // NEOPIDWithSmartDashboard flyWheelForwards = new NEOPIDWithSmartDashboard(Constants.FLYWHEEL_1);
   // NEOPIDWithSmartDashboard flyWheelBackwards = new NEOPIDWithSmartDashboard(Constants.FLYWHEEL_2);
    flyWheelForward.addPIDController( Constants.FLYWHEEL_P, Constants.FLYWHEEL_D, Constants.FLYWHEEL_I, Constants.FLYWHEEL_FF, 0 );
    flyWheelForward.setSmartCurrentLimit(50);
    flyWheelBackward.setSmartCurrentLimit(50);
    flyWheelForward.getPIDController().setIMaxAccum(0.3, 0);
    flyWheelForward.getPIDController().setIZone(400);
    flyWheelForward.getPIDController().setOutputRange(0, 1, 0);
    flyWheelForward.getPIDController().setSmartMotionMaxVelocity(5000, 0);
    flyWheelForward.changeControlFramePeriod(3);

    SmartDashboard.putNumber("Flywheel velocity",flyWheelForward.getVelocity());
  
  } 

    /**
   * sets shooter motors
   * @param setpoint shooter speed
   */
  public void setMotors( double setpoint ) {
    if(setpoint > 0.0){
      currentMode = FlywheelModeType.SHOOTING;
    }
    else{
      currentMode = FlywheelModeType.DISABLED;
    }
    
    m_setpoint = setpoint;

    flyWheelForward.setVelocity(m_setpoint);
    SmartDashboard.putNumber("Flywheel current",flyWheelForward.getOutputCurrent());
    SmartDashboard.putNumber("Flywheel velocity", flyWheelForward.getVelocity());

    avgOfFlyWheelSpeeds.add(flyWheelForward.getVelocity());

  }

  public void setHood(boolean isUp){
   
    hSolenoid.set(isUp);
  
  }

  public boolean isHoodUp()
  {
    return hSolenoid.get();
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
    else{
      currentMode = FlywheelModeType.DISABLED;
    }

    flyWheelBackward.set(-setpoint);
    flyWheelForward.set(setpoint);
  }

  public boolean isShooting(){
    return (currentMode == FlywheelModeType.SHOOTING);
  }

  /**
   * disables shooter
   */
  public void disable() {
    currentMode = FlywheelModeType.DISABLED;
    this.setMotorPercentOutput(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void updateSetpoint(double setpoint){
    double newSetpoint = setpoint;
    if(setpoint < 500 || setpoint > 4000){
        newSetpoint = 0;   
    }
    m_setpoint = newSetpoint;
  }

  public void reverse(){
    currentMode = FlywheelModeType.REVERSE;
    flyWheelForward.setVoltage(-0.2);
  }

  public double getSetpoint(){
    return m_setpoint;
  }

  public void setFlywheelMode(FlywheelModeType mode){
    currentMode = mode;
  }
  
  public void runMotors() {
    flyWheelForward.setVelocity(m_setpoint);

    avgOfFlyWheelSpeeds.add(flyWheelForward.getVelocity());

    SmartDashboard.putNumber("Flywheel current",flyWheelForward.getOutputCurrent());
    SmartDashboard.putNumber("Flywheel velocity",flyWheelForward.getVelocity());
  }


}

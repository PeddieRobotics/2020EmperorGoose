package frc.robot.subsystems;

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

  private NEO flyWheelForward, flyWheelBackward;
  private double m_setpoint;
  private MovingAverage avgOfFlyWheelSpeeds;

  public Flywheel() {
    currentMode = FlywheelModeType.DISABLED;

    m_setpoint = 0.0;

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
  public void setMotors( double setpoint ) {
    if(setpoint > 0.0){
      currentMode = FlywheelModeType.SHOOTING;
    }
    else if(setpoint == 0.0){
      currentMode = FlywheelModeType.DISABLED;
    }
    else{
      currentMode = FlywheelModeType.REVERSE;
    }

    m_setpoint = setpoint;
  
    flyWheelBackward.setVelocity(-setpoint);

    flyWheelForward.setVelocity(setpoint);
  
    avgOfFlyWheelSpeeds.add(flyWheelForward.getVelocity());

  }

  public double getSpeed(){
  
    return flyWheelForward.getVelocity();
  
  }
  
  public double getAvgVelocity(){

    return avgOfFlyWheelSpeeds.get();
  }
  
  public void setMotorPercentOutput(double setpoint){
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
}

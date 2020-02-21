package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.SmartDashboardSubsystem;
import frc.robot.Auto.PIDClasses.NEO;
import frc.robot.Auto.PIDClasses.NEOPIDWithSmartDashboard;
import frc.robot.Auto.PIDClasses.TalonSRXWithSmartDashboard;
import frc.robot.Auto.PIDClasses.VictorSPXWithSmartDashboard;
import frc.robot.Framework.MovingAverage;
import frc.robot.Framework.Logging.CSVLogger;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  NEO flyWheelFoward, flyWheelBackward;
  double m_Setpoint;
  MovingAverage avgOfFlyWheelSpeeds;
  public Shooter() {
    m_Setpoint=0;
    avgOfFlyWheelSpeeds = new MovingAverage(10);
    flyWheelFoward = new NEO( Constants.FLYWHEEL_1 );
    flyWheelBackward = new NEO( Constants.FLYWHEEL_2 );

    flyWheelFoward.addPIDController( Constants.FLYWHEEL_P, Constants.FLYWHEEL_D, Constants.FLYWHEEL_I, Constants.FLYWHEEL_FF, 0 );
    flyWheelBackward.addPIDController( Constants.FLYWHEEL_P, Constants.FLYWHEEL_D, Constants.FLYWHEEL_I, Constants.FLYWHEEL_FF, 0 );
    
    CSVLogger.getInstance().addStringToHeader("velocity");
    CSVLogger.getInstance().addVariablesToRecored(this::getAvgVelocity);
  } 

  /**
   * sets shooter motors
   * @param setpoint shooter speed
   */
  public void setMotors( double setpoint ) {
    m_Setpoint = setpoint;
  
    flyWheelBackward.setVelocity(-setpoint);
  
    flyWheelFoward.setVelocity(setpoint);
  
    avgOfFlyWheelSpeeds.add(flyWheelFoward.getVelocity());

  }

  public double getSpeed(){
  
    return flyWheelFoward.getVelocity();
  
  }
  
  public double getAvgVelocity(){

    return avgOfFlyWheelSpeeds.get();
  }
  
  public void setMotorPercentOutput(double setpoint){
    flyWheelBackward.set(0);
    flyWheelFoward.set(0);
  }

  /**
   * disables shooter
   */
  public void disable() {

    //flyWheelFoward.set(0);
    //flyWheelBackward.set(0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

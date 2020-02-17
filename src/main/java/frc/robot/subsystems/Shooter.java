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

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  NEO flyWheelFoward, flyWheelBackward;
 
  public Shooter() {
    flyWheelFoward = new NEO(Constants.FLYWHEEL_1);
    flyWheelBackward = new NEO(Constants.FLYWHEEL_2);
    flyWheelFoward.addPIDController(Constants.FLYWHEEL_P,Constants.FLYWHEEL_D,Constants.FLYWHEEL_I,Constants.FLYWHEEL_FF,0);
    flyWheelBackward.addPIDController(Constants.FLYWHEEL_P,Constants.FLYWHEEL_D,Constants.FLYWHEEL_I,Constants.FLYWHEEL_FF,0);
    
  } 
  public void setMotors(double setpoint){
    flyWheelFoward.setVelocity(setpoint);
    flyWheelBackward.setVelocity(-setpoint);
  }
  public void stopMotors(){
    flyWheelFoward.set(0);
    flyWheelBackward.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

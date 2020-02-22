/**
 * FRC 5895 (Peddie School Robotics)
 * The Climber subsystem contains two pneumatic arms which extend
 * above the robot to hook onto the bar.
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climber extends SubsystemBase {

  private Solenoid leftArmSolenoid, rightArmSolenoid;
  
  private boolean isUp;

  public Climber() {
    
    isUp = false;

    leftArmSolenoid = new Solenoid(Constants.SOLENOID_CLIMBER_1);
    rightArmSolenoid = new Solenoid(Constants.SOLENOID_CLIMBER_2);

  }

  public boolean isClimberUp(){
    return isUp;
  }

  public void raiseClimber(){
    leftArmSolenoid.set(true);
    rightArmSolenoid.set(true);
  }

  public void lowerClimber(){
    leftArmSolenoid.set(false);
    rightArmSolenoid.set(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

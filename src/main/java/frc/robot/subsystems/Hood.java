/**
 * Hood refers to a very simple subsystem with a pneumatically-powered hood for the 
 * flywheel for the Shooter.
 */

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hood extends SubsystemBase {
  
  private Solenoid hoodSolenoid;
  private boolean isDown;

  public Hood() {

     isDown = true;
     hoodSolenoid = new Solenoid(Constants.SOLENOID_HOOD);

  }

  public boolean isHoodDown(){
    
    return isDown;
  }

  public void raiseHood(){

    hoodSolenoid.set(true); //set solenoid up if isUp is true, down if false
    isDown = false;
  }
  
  public void lowerHood(){

    hoodSolenoid.set(false); //set solenoid up if isUp is true, down if false
    isDown = true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

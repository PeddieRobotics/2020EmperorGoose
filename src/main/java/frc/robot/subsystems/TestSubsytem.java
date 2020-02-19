/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Auto.PIDClasses.NEOPIDWithSmartDashboard;

public class TestSubsytem extends SubsystemBase {
  /**
   * Creates a new TestSubsytem.
   */
Solenoid solenoid1;
Solenoid solenoid2;
Solenoid solenoid3;
Solenoid solenoid4;

  public TestSubsytem() {
    NEOPIDWithSmartDashboard neoOne = new NEOPIDWithSmartDashboard(7);
    
    NEOPIDWithSmartDashboard neoTwp = new NEOPIDWithSmartDashboard(8);
    
    NEOPIDWithSmartDashboard neoThree = new NEOPIDWithSmartDashboard(11);
    
    NEOPIDWithSmartDashboard neoFour = new NEOPIDWithSmartDashboard(12);
    solenoid1 = new Solenoid(1);      
    solenoid2 = new Solenoid(2);  
    solenoid3 = new Solenoid(3);  
    solenoid4 = new Solenoid(4); 
    SmartDashboard.putBoolean("oneSolenoid", false); 
    
    SmartDashboard.putBoolean("twoSolenoid", false); 
    
    SmartDashboard.putBoolean("threeSolenoid", false); 
    
    SmartDashboard.putBoolean("fourSolenoid", false); 
    
  }


  @Override
  public void periodic() {
    solenoid1.set(SmartDashboard.getBoolean("oneSolenoid", false)); 
    solenoid1.set(SmartDashboard.getBoolean("twoSolenoid", false));
    solenoid3.set(SmartDashboard.getBoolean("threeSolenoid", false));
    solenoid4.set(SmartDashboard.getBoolean("fourSolenoid", false));
    // This method will be called once per scheduler run
  }
}

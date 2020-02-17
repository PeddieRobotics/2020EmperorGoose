/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Auto.PIDClasses.NEOPIDWithSmartDashboard;

public class TestSubsytem extends SubsystemBase {
  /**
   * Creates a new TestSubsytem.
   */
  public TestSubsytem() {
    NEOPIDWithSmartDashboard neoOne = new NEOPIDWithSmartDashboard(7);
    
    NEOPIDWithSmartDashboard neoTwp = new NEOPIDWithSmartDashboard(8);
    
    NEOPIDWithSmartDashboard neoThree = new NEOPIDWithSmartDashboard(11);
    
    NEOPIDWithSmartDashboard neoFour = new NEOPIDWithSmartDashboard(12);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

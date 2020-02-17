/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hood extends SubsystemBase {
  /**
   * Creates a new Hood.
   */
  Solenoid hood;
  public Hood() {
    hood = new Solenoid(Constants.SOLENOID_HOOD);
  }
  public void set(boolean isUp){
    hood.set(isUp);
  }
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

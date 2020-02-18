/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  NetworkTable limes = NetworkTableInstance.getDefault().getTable("limelight"); 
  NetworkTableEntry tx = limes.getEntry("tx");
  NetworkTableEntry ty = limes.getEntry("ty");
  NetworkTableEntry thor = limes.getEntry("thor");
  NetworkTableEntry tvert = limes.getEntry("tvert");
  public Limelight() {

  }

  //Tvert is the vertical sidelength of the rough bounding box (0 - 320 pixels)
  public double getTvert(){
    return tvert.getDouble(0.0);
  }
  //Thor is the horizontal sidelength of the rough bounding box (0 - 320 pixels)
  public double getThor(){
    return thor.getDouble(0.0);
  }
  //Tx is the Horizontal Offset From Crosshair To Target
  public double getTx(){
    return tx.getDouble(0.0);
  }
  //Ty is the Vertical Offset From Crosshair To Target
  public double getTy(){
    return ty.getDouble(0.0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

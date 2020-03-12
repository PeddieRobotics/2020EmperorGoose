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
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Framework.LookupTable;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  LookupTable thorToVelocitySetpoint;
  double[] thorInputs = {};// make sure to go in increasing order, so from 1->100 vs 100->1
  double[] velocityOutputs = {};
  NetworkTable limes = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = limes.getEntry("tx");
  NetworkTableEntry ty = limes.getEntry("ty");
  NetworkTableEntry thor = limes.getEntry("thor");
  NetworkTableEntry tvert = limes.getEntry("tvert");

  public Limelight() {
    try {
      thorToVelocitySetpoint = new LookupTable(thorInputs, velocityOutputs);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    ledMode("on");
  }
  
  public double velocityCalculatedFromTHOR(){
    if(hasTarget()){
      return thorToVelocitySetpoint.get(getThor());
    }
    return 0; 
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
  public double getDistance(){
    return (89-25.5)/(Math.tan(22.5+ty.getDouble(0.0)));
  }
  public boolean hasTarget(){
    if (limes.getEntry("tv").getDouble(0.0)==1){
      return true;
    }else return false;
  }
  public void ledMode(String mode){
    switch(mode){
      case ("on"):{
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
        break;
      }
      case("off"):{
        NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
        break;
      }
    }
  }
  @Override
  public void periodic() {
    if(RobotState.isTest()){
      limes.getEntry("snapshot").setNumber(1);
    }else{
      
      limes.getEntry("snapshot").setNumber(0);
    }
    // This method will be called once per scheduler run
  }
}
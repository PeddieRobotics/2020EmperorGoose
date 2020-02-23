/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Framework.CommandLooper;
import frc.robot.Framework.MovingAverage;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class Centering extends CommandBase {
  /**
   * Creates a new centerArbWithTx.
   */
  Limelight limes;
  Drivetrain trains;
  boolean txNavSame = false;
  int center = 0;
  boolean centered = false;
  MovingAverage average = new MovingAverage(10);

  public Centering(Limelight limelight, Drivetrain drivetrain, int centers) {
    trains = drivetrain;
    limes= limelight;
    center = centers;
    addRequirements(trains);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  public int side(int center){
   if(trains.returnAngle()>0){
     return -center;
   }
  return center;
}
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   center = side(center); 
   limes.ledMode("on");
   average.clear();
  }
  public int keepArbSign(int center, double input){
    if(input>center){
      return 1;
    }
    return -1;
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double tx = 0;
    SmartDashboard.putBoolean("executing", true);
    SmartDashboard.putNumber("center", center);
    SmartDashboard.putBoolean("centered", centered);
    if(limes.hasTarget()){
      //trains.run();
      double p = SmartDashboard.getNumber("p value", 0.0);
      double error1 = SmartDashboard.getNumber("error",0.0);
      double deadband = SmartDashboard.getNumber("deadband", 0.0);
      SmartDashboard.putNumber("average", average.get());
      tx = limes.getTx();
      average.add(Math.abs(Math.abs(tx)-center));
      if(average.get()>error1 || average.get()==0){
        //trains.setTurn(-keepArbSign(center,tx)*Math.max(deadband,p*Math.abs(tx-center)));
        SmartDashboard.putNumber("Turn", -keepArbSign(center,tx)*Math.max(deadband,p*Math.abs(tx-center)));
      }
      else{
        centered = true;
      }
    }else{
      //trains.setSpeed(0);
      //trains.setTurn(0);
    }  
    if(Math.abs(trains.returnAngle()-center)<1&&Math.abs(tx-center)<1){
      txNavSame = true;
    }  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("executing", false);
    //trains.setSpeed(0);
   // trains.setTurn(0);
    //trains.run();
    txNavSame = false;
    centered = false;
    limes.ledMode("off");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(center!=0){
      return txNavSame; 
    }else{
      return centered; 
    }
  }
}
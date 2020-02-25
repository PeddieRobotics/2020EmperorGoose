/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Framework.CommandLooper;
import frc.robot.Framework.MovingAverage;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class Centering extends CommandBase {
  /**
   * Creates a new centerArbWithTx.
   */
  Limelight limes;
  Drivetrain m_driveTrain;
  boolean txNavSame = false;
  int center = 0;
  boolean centered = false;
  MovingAverage average = new MovingAverage(5);
  boolean m_isContinous;
  /**
   * @param isContinous this basically means are we running this command in a chain of commands or just to center the drivetrain
   * for ex. in auto we would want it to be continous but in tele we would want it to be not continous
   */
  public Centering(Limelight limelight, Drivetrain drivetrain, int centers, boolean isContinous) {
    
    m_driveTrain = drivetrain;
    
    m_isContinous = isContinous;
    
    SmartDashboard.putNumber("p value", 0.0);
    
    SmartDashboard.putNumber("error",0.0);

    SmartDashboard.putNumber("deadband", 0.0);
      
    limes= limelight;
    
    center = centers;
    //addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }
  public int side(int center){
   if(m_driveTrain.returnAngle()>0){
     return -center;
   }
  return center;
}
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   center = side(center); 
   limes.ledMode("on");
   average.clearInitialize();
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
      
      double p = 0.02;
      double error1 =.7;
      double deadband =  0.064;
      SmartDashboard.putNumber("average", average.get());
      tx = limes.getTx();
      average.add(Math.abs(Math.abs(tx)-center));
      if(average.get()>error1 || average.get()==0){
        m_driveTrain.addToTurn(keepArbSign(center,tx)*Math.max(deadband,p*Math.abs(tx-center)));
        SmartDashboard.putNumber("Turn", -keepArbSign(center,tx)*Math.max(deadband,p*Math.abs(tx-center)));
      }

      else {
        m_driveTrain.setTurn(0);
        //do nothing
      }
    }else{
     // m_driveTrain.setSpeed(0.0);
     // m_driveTrain.setTurn(0.0);
     //do nothing let reg. arcade drive run
    }  
    if(Math.abs(m_driveTrain.returnAngle()-center)<1&&Math.abs(tx-center)<1){
      txNavSame = true;
    }  
    //m_driveTrain.run(); in theory arcade drive should call this
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putBoolean("executing", false);
    m_driveTrain.arcadeDrive(0,0,Constants.DRIVETRAIN_DEADBAND, Constants.DRIVETRAIN_USE_SQUARED);
    m_driveTrain.setSpeed(0);
    m_driveTrain.setTurn(0);
    m_driveTrain.run();
    txNavSame = false;
    centered = false;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(m_isContinous){
      if(center!=0){
        return txNavSame; 
      }else{
        return centered; 
      }
    }else{
      return false;
    }
  }
}
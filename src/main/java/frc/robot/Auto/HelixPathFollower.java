/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Auto;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;

import com.team2363.controller.PIDController;
import com.team2363.logger.HelixLogger;
import com.team319.trajectory.Path;
import com.team319.trajectory.Path.SegmentValue;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Framework.Logging.CSVServer;
import frc.robot.subsystems.Drivetrain;

public class HelixPathFollower extends HelixFollowerNewCommand {
  /**
   * Creates a new HelixPathFollower.
   */
  Drivetrain m_drivetrain;

  private PIDController headingController = new PIDController(10, 0, 0, 0.01);
  private PIDController distanceController = new PIDController(2, 0, 0, 0.01);
  ArrayList<String[]> points;
  private double ticksPerFoot = 6.5237d;
  CSVServer serv;
  private double feetPerSecondToRpm = (60.0 * 10.6666) / (Math.PI * (6.25 / 12.0));
  private double RpmToFeetPerSecond = (Math.PI * (6.25 / 12.0)) / (60.0 * 10.6666);
  public HelixPathFollower(Path path, Drivetrain drivetrain) {
    super(path);
    m_drivetrain = drivetrain;
    
    serv = new CSVServer();// generate a server
    points= new ArrayList<String[]>();
    String[] header = { "right vel", "real right vel", " left vel", " real left vel", "real heading", "path heading" };
    points.add(header);
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  @Override
  public void resetDistance() {
    m_drivetrain.resetEncoders();

  }

  @Override
  public PIDController getHeadingController() {
    // TODO Auto-generated method stub
    return headingController;
  }

  @Override
  public PIDController getDistanceController() {
    // TODO Auto-generated method stub
    return distanceController;
  }

  @Override
  public double getCurrentDistance() {
    // TODO Auto-generated method stub
    return m_drivetrain.getAverageDistance()/ticksPerFoot;
  }

  @Override
  public double getCurrentHeading() {
    // TODO Auto-generated method stub
    
    return Math.toRadians(m_drivetrain.returnAngle());
  }
  @Override
    public void end(boolean interrupted){
      super.end(interrupted);
      m_drivetrain.arcadeDrive(0, 0, 0, false);
      m_drivetrain.run();
      m_drivetrain.setTurn(0);
      m_drivetrain.setSpeed(0);
      m_drivetrain.run();
      try {
        points.add(m_drivetrain.getPIDVariables());
        DriverStation.reportError("sending data",false);
        DriverStation.reportError("dist. traveled "+m_drivetrain.getAverageDistance()/ticksPerFoot,false);
        serv.sendDataAccrossNetwork(points);
        DriverStation.reportError("sent data", false);
      } catch (IOException e) {
        DriverStation.reportError("some sort of erro", false);
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  @Override
  public void useOutputs(double left, double right,double unLeft, double unRight) {
    String[] currentVels = new String[6];
    currentVels[0] = "" + unRight;//un corrected right
    currentVels[1] = "" + -m_drivetrain.returnRightVelocity()*RpmToFeetPerSecond;
    currentVels[2] = "" + -left;
    currentVels[3] = "" + m_drivetrain.returnLeftVelocity()*RpmToFeetPerSecond;
    if(currentSegment<trajectory.getSegmentCount()){
      currentVels[5] = "" +Math.toDegrees(trajectory.getValue(currentSegment, SegmentValue.HEADING));
    }else{
      currentVels[5]=""+0;
    }
    HelixLogger.getInstance
    
    currentVels[4] = ""+ m_drivetrain.returnAngle();
    points.add(currentVels);
    //DriverStation.reportError("outputs are being used", false);
    m_drivetrain.setVelocity(left*feetPerSecondToRpm, right*feetPerSecondToRpm, 0, 0,0);
  }

}

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
import com.team319.trajectory.Path;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Framework.Logging.CSVServer;
import frc.robot.subsystems.Drivetrain;

public class HelixPathFollower extends HelixFollowerNewCommand {
  /**
   * Creates a new HelixPathFollower.
   */
  Drivetrain m_drivetrain;

  private PIDController headingController = new PIDController(15, 0, 0, 0.01);
  private PIDController distanceController = new PIDController(10, 0, 0, 0.01);
  ArrayList<String[]> points;
  
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
    // TODO Auto-generated method stub

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
    return 0;
  }

  @Override
  public double getCurrentHeading() {
    // TODO Auto-generated method stub
    return 0;
  }
  @Override
    public void end(boolean interrupted){
      m_drivetrain.arcadeDrive(0, 0, 0, false);
      m_drivetrain.run();
      try {
        points.add(m_drivetrain.getPIDVariables());
        DriverStation.reportError("sending data",false);
        serv.sendDataAccrossNetwork(points);
        DriverStation.reportError("sent data", false);
      } catch (IOException e) {
        DriverStation.reportError("some sort of erro", false);
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      super.end(interrupted);
    }
  @Override
  public void useOutputs(double left, double right) {
    String[] currentVels = new String[6];

    currentVels[0] = "" + right;
    currentVels[1] = "" + -m_drivetrain.returnRightVelocity()*RpmToFeetPerSecond;
    currentVels[2] = "" + -left;
    currentVels[3] = "" + m_drivetrain.returnLeftVelocity()*RpmToFeetPerSecond;
    currentVels[4] = "" +0;
    currentVels[5] = ""+ 0;
    points.add(currentVels);
    //DriverStation.reportError("outputs are being used", false);
    m_drivetrain.setVelocity(left*feetPerSecondToRpm, right*feetPerSecondToRpm, 0, 0, 0);
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.FlywheelCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Limelight;
import frc.robot.Framework.LookupTable;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShootwithLookup extends CommandBase {
  /**
   * Creates a new ShootwithLookup.
   */
  private Flywheel m_flywheel;
  private Limelight m_limelight;
  private boolean stopFlywheelPostShot;
  private LookupTable lookupTable;
  private double speed;

  public ShootwithLookup(Flywheel f, Limelight l, boolean s) {
    m_flywheel = f;
    m_limelight = l;
    stopFlywheelPostShot = s;
    try {
      lookupTable = new LookupTable(Constants.THOR_VALS, Constants.FLYWHEEL_RPMS);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // Use addRequirements() here to declare subsystem dependencies.
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if(SmartDashboard.getNumber("ShootFar Setpoint", speed)>=2000){
      m_flywheel.updateSetpoint(SmartDashboard.getNumber("ShootFar Setpoint", speed));
    }
    else{
      lookupTable.update(SmartDashboard.getNumber("ShootFar Setpoint", speed));
      speed=lookupTable.get(m_limelight.getThor());
      m_flywheel.updateSetpoint(speed);
    }
    m_flywheel.setHood(true);
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_flywheel.runMotors();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    if(!interrupted){
      //DriverStation.reportError("is interupted",false);
    }

    //DriverStation.reportError("is interupted false",false);
    if(stopFlywheelPostShot){
      m_flywheel.setMotorPercentOutput(0.0);
    }
    m_flywheel.setHood(false);
  }
  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LimelightCommands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

public class TurnUntilSeesTarget extends CommandBase {
  /**
   * Creates a new TurnUntilSeesTarget.
   */
  private Limelight m_limelight; 
  private Drivetrain m_drivetrain;
  private double count = 5;
  private int direction = 1; // pos means turn robot right

  public TurnUntilSeesTarget(Drivetrain drivetrain, Limelight limelight) {
    m_limelight = limelight;
    m_drivetrain = drivetrain;
    addRequirements(drivetrain);

    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {    
    if(m_drivetrain.returnAngle() < 0){
      direction = -1;
    }
    else{
      direction = 1;
    }
    m_drivetrain.setCoast();
    count = 5;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_limelight.hasTarget()){
      count--;
    }
    m_drivetrain.setTurn(direction*.4);
    m_drivetrain.run();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.setSpeed(0);
    m_drivetrain.setTurn(0);
    m_drivetrain.run();
    m_drivetrain.setBrake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return count<=0;
  }
}

/**
 * Peddie 5895 FIRST Robotics
 * Drive.java
 * ArcadeDrive (joystick drive) command for the robot's drivetrain.
 */

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class Drive extends CommandBase {
  
  private Drivetrain m_drivetrain;

  private boolean isNormalizedDrive;
  private boolean isRunningDrivetrainRun;
  public Drive( Drivetrain driveTrain, boolean needsToRunRun ) {
    isRunningDrivetrainRun = needsToRunRun;
    m_drivetrain = driveTrain;
    addRequirements(driveTrain);
    isNormalizedDrive = false;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double speedInput = m_drivetrain.getSpeed();
    double turnInput = m_drivetrain.getTurn();

    /**
     * if we decide to drive normalized 
     * meaning normalizedDrive = true,
     * drive normalized. otherwise, usual 
     */
    if( isNormalizedDrive ){
      NormalizedDrive( speedInput, turnInput );
    } else {
      m_drivetrain.arcadeDrive(speedInput, turnInput);
    }
     m_drivetrain.run();

  }

  private void NormalizedDrive( double speed, double turn ) {

    //find the maximum possible value of (throttle + turn)
    	//along the vector that the arcade joystick is pointing
    	double saturatedInput;
    	double greaterInput = Math.max(Math.abs(speed), Math.abs(turn));
    		//range [0, 1]
    	double lesserInput = Math.abs(speed) + Math.abs(turn) - greaterInput;
    		//range [0, 1]
    	if (greaterInput > 0.0) {
    		saturatedInput = (lesserInput / greaterInput) + 1.0;
       		//range [1, 2]
    	} else {
    		saturatedInput = 1.0;
    	}
     	
    	//scale down the joystick input values
		  //such that (throttle + turn) always has a range [-1, 1]
    	speed = speed / saturatedInput;
		  turn = turn / saturatedInput;
    
      m_drivetrain.arcadeDrive( speed, turn );
      m_drivetrain.run();

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end( boolean interrupted ) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
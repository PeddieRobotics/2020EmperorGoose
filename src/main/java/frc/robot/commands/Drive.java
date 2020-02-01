package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.RobotContainer;


public class Drive extends CommandBase {
  /**
   * Creates a new ArcadeDrive.
   */
  private Drivetrain drive;
  private RobotContainer rContainer;

  private boolean normalizedDrive;

  public Drive() {

    drive = new Drivetrain();
    rContainer = new RobotContainer();

    addRequirements( drive );

    normalizedDrive = true; //WE ARE DRIVING NORMALIZED

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double speedInput = rContainer.getSpeed();
    double turnInput = rContainer.getTurn();

    /**
     * if we decide to drive normalized 
     * meaning normalizedDrive = true,
     * drive normalized. otherwise, usual 
     */
    if( normalizedDrive ){
      NormalizedDrive( speedInput, turnInput );
    } else {
      drive.periodic( speedInput, turnInput );
    }

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

    drive.periodic( speed, turn );


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

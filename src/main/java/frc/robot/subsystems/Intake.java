package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Intake extends SubsystemBase {

  private static enum IntakeModeType {
    INTAKING, DISABLED, REVERSE
  }

  private IntakeModeType currentMode;
  
  private boolean isDown;

  private Solenoid intakeSolenoid;
  
  private TalonSRX intakeMotorTalon;
  
  private VictorSPX intakeMotorVictor;  //both are to use if we change the intake motor. atm, not used.

  public Intake() {

    currentMode = IntakeModeType.DISABLED;
    isDown = false;
    
    intakeSolenoid = new Solenoid(Constants.SOLENOID_INTAKE);
         /**
     * changes the motors based off if the robot is comp bot or pbot
     */
    if( RobotContainer.isCompetitionRobot() ) { //comp robot has TalonSRX's
      //left and right motors for the v-belts
      intakeMotorTalon = new TalonSRX( Constants.HOPPER_LEFT_WALL );
     
    } else {  //pbot has VictorSPX's
      intakeMotorVictor = new VictorSPX( Constants.HOPPER_RIGHT_WALL );
    }

  }

  public void setIntakeMotor(double setpoint){
    if(RobotContainer.isCompetitionRobot()){
      intakeMotorTalon.set(ControlMode.PercentOutput,setpoint);
    }
    else{
      intakeMotorVictor.set(ControlMode.PercentOutput,setpoint);    
    }

  }
  
  /**
   * @return whether we're intaking or not
   */
  public boolean isIntaking() {

    return( currentMode == IntakeModeType.INTAKING );
  }

  /**
   * @return true if the intake is down, false if it is up
   */
  public boolean isIntakeDown() {

    return isDown;
  }

  @Override
  public void periodic() {
  
    // This method will be called once per scheduler run
  }

 /**
   * start intake
   */
  public void startIntake() {
    intakeSolenoid.set(true);
    currentMode = IntakeModeType.INTAKING;
    setIntakeMotor( .8 ); 
  }

  /**
   * stop intake
   */
  public void stopIntake() {
    intakeSolenoid.set(false);
    currentMode = IntakeModeType.DISABLED;
    setIntakeMotor( 0 );
  }

  /**
   * Run the intake in reverse (to fix jams).
   */
  public void reverse() {

    currentMode = IntakeModeType.REVERSE;
    setIntakeMotor( -0.5 );

  }

  public void lowerIntake(){

    intakeSolenoid.set(true);
  }

  public void raiseIntake(){

    intakeSolenoid.set(false);
  }

}
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Intake extends SubsystemBase {

  private static enum Intake_Mode_Type {
    INTAKING, DISABLED, REVERSE
  }

  public Intake_Mode_Type currentMode;
  private Solenoid intakeSolenoid;
  private boolean isDown;

  private TalonSRX intakeMotorTalon;
  private VictorSPX intakeMotorVictor;  //both are to use if we change the intake motor. atm, not used.

  //private TalonSRX intakeMotor;
  private VictorSPX intakeMotor;  //MOTOR IN USE (currently)

  public Intake() {

    currentMode = Intake_Mode_Type.DISABLED;
    intakeSolenoid = new Solenoid(Constants.SOLENOID_INTAKE_1);
    isDown = false;
    intakeMotorTalon= new TalonSRX(9);
  }

  public void setIntakeMotor(double setpoint){
    
    intakeMotorTalon.set(ControlMode.PercentOutput,setpoint);

  }
  
  /**
   * 
   * @param up whether the intake is up or not
   */
  public void setSoleniods( boolean up ){

    if( up ) {
      currentMode = Intake_Mode_Type.DISABLED;
    } else {
      currentMode = Intake_Mode_Type.INTAKING;
    }

    intakeSolenoid.set( up );

  }

  /**
   * start intake
   */
  public void startIntake() {
   setIntakeMotor( .8 ); 
    intakeSolenoid.set(true);

  }

  /**
   * stop intake
   */
  public void stopIntake() {

    currentMode = Intake_Mode_Type.DISABLED;
    setIntakeMotor( 0 );
    intakeSolenoid.set(false);

  }

  /**
   * @return whether we're intaking or not
   */
  public boolean isIntaking() {

    return( currentMode == Intake_Mode_Type.INTAKING );

  }

  @Override
  public void periodic() {
  
    // This method will be called once per scheduler run

  }

  /**
   * intake the ball(s)
   */
  public void intake() {
    
    intakeMotor.set( ControlMode.PercentOutput, .5 );
    intakeMotor.set( ControlMode.PercentOutput, .5 );

   intakeSolenoid.set(true);

  }

  /**
   * reverse intake (to fix jams)
   */
  public void reverse() {

    intakeMotor.set( ControlMode.PercentOutput, -.5 );
    intakeMotor.set( ControlMode.PercentOutput, -.5 );


  }

  /**
   * disable
   */
  public void disable() {

    intakeMotor.set( ControlMode.PercentOutput, 0 );
    intakeMotor.set( ControlMode.PercentOutput, 0 );
    intakeSolenoid.set(false);

  }

}
//change enum to boolean (is it down or up)
//
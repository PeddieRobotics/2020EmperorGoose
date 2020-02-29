package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  private static enum IntakeModeType {
    INTAKING, DISABLED, REVERSE
  }

  private IntakeModeType currentMode;
  
  private Solenoid intakeSolenoid;
  
  private TalonSRX intakeMotorTalon;
  
  private VictorSPX intakeMotorVictor;  //both are to use if we change the intake motor. atm, not used.

  public Intake() {

    currentMode = IntakeModeType.DISABLED;
    
    intakeSolenoid = new Solenoid(Constants.SOLENOID_INTAKE);
    intakeMotorTalon= new TalonSRX(9);//intake is a talon on both robots
    intakeMotorTalon.configContinuousCurrentLimit(20,0);
    intakeMotorTalon.configPeakCurrentDuration(100, 0);   
    intakeMotorTalon.enableCurrentLimit(true);
    intakeMotorTalon.configPeakCurrentLimit(30, 0);
  }

  public void setIntakeMotor(double setpoint){
    
    intakeMotorTalon.set(ControlMode.PercentOutput,setpoint);
    

  }
  
  /**
   * @return whether we're intaking or not
   */
  public boolean isIntaking() {

    return( currentMode == IntakeModeType.INTAKING );
  }

  @Override
  public void periodic() {
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

}
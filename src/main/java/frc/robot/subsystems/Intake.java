package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Intake extends SubsystemBase {

  private static enum Intake_Mode_Type {
    INTAKING, DISABLED, REVERSE
  }

  public Intake_Mode_Type currentMode;
  private Solenoid leftSolenoid, rightSolenoid;
  private boolean isDown;

  private TalonSRX intakeMotorTalon;
  private VictorSPX intakeMotorVictor;

  //private TalonSRX intakeMotor;
  private VictorSPX intakeMotor;
  public Intake() {
    currentMode = Intake_Mode_Type.DISABLED;
    //leftSolenoid = new Solenoid(Constants.SOLENOID_INTAKE_1);
    //rightSolenoid = new Solenoid(Constants.SOLENOID_INTAKE_2);
    isDown = false;
    intakeMotor = new VictorSPX(Constants.INTAKE_MOTOR);

    intakeMotorTalon = new TalonSRX(Constants.INTAKE_MOTOR);
    intakeMotorVictor = new VictorSPX(Constants.INTAKE_MOTOR);
  }
  public void setIntakeMotor(double setpoint){
    if(Robot.isCompetitionRobot()){
      intakeMotorTalon.set(ControlMode.PercentOutput,setpoint);
    }else{
      intakeMotorVictor.set(ControlMode.PercentOutput,setpoint);
    }
    //intakeMotor = new TalonSRX(Constants.INTAKE_MOTOR_1);
  }
  public void setSoleniods(boolean up){
    if(up){
      currentMode = Intake_Mode_Type.DISABLED;
    }else{
      currentMode = Intake_Mode_Type.INTAKING;
    }
    leftSolenoid.set(up);
    rightSolenoid.set(up);
  }
  public void startIntake(){
   currentMode = Intake_Mode_Type.INTAKING;
   setIntakeMotor(1.0); 
  }
  public void stopIntake(){
    currentMode = Intake_Mode_Type.DISABLED;
    setIntakeMotor(0);
  }
  public boolean isIntaking(){
    return(currentMode == Intake_Mode_Type.INTAKING);
  }
  @Override
  public void periodic() {
  
    // This method will be called once per scheduler run

  }

  public void intaking() {
    intakeMotor.set(ControlMode.PercentOutput, .5);
    intakeMotor.set(ControlMode.PercentOutput, .5);
    leftSolenoid.set(true);
    rightSolenoid.set(true);
  }

  public void reverse() {
    intakeMotor.set(ControlMode.PercentOutput, -.5);
    intakeMotor.set(ControlMode.PercentOutput, -.5);
    leftSolenoid.set(true);
    rightSolenoid.set(true);
  }

  public void disable() {
    intakeMotor.set(ControlMode.PercentOutput, 0);
    intakeMotor.set(ControlMode.PercentOutput, 0);
    leftSolenoid.set(false);
    rightSolenoid.set(false);
  }
}
//change enum to boolean (is it down or up)
//
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  private static enum Intake_Mode_Type {
    INTAKING, DISABLED, REVERSE
  }
  private Intake_Mode_Type mode;

  private Solenoid leftSolenoid, rightSolenoid;
  private boolean isDown;

  //private TalonSRX intakeMotor;
  private VictorSPX intakeMotor;
  public Intake() {

    leftSolenoid = new Solenoid(Constants.SOLENOID_INTAKE_1);
    rightSolenoid = new Solenoid(Constants.SOLENOID_INTAKE_2);
    isDown = false;
    intakeMotor = new VictorSPX(Constants.INTAKE_MOTOR_1);

    //intakeMotor = new TalonSRX(Constants.INTAKE_MOTOR_1);
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
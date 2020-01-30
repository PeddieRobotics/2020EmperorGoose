package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  private static enum Intake_Mode_Type {
    INTAKING, DISABLED
  }
  private Intake_Mode_Type mode;

  private Solenoid leftSolenoid, rightSolenoid;
  private boolean isDown;

  private TalonSRX leftIntakeMotor, rightIntakeMotor;

  public Intake() {

    leftSolenoid = new Solenoid(Constants.SOLENOID_INTAKE_1);
    rightSolenoid = new Solenoid(Constants.SOLENOID_INTAKE_2);
    isDown = false;

    leftIntakeMotor = new TalonSRX(Constants.INTAKE_MOTOR_1);
    rightIntakeMotor = new TalonSRX(Constants.INTAKE_MOTOR_2);

  }

  public void intake(boolean isIntaking) {

    if( isIntaking ) {
      mode = Intake_Mode_Type.INTAKING;
    } else {
      mode = Intake_Mode_Type.DISABLED;
    }

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    switch( mode ) 
    {

      case INTAKING:

        isDown = true;
        leftIntakeMotor.set(ControlMode.PercentOutput, .5);
        rightIntakeMotor.set(ControlMode.PercentOutput, .5);

      break;

      case DISABLED:

        isDown = false;
        leftIntakeMotor.set(ControlMode.PercentOutput, 0);
        rightIntakeMotor.set(ControlMode.PercentOutput, 0);

      break;

    }

    leftSolenoid.set(isDown);
    rightSolenoid.set(isDown);
  }
}

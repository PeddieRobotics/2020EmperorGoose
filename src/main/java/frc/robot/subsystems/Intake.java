package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {

  private static enum Intake_Mode_Type {
    DOWN, UP
  }

  private Intake_Mode_Type mode;

  private Solenoid intakeSolenoid;
  private boolean isDown;

  private TalonSRX intakeMotor;

  private 

  public Intake() {

    intakeSolenoid = new Solenoid(Constants.SOLENOID_INTAKE);
    isDown = false;

    intakeMotor = new TalonSRX(Constants.INTAKE_MOTOR);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    switch( mode ) 
    {

      case DOWN:

        isDown = true;
        intakeMotor.set(ControlMode.PercentOutput, 1);

      break;

      case UP:

        isDown = false;
        intakeMotor.set(ControlMode.PercentOutput, 0);

      break;

    }

    intakeSolenoid.set(isDown);
  }
}

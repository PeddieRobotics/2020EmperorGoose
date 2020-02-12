package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HotDog extends SubsystemBase {

  private static enum HotDog_Mode_Type {
    INTAKING, DISABLED, REVERSE
  }

  private final TalonSRX leftM, rightM;

  private HotDog_Mode_Type mode;

  public HotDog() {
    leftM = new TalonSRX(Constants.HOTDOG_LEFT);
    rightM = new TalonSRX(Constants.HOTDOG_RIGHT);
  }

  public void rollingF(boolean isRollingF) {
    if (isRollingF) {
      mode = HotDog_Mode_Type.INTAKING;
    } else mode = HotDog_Mode_Type.DISABLED;
  }

  public void rollingB(boolean isRollingB) {
    if (isRollingB) {
      mode = HotDog_Mode_Type.REVERSE;
    } else mode = HotDog_Mode_Type.DISABLED;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    switch( mode )
    {

      case INTAKING:
        leftM.set(ControlMode.PercentOutput, 15);
        rightM.set(ControlMode.PercentOutput, 15);
      break;

      case DISABLED:
        leftM.set(ControlMode.PercentOutput, 0);
        rightM.set(ControlMode.PercentOutput, 0);
      break;

      case REVERSE:
        leftM.set(ControlMode.PercentOutput, -15);
        rightM.set(ControlMode.PercentOutput, -15);
      break;

    }
  }
}

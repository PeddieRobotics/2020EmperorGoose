package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Auto.PIDClasses.NEOPIDWithSmartDashboard;

public class HotDog extends SubsystemBase {

  private static enum HotDog_Mode_Type {
    INTAKING, DISABLED, REVERSE
  }

  private final TalonSRX leftM, rightM, hotDog;

  private HotDog_Mode_Type mode;

  public HotDog() {
  //  NEOPIDWithSmartDashboard motor = new NEOPIDWithSmartDashboard(1);
    //left and right motors for the HotDog belts
    leftM = new TalonSRX(Constants.HOTDOG_LEFT);
    rightM = new TalonSRX(Constants.HOTDOG_RIGHT);
    hotDog = new TalonSRX(Constants.HOTDOG_ROLLER);
  }

  public void rollingF(boolean isRollingF) {
    //if the belt is rolling "in", the HotDog intakes
    if (isRollingF) {
      mode = HotDog_Mode_Type.INTAKING;
    } else mode = HotDog_Mode_Type.DISABLED;
  }

  public void rollingB(boolean isRollingB) {
    //if the belt is rolling "out", the belt is moving away from the tower (opposite direction)
    if (isRollingB) {
      mode = HotDog_Mode_Type.REVERSE;
    } else mode = HotDog_Mode_Type.DISABLED;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    switch( mode )
    {

      //when the HotDog is intaking, speed is set to 15 m/s
      case INTAKING:
        leftM.set(ControlMode.PercentOutput, 5);
        rightM.set(ControlMode.PercentOutput, 10);
        hotDog.set(ControlMode.PercentOutput, 5);
      break;

      case DISABLED:
        leftM.set(ControlMode.PercentOutput, 0);
        rightM.set(ControlMode.PercentOutput, 0);
        hotDog.set(ControlMode.PercentOutput, 0);
      break;

      //when the HotDog belts spin away from the tower, change sign to change direction
      case REVERSE:
        leftM.set(ControlMode.PercentOutput, -5);
        rightM.set(ControlMode.PercentOutput, -10);
        hotDog.set(ControlMode.PercentOutput, -5);
      break;

    }
    
  }
}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Auto.PIDClasses.NEOPIDWithSmartDashboard;

public class HotDog extends SubsystemBase {

  private static enum HotDog_Mode_Type {
    INTAKING, DISABLED, REVERSE
  }

//  private final TalonSRX leftM, rightM, hotDog;
private final VictorSPX leftM, rightM, hotDog;
  private HotDog_Mode_Type mode;

  public HotDog() {
  //  NEOPIDWithSmartDashboard motor = new NEOPIDWithSmartDashboard(1);
    //left and right motors for the HotDog belts
  /*  leftM = new TalonSRX(Constants.HOTDOG_LEFT);
    rightM = new TalonSRX(Constants.HOTDOG_RIGHT);
    hotDog = new TalonSRX(Constants.HOTDOG_ROLLER);*/ 
    leftM = new VictorSPX(Constants.HOTDOG_LEFT);
    rightM = new VictorSPX(Constants.HOTDOG_RIGHT);
    hotDog = new VictorSPX(Constants.HOTDOG_ROLLER);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    }
  
    public void HDIntaking() {
      leftM.set(ControlMode.PercentOutput, 1);
      rightM.set(ControlMode.PercentOutput, -2);
      hotDog.set(ControlMode.PercentOutput, -1);
    }

    public void HDDisabled() {
      leftM.set(ControlMode.PercentOutput, 0);
      rightM.set(ControlMode.PercentOutput, 0);
      hotDog.set(ControlMode.PercentOutput, 0);
    }
    
    public void HDReverse() {
      leftM.set(ControlMode.PercentOutput, -1);
      rightM.set(ControlMode.PercentOutput, 2);
      hotDog.set(ControlMode.PercentOutput, 1);
    }
}

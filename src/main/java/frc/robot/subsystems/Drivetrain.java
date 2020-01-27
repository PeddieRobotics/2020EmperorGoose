package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  //motors (NEOs & SparkMax's)
  private CANSparkMax leftMaster, leftFollower;
  private CANSparkMax rightMaster, rightFollower;

  private double leftNyoom;
  private double rightNyoom;

  public Drivetrain() {

    //initializing motors
    leftMaster = new CANSparkMax(Constants.LEFT_MASTER, MotorType.kBrushless);
    leftFollower = new CANSparkMax(Constants.LEFT_FOLLOWER, MotorType.kBrushless);
    rightMaster = new CANSparkMax(Constants.RIGHT_MASTER, MotorType.kBrushless);
    rightFollower = new CANSparkMax(Constants.RIGHT_FOLLOWER, MotorType.kBrushless);

  }

  //arcade drive
  public void periodic( double speed, double turn ) {

    leftNyoom = speed - turn;
    rightNyoom = speed + turn;

    leftMaster.set(leftNyoom);
      leftFollower.follow(leftMaster);
    rightMaster.set(rightNyoom);
      rightFollower.follow(rightMaster);

  }
}

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  //motors (NEOs & SparkMax's)
  private CANSparkMax leftMaster, leftFollower1, leftFollower2;
  private CANSparkMax rightMaster, rightFollower1, rightFollower2;

  private double leftNyoom;
  private double rightNyoom;

  public Drivetrain() {

    //initializing motors
    leftMaster = new CANSparkMax(Constants.LEFT_MASTER, MotorType.kBrushless);
    leftFollower1 = new CANSparkMax(Constants.LEFT_FOLLOWER_1, MotorType.kBrushless);
    leftFollower2 = new CANSparkMax(Constants.LEFT_FOLLOWER_2, MotorType.kBrushless);
    rightMaster = new CANSparkMax(Constants.RIGHT_MASTER, MotorType.kBrushless);
    rightFollower1 = new CANSparkMax(Constants.RIGHT_FOLLOWER_1, MotorType.kBrushless);
    rightFollower2 = new CANSparkMax(Constants.RIGHT_FOLLOWER_2, MotorType.kBrushless);

  }

  //arcade drive
  public void periodic( double speed, double turn ) {

    leftNyoom = speed - turn;
    rightNyoom = speed + turn;

    leftMaster.set(leftNyoom);
      leftFollower1.follow(leftMaster);
      leftFollower2.follow(leftMaster);
    rightMaster.set(rightNyoom);
      rightFollower1.follow(rightMaster);
      rightFollower2.follow(rightMaster);

  }
}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Hopper extends SubsystemBase {

  private static enum Hopper_Mode_Type {
    INTAKING, DISABLED, REVERSE
  }
  
  private TalonSRX leftWallTalon, rightWallTalon, floorTalon;
  private VictorSPX leftWallVictor, rightWallVictor, floorVictor;


  public Hopper() {
    if(Robot.isCompetitionRobot()){
    //left and right motors for the HotDog belts
      leftWallTalon = new TalonSRX(Constants.HOPPER_LEFT_WALL);
      rightWallTalon = new TalonSRX(Constants.HOPPER_RIGHT_WALL);
      floorTalon = new TalonSRX(Constants.HOPPER_FLOOR);
    }else{
      rightWallVictor = new VictorSPX(Constants.HOPPER_LEFT_WALL);
      
      leftWallVictor = new VictorSPX(Constants.HOPPER_RIGHT_WALL);
      floorVictor = new VictorSPX(Constants.HOPPER_FLOOR);
    }
}
  public void setMotors(TalonSRX talonMotor, VictorSPX victorMotor, double setpoint){
    if(Robot.isCompetitionRobot()){
      talonMotor.set(ControlMode.PercentOutput, setpoint);
    }else{
      victorMotor.set(ControlMode.PercentOutput,setpoint);
    }
  }
  public void setFloor(double setpoint){
    setMotors(floorTalon,floorVictor,setpoint);
  }
  public void setLeftWall(double setpoint){ 
    setMotors(leftWallTalon,leftWallVictor,setpoint);
  }
  public void setRightWall(double setpoint){
    setMotors(rightWallTalon,rightWallVictor,setpoint);
  }
  public void runAll(){
    setRightWall(-.3);
    setLeftWall(.2);
    setFloor(-.3);
  }

  @Override
  public void periodic() {
    
  }
}

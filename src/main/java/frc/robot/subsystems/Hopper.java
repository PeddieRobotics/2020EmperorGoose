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
    floorTalon = new TalonSRX( Constants.HOPPER_FLOOR );

     /**
     * changes the motors based off if the robot is comp bot or pbot
     */
    if( Robot.isCompetitionRobot() ) { //comp robot has TalonSRX's

      //left and right motors for the HotDog belts
      leftWallTalon = new TalonSRX( Constants.HOPPER_LEFT_WALL );
      rightWallTalon = new TalonSRX( Constants.HOPPER_RIGHT_WALL );
   
    } else {  //pbot has VictorSPX's

      rightWallVictor = new VictorSPX( Constants.HOPPER_LEFT_WALL );
      leftWallVictor = new VictorSPX( Constants.HOPPER_RIGHT_WALL );
//      floorVictor = new VictorSPX( Constants.HOPPER_FLOOR );

    }
  }

  /**
   * sets motors
   * @param talonMotor the TalonSRX motor
   * @param victorMotor the VictorSPX motor
   * @param setpoint the value to set the motors to
   * 
   * NOTE: needs to be set with a Talon AND a Victor whether or not both are used.
   * One of the motors is just a filler for the method to be called while the method
   * is still like this and the comp bot & pbot not yet have the same motor types.
   * Just include both. It's weird, but do it. Only one will be used.
   */
  public void setMotors( TalonSRX talonMotor, VictorSPX victorMotor, double setpoint ) {

    if( Robot.isCompetitionRobot() ) {
      talonMotor.set( ControlMode.PercentOutput, setpoint );
    } else {
      victorMotor.set( ControlMode.PercentOutput, setpoint );
    }

  }

  /**
   * @param setpoint set the floor to this speed
   */
  public void setFloor( double setpoint ) {
    floorTalon.set( ControlMode.PercentOutput, setpoint );
  

  }

  /**
   * @param setpoint set the left wall to this speed
   */
  public void setLeftWall( double setpoint ) { 

    setMotors( leftWallTalon, leftWallVictor, setpoint );

  }

  /**
   * @param setpoint set th right wall to this speed
   */
  public void setRightWall( double setpoint ) {

    setMotors( rightWallTalon, rightWallVictor, setpoint );

  }

/**
 * run all parts of the hopper
 * @param floorSetpoint set the floor to this speed
 * @param leftSetpoint set the left wall to this speed
 * @param rightSetpoint set the right wall to this speed
 */
  public void runAll( double floorSetpoint, double leftSetpoint, double rightSetpoint ) {

    setRightWall( rightSetpoint );  //currently: -0.3
    setLeftWall( leftSetpoint );    //currently:  0.2
    setFloor( floorSetpoint );      //currently: -0.3

  }

  @Override
  public void periodic() {
  }
  
}

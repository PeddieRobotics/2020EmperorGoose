package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class Hopper extends SubsystemBase {

  private static enum HopperModeType {
    INTAKING, DISABLED, REVERSE
  }

  private HopperModeType currentMode;
  
  private TalonSRX leftWallTalon, rightWallTalon, floorTalon;
  private VictorSPX leftWallVictor, rightWallVictor, floorVictor;


  public Hopper() {
    currentMode = HopperModeType.DISABLED;
    
    floorTalon = new TalonSRX( Constants.HOPPER_FLOOR );
    floorTalon.configPeakCurrentLimit(10, 0);
    floorTalon.configContinuousCurrentLimit(10,0);
    floorTalon.configPeakCurrentDuration(100, 0);  
    floorTalon.enableCurrentLimit(true);
     /**
     * changes the motors based off if the robot is comp bot or pbot
     */
    if( RobotContainer.isCompetitionRobot() ) { //comp robot has TalonSRX's

      //left and right motors for the v-belts
      leftWallTalon = new TalonSRX( Constants.HOPPER_LEFT_WALL );
      rightWallTalon = new TalonSRX( Constants.HOPPER_RIGHT_WALL );

      rightWallTalon.configContinuousCurrentLimit(10,0);
      rightWallTalon.configPeakCurrentDuration(100, 0);   
      rightWallTalon.enableCurrentLimit(true);
      rightWallTalon.configPeakCurrentLimit(10, 0);
      leftWallTalon.configContinuousCurrentLimit(10,0);
      leftWallTalon.configPeakCurrentDuration(100, 0); 
      leftWallTalon.configPeakCurrentLimit(10, 0); 
      leftWallTalon.enableCurrentLimit(true);
    
      floorTalon = new TalonSRX( Constants.HOPPER_FLOOR );

   
    } else {  //pbot has VictorSPX's

      rightWallVictor = new VictorSPX( Constants.HOPPER_RIGHT_WALL );
      leftWallVictor = new VictorSPX( Constants.HOPPER_LEFT_WALL );
//      floorVictor = new VictorSPX( Constants.HOPPER_FLOOR ); floor always talon
      
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

    if( RobotContainer.isCompetitionRobot() ) {
      talonMotor.set( ControlMode.PercentOutput, setpoint );
    } else {
      victorMotor.set( ControlMode.PercentOutput, setpoint );
    }

  }

  /**
   * @param setpoint set the floor to this speed
   */
  public void setFloor( double setpoint ) {
    if(RobotContainer.isCompetitionRobot()){
      floorTalon.set(ControlMode.PercentOutput, setpoint);
    }
    else{
      floorVictor.set(ControlMode.PercentOutput, setpoint);
    }

  }

  /**
   * @param setpoint set the left wall to this speed
   */
  public void setLeftWall( double setpoint ) { 
    if(RobotContainer.isCompetitionRobot()){
      leftWallTalon.set(ControlMode.PercentOutput, setpoint);
    }
    else{
      leftWallVictor.set(ControlMode.PercentOutput, setpoint);
    }

  }

  /**
   * @param setpoint set th right wall to this speed
   */
    public void setRightWall( double setpoint ) {
      if(RobotContainer.isCompetitionRobot()){
        rightWallTalon.set(ControlMode.PercentOutput, setpoint);
      }
      else{
        rightWallVictor.set(ControlMode.PercentOutput, setpoint);
      }
    }


  /**
 * run all parts of the hopper
 * @param floorSetpoint set the floor to this speed
 * @param leftSetpoint set the left wall to this speed
 * @param rightSetpoint set the right wall to this speed
 */

  public void runAll() {
    
    setRightWall( -0.5 ); //Taking in
    setLeftWall( -0.5 ); //Going out
    setFloor( -0.5 ); //Taking in

    currentMode = HopperModeType.INTAKING;

  }
  public void stopAll(){
    
    setRightWall( 0 ); 
    setLeftWall( 0 );    
    setFloor( 0 );

    currentMode = HopperModeType.DISABLED;
  }

  @Override
  public void periodic() {
  }

  public boolean isIntaking() {
    return( currentMode == HopperModeType.INTAKING );
  }

  public void reverse(double setpoint){

    setLeftWall(setpoint);
    setRightWall(setpoint);
    setFloor(setpoint);

  }
  
}

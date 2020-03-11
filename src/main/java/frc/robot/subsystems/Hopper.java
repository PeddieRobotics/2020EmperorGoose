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
    
     /**
     * changes the motors based off if the robot is comp bot or pbot
     */
    if( Constants.COMPETITION_ROBOT ) { //comp robot has TalonSRX's
      floorTalon = new TalonSRX( Constants.HOPPER_FLOOR );
      floorTalon.configPeakCurrentLimit(10, 0);
      floorTalon.configContinuousCurrentLimit(10,0);
      floorTalon.configPeakCurrentDuration(100, 0);  
      floorTalon.enableCurrentLimit(true);

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
    
    } else {  //pbot has VictorSPX's

      rightWallVictor = new VictorSPX( Constants.HOPPER_RIGHT_WALL );
      leftWallVictor = new VictorSPX( Constants.HOPPER_LEFT_WALL );
      floorVictor = new VictorSPX( Constants.HOPPER_FLOOR );
      
    }
    
  }

  /**
   * @param setpoint set the floor to this speed
   */
  public void setFloor( double setpoint ) {
    if(Constants.COMPETITION_ROBOT){
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
    if(Constants.COMPETITION_ROBOT){
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
      if(Constants.COMPETITION_ROBOT){
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

  public void runAll(double leftWallSpeed, double rightWallSpeed, double floorSpeed) {
    
    setRightWall(-rightWallSpeed); //Taking in
    setLeftWall(leftWallSpeed); //Going out
    setFloor(-floorSpeed); //Taking in

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

package frc.robot.Auto.PIDClasses;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;

import java.util.ResourceBundle.Control;

import com.revrobotics.*;
public class NEOPIDController extends CANPIDController {
    NEO neo; 
    
    int currentPIDSlot = 0; 
    
    NEOPID[] pidList = new NEOPID[4];
    
    public NEOPIDController(CANSparkMax device) {
        super(device);
        neo = (NEO)device;    
    }

    public void addPID(double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel, double maxAccel, double minOutput, double maxOutput, AccelStrategy accelStrategy, ControlType controlType, ArbFFUnits ffUnits, int smartMotionSlot){
        pidList[smartMotionSlot] = new NEOPID(this,p,  d,  i, ff,  arbFF , maxVel, minVel,  maxAccel, minOutput, maxOutput, accelStrategy, controlType, ffUnits,smartMotionSlot);
    }
    
    public void changeCurrentPID(int slotToMoveTo){
        currentPIDSlot = slotToMoveTo;
    }
    
    public NEOPID currentPID(){
        return pidList[currentPIDSlot];
    }
    
    public void setSmartVelocity(double velocity){
        currentPID().setSmartVelocity(this,velocity);
    }
    public void setArbFF(double arbFF){
        //currentPID().setArbFF(arbFF);
    }
    public void setVelocity(double velocity){
        currentPID().setVelocity(this, velocity);
    }
    
    public void setPosition(double position){
        currentPID().setPosition(this, position);
    }
    
    public void setPercent(double percent){
        currentPID().setPercent(this, percent);
    }
    
    public void setVoltage(double voltage) {
        currentPID().setVoltage(this, voltage);
    }
    public ControlType getType(){
        return currentPID().m_controlType;
    }
    public void setRef(double setpoint){
        switch(getType()){
            case kSmartVelocity:
                setSmartVelocity(setpoint);
                break;
            case kVelocity:
                setVelocity(setpoint);
                break;
            case kPosition:
                setPosition(setpoint);
                break;
            case kDutyCycle:
                setPercent(setpoint);
                break;
            case kVoltage:
                setVoltage(setpoint);
                break;

        }
    }

}

package frc.robot.Auto.PIDClasses;

import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import com.revrobotics.CANPIDController.AccelStrategy;
import com.revrobotics.CANPIDController.ArbFFUnits;

public class NEOPID {
    NEO currentMotor;
    
    
    private final ArbFFUnits defaultFFUnits = ArbFFUnits.kVoltage;
    private final ControlType defaultControlType = ControlType.kSmartVelocity;
    private final AccelStrategy defaulAccelStrategy = AccelStrategy.kSCurve;

    private double currentP, currentD, currentI, currentFF, currentMaxAcc, currentMaxVel, currentMinVel, currentMinOutput, currentMaxOutput, currentArbFF; 
    int pidSlot;
    
    private ArbFFUnits m_FFUnits;
    private ControlType m_controlType;
    private AccelStrategy m_accelStrategy;
    
    ArbFFUnits type;
    
    public NEOPID(CANPIDController controller, double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel, double maxAccel, double minOutput, double maxOutput, AccelStrategy accelStrategy, ControlType controlType, ArbFFUnits ffUnits, int smartMotionSlot){
        setValues(controller, p, d, i, ff, arbFF, maxVel, minVel, maxAccel, minOutput, maxOutput, accelStrategy, controlType, ffUnits, smartMotionSlot);
    }
    
    public void setValues(CANPIDController controller, double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel, double maxAccel, double minOutput, double maxOutput, AccelStrategy accelStrategy, ControlType controlType, ArbFFUnits ffUnits, int smartMotionSlot ){
        
        controller.setP(p,smartMotionSlot);
        controller.setD(d,smartMotionSlot);
        controller.setI(i,smartMotionSlot);
        controller.setSmartMotionAccelStrategy(accelStrategy, smartMotionSlot);
        controller.setSmartMotionMaxAccel(maxAccel, smartMotionSlot);
        controller.setSmartMotionMaxVelocity(maxVel, smartMotionSlot);
        controller.setSmartMotionMinOutputVelocity(minVel, smartMotionSlot);
        controller.setFF(ff, smartMotionSlot);
        controller.setOutputRange(minOutput, maxOutput, smartMotionSlot);
        
        currentP = p;
        currentD = d;
        currentI = i;
        currentFF = ff;
        currentArbFF= arbFF;
        currentMaxVel=maxVel;
        currentMaxAcc=maxAccel;
        currentMinVel=minVel;
        currentMinOutput = minOutput;
        currentMaxOutput=maxOutput;

        currentArbFF = arbFF;
        m_FFUnits=ffUnits;
        m_accelStrategy=accelStrategy;
        m_controlType=controlType;
    } 
    public void setArbFF(double arbFF){
        currentArbFF = arbFF;
    }
    public void setDefaultVelocity(CANPIDController controller, double velocity){
        
        controller.setReference(velocity, m_controlType, pidSlot,currentArbFF, m_FFUnits);
    }
    public void setDefaultSmartVelocity(CANPIDController controller, double velocity){
        
        controller.setReference(velocity, m_controlType, pidSlot,currentArbFF, m_FFUnits);
    }
    public void setDefaultPosition(CANPIDController controller, double position){
        
        controller.setReference(position, m_controlType, pidSlot,currentArbFF, m_FFUnits);

    }
    public void setDefaultVoltage(CANPIDController controller, double voltage){
        controller.setReference(voltage, m_controlType, pidSlot,currentArbFF, m_FFUnits);
    }
    public void setDefaultPercent(CANPIDController controller,double percent){
        controller.setReference(percent, m_controlType, pidSlot,currentArbFF, m_FFUnits);
    }
    public void setSmartVelocity(CANPIDController controller, double velocity){
        
        controller.setReference(velocity, m_controlType, pidSlot,currentArbFF, m_FFUnits);
    }
    public void setVelocity(CANPIDController controller, double velocity){
        
        controller.setReference(velocity, m_controlType, pidSlot,currentArbFF, m_FFUnits);
    }
    public void setPosition(CANPIDController controller,double position){
        
        controller.setReference(position, m_controlType, pidSlot,currentArbFF, m_FFUnits);
    }
    public void setVoltage(CANPIDController controller, double voltage){
        
        controller.setReference(voltage, m_controlType, pidSlot,currentArbFF, m_FFUnits);
    }
    public void setPercent(CANPIDController controller, double percent){
        
        controller.setReference(percent, m_controlType, pidSlot,currentArbFF, m_FFUnits);
    }

}
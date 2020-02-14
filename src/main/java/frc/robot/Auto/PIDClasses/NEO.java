package frc.robot.Auto.PIDClasses;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;

import com.revrobotics.ControlType;
import com.revrobotics.CANPIDController.AccelStrategy;
import com.revrobotics.CANPIDController.ArbFFUnits;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class NEO extends CANSparkMax{
    NEOPIDController m_pidController; 
    public final double defaultPIDSlot =0;//for ease a neo will create a PID on zero slot 
    public final double defaultP = 0;
    public final double defaultD = 0; 
    public final double defaultI =0; 
    public final double defaultFF = 0;
    public final double defaultMaxAcc = 3000; 
    public final double defaultMaxVel = 5700; 
    public final double defaultMinVel = 10; 
    public final double defaultMinAcc =0;
    public final double defaultArbFF = 0;
    public final double defaultMinOutput=-1;
    public final double defaultMaxOutput=1;
    public final AccelStrategy defaultAccelStrategy = AccelStrategy.kSCurve;
    public final ArbFFUnits defaultFFUnits = ArbFFUnits.kVoltage;
    public final ControlType defaultControlType = ControlType.kSmartVelocity;
    CANEncoder motorEncoder;
    public NEO(int deviceID) {
        
        super(deviceID, MotorType.kBrushless);
        restoreFactoryDefaults();
        setIdleMode(IdleMode.kCoast);
        m_pidController = new NEOPIDController(this);//get us la pid controler 
        motorEncoder = getEncoder();
        changeControlFramePeriod(1);
        // TODO Auto-generated constructor stub
    }
    public NEO(int deviceID, NEO master){
        super(deviceID, MotorType.kBrushless);
        restoreFactoryDefaults();
        setIdleMode(IdleMode.kCoast);
        m_pidController= new NEOPIDController(this);
        motorEncoder = getEncoder();
        changeControlFramePeriod(100);
    }
    /**
     * Changes the motors to break mode, this means if one tries to move them when they are not recieving a 
     * command they wont move 
     */
    public void setBrake(){
        setIdleMode(IdleMode.kBrake);
    }
    /**
     * Changes the motors to coast mode, this means that the motors move freely when giving them a command 
     */
    public void setCoast(){
        setIdleMode(IdleMode.kCoast);
    }
    /**
     * 
     * @return Returns the velocity that the encoder runs
     */
    public double velocity(){
        return motorEncoder.getVelocity();
    }
    /**
     * Adds a pid Controller,
     * @param p the position 
     * @param smartMotionSlot the 
     */
    public void addPIDController( double p,int smartMotionSlot){
        addPIDController(p, defaultD, defaultI, defaultFF, defaultArbFF, defaultMaxVel, defaultMinVel, defaultMaxAcc, defaultMinOutput, defaultMaxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
    }
    /**
     * 
     * @param p
     * @param d
     * @param smartMotionSlot
     */
    public void addPIDController( double p, double d, int smartMotionSlot){
        addPIDController(p, d, defaultI, defaultFF, defaultArbFF, defaultMaxVel, defaultMinVel, defaultMaxAcc, defaultMinOutput, defaultMaxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }
    public void addPIDController( double p, double d, double i, int smartMotionSlot){
        addPIDController(p, d, i, defaultFF, defaultArbFF, defaultMaxVel, defaultMinVel, defaultMaxAcc, defaultMinOutput, defaultMaxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }
    /**
     * 
     * @param p proportional gain, native units
     * @param d derivative gain, native units(multiplies encoder ticks-> velocity by this)
     * @param i integral gain, native units
     * @param ff feed forward, multiplies setpoint by this number and adds to output
     * @param smartMotionSlot the slot on the controller(between 0 and 3(there are four))
     */
    public void addPIDController( double p, double d, double i, double ff, int smartMotionSlot){
        addPIDController(p, d, i, ff, defaultArbFF, defaultMaxVel, defaultMinVel, defaultMaxAcc, defaultMinOutput, defaultMaxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }
    /**
     * 
     * @param p proportional gain native units(multiplies encoder ticsks -> velocity by this)
     * @param d derivative gain, native units
     * @param i integeral gain, native units
     * @param ff feed forward mulitplies setpoint by this nubmer and adds to the output
     * @param arbFF an arbitrary number added outside of pidf, we would use this to account for stuff such as gravity or acceleration
     * and we often use this for drive pids
     * @param smartMotionSlot slot on the controller( between 0 and 3, there are four)
     */
    public void addPIDController( double p, double d, double i, double ff, double arbFF ,int smartMotionSlot){
        addPIDController(p, d, i, ff, arbFF, defaultMaxVel, defaultMinVel, defaultMaxAcc, defaultMinOutput, defaultMaxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }
    /**
     * 
     * @param p
     * @param d
     * @param i
     * @param ff
     * @param arbFF
     * @param maxVel
     * @param smartMotionSlot
     */
    public void addPIDController( double p, double d, double i, double ff, double arbFF ,double maxVel,  int smartMotionSlot){
        addPIDController(p, d,i , ff, arbFF, maxVel, defaultMinVel, defaultMaxAcc, defaultMinOutput, defaultMaxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }
    public void addPIDController( double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel,  int smartMotionSlot){
        addPIDController(p, d, i, ff, arbFF, maxVel, minVel, defaultMaxAcc, defaultMinOutput, defaultMaxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }
    public void addPIDController( double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel, double maxAccel,  int smartMotionSlot){
        addPIDController(p, d, i, ff, arbFF, maxVel, minVel, maxAccel, defaultMinOutput, defaultMaxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }
    public void addPIDController( double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel, double maxAccel, double minOutput,  int smartMotionSlot){
        addPIDController(p, d, i, ff, arbFF, maxVel, minVel, maxAccel, minOutput, defaultMaxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }
    public void addPIDController( double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel, double maxAccel, double minOutput, double maxOutput, int smartMotionSlot){
        addPIDController(p, d, i, ff, arbFF, maxVel, minVel, maxAccel, minOutput, maxOutput,defaultAccelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }
    public void addPIDController( double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel, double maxAccel, double minOutput, double maxOutput, AccelStrategy accelStrategy,int smartMotionSlot){
        addPIDController(p, d, i, ff, arbFF, maxVel, minVel, maxAccel, minOutput, maxOutput,accelStrategy , defaultControlType, defaultFFUnits, smartMotionSlot);
   
    }

    public void addPIDController( double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel, double maxAccel, double minOutput, double maxOutput, AccelStrategy accelStrategy, ControlType controlType, int smartMotionSlot){
        addPIDController(p, d, i, ff, arbFF, maxVel, minVel, maxAccel, minOutput, maxOutput,accelStrategy ,controlType, defaultFFUnits, smartMotionSlot);
   
    }
    public void addPIDController( double p, double d, double i, double ff, double arbFF ,double maxVel, double minVel, double maxAccel, double minOutput, double maxOutput, AccelStrategy accelStrategy, ControlType controlType, ArbFFUnits ffUnits, int smartMotionSlot){
        m_pidController.addPID(p, d, i, ff, arbFF, maxVel, minVel, maxAccel, minOutput, maxOutput,accelStrategy , controlType, ffUnits, smartMotionSlot);
    }
    public void changePIDController(int slot){
        m_pidController.changeCurrentPID(slot);
    }
    public double getVelocity(){
       return motorEncoder.getVelocity();
    }
    public void setP(double p){
        m_pidController.setP(p,m_pidController.currentPIDSlot);
    }
    public void setI(double i){
        m_pidController.setI(i,m_pidController.currentPIDSlot);
    }
    public void setD(double d){
        m_pidController.setD(d,m_pidController.currentPIDSlot);
    }
    public void setFF(double ff){
        m_pidController.setFF(ff,m_pidController.currentPIDSlot);
    }
    public void setAccelStrategy(AccelStrategy accelStrat){
        m_pidController.setSmartMotionAccelStrategy(accelStrat, m_pidController.currentPIDSlot);
    }
    /**
     * 
     * @param rpm the speed, in rpm, to set the pid to
     */
    public void setVelocity(double rpm){
        m_pidController.setVelocity(rpm);
    }
    /**
     * 
     * @param position the position, in encoder ticks, that the motor should move to
     */
    public void setPosition(double position){
        m_pidController.setPosition(position);
    }

   /**
    * @param  voltage The voltage we want to send to the motors 
    
    */
    public void setVoltage(double voltage){
        m_pidController.setVoltage(voltage);
    }
    /**
     * 
     * @param arbFF changes the arbitrary feed forward value, this is what we add arbitrarily to our pid output, so say we are at error
     * of 0 then we will still add whatever the arbFF is, having an FF removes some of this need as we multiply setpoint by this
     * but this is just another, better, way to do this 
     */
    public void setArbFF(double arbFF){
        m_pidController.setArbFF(arbFF);
    }
    /**
     * 
     * @param percent the percentage 
     */
    public void setPercent(double percent){
        m_pidController.setPercent(percent);
    }
    public void setRef(double setpoint){
        switch(m_pidController.getType()){
            
        }
    }
    /**
     * 
     * @param velocity the velocity to set the pid to 
     */
    public void setSmartVelocity(double velocity){
        m_pidController.setSmartVelocity(velocity);
    }
    /**
     * Changes the period at which the motors run, we usually want to run at 1ms but if you want to slow down followers go ahead
     * @param ms
     */
    public void changeControlFramePeriod(int ms){
        setControlFramePeriodMs(ms);
    }


}
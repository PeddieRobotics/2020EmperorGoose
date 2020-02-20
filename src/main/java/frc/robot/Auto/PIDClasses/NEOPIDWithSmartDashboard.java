package frc.robot.Auto.PIDClasses;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.SmartDashboardSubsystem;

public class NEOPIDWithSmartDashboard extends SmartDashboardSubsystem{
    NEO neo;
    String slotID;
    int i = 0;
    public NEOPIDWithSmartDashboard(int slot){
        super("PID " + slot);
        neo = new NEO(slot);
        neo.addPIDController(neo.defaultP,3);
        
        neo.currentPIDController().changeCurrentPID(3);

        slotID = "" + slot;
        addVariable(new Double(neo.defaultP), "p "+ slot);
        
        addVariable(new Double(neo.defaultI), "d "+ slot);
        
        addVariable(new Double(neo.defaultD), "i "+ slot);
        
        addVariable(new Double(neo.defaultFF), "ff "+ slot);
        
        addVariable(new Double(neo.defaultArbFF), "arbFF "+ slot);

        addVariable(new Double(0),"setpoint "+slot);
    }
    public NEOPIDWithSmartDashboard(NEO neo){
        super("PID "+neo.getDeviceID());
        neo.addPIDController(neo.defaultP,3);
        neo.currentPIDController().changeCurrentPID(3);
        slotID = "" + neo.getDeviceID();
        int slot = neo.getDeviceID();
        addVariable(new Double(neo.defaultP), "p "+ slot);
        
        addVariable(new Double(neo.defaultI), "d "+ slot);
        
        addVariable(new Double(neo.defaultD), "i "+ slot);
        
        addVariable(new Double(neo.defaultFF), "ff "+ slot);
        
        addVariable(new Double(neo.defaultArbFF), "arbFF "+ slot);

        addVariable(new Double(0),"setpoint "+slot);
    }
    double currentP = 0; 
    double currentI = 0; 
    double currentD = 0; 
    double currentFF = 0;
    double currentArbFF = 0;
    double currentSetpoint = 0;
    @Override
    public void periodic(){
        manageVariables();
        double pidP = getDouble("p"+slotID);
        double pidD = getDouble("d"+slotID);
        double pidI = getDouble("i"+slotID);
        double pidFF = getDouble("ff"+slotID);
        double pidArbFF = getDouble("arbFF"+slotID);
        double pidSetpoint = getDouble("setpoint"+slotID);
        
        //update our setpoints, dont update unless changed or we will casue issues because updating burn flashed params at 50hz is not possible
        if(currentP != pidP){DriverStation.reportError("hey", false); neo.setP(pidP); currentP = pidP;}
        if(currentD!= pidD){ DriverStation.reportError("hey", false);neo.setD(pidD); currentD = pidD;}
        if(currentI != pidI){DriverStation.reportError("hey", false); neo.setI(pidI); currentI = pidI;}
        if(currentFF !=pidFF){ DriverStation.reportError("hey", false);neo.setFF(pidFF); currentFF = pidFF;}
        if(currentArbFF != pidArbFF){DriverStation.reportError("hey", false); neo.setArbFF(pidArbFF); currentArbFF = pidArbFF;}
        if(currentSetpoint !=pidSetpoint){ DriverStation.reportError("hey", false);neo.setSmartVelocity(pidSetpoint);currentSetpoint=pidSetpoint;}
        
        if(!(neo==null)){
        SmartDashboard.putNumber("currentVelocity " + slotID, neo.getVelocity());
        }
    }

}
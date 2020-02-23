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
        neo.addPIDController(neo.defaultP,0);
        slotID = "" + slot;
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
        if(currentP != getDouble("p "+slotID)){DriverStation.reportError("hey", false); neo.setP(getDouble("p " + slotID)); currentP = getDouble("p "+slotID);}
        if(currentD!= getDouble("d "+slotID)){ DriverStation.reportError("hey", false);neo.setD(getDouble("d " + slotID)); currentD = getDouble("d "+slotID);}
        if(currentI != getDouble("i "+slotID)){DriverStation.reportError("hey", false); neo.setI(getDouble("i " + slotID)); currentI = getDouble("i "+slotID);}
        if(currentFF != getDouble("ff "+slotID)){ DriverStation.reportError("hey", false);neo.setFF(getDouble("ff " + slotID)); currentFF = getDouble("ff "+slotID);}
        if(currentArbFF != getDouble("arbFF "+slotID)){DriverStation.reportError("hey", false); neo.setArbFF(getDouble("arbFF " + slotID)); currentArbFF = getDouble("arbFF "+slotID);}
        if(currentSetpoint != getDouble("setpoint "+slotID)){ DriverStation.reportError("hey", false);neo.setSmartVelocity(getDouble("setpoint " + slotID)); currentSetpoint = getDouble("setpoint "+slotID);}
        SmartDashboard.putNumber("currentVelocity " + slotID, neo.getVelocity());
        
    }

}
package frc.robot.Auto.PIDClasses;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Talon;
import frc.robot.SmartDashboardSubsystem;

public class VictorSPXWithSmartDashboard extends SmartDashboardSubsystem{
    VictorSPX motor;
    String slotID;
    public VictorSPXWithSmartDashboard(int slot){
        super("PID " + slot);
        motor = new VictorSPX(slot);
        slotID = "" + slot;
        addVariable(new Double(0), "percentSetpoint "+ slot);
        
    }
    double percentSetpoint = 0; 
    @Override
    public void periodic(){
        manageVariables();
        if(percentSetpoint != getDouble("percentSetpoint "+slotID)){DriverStation.reportError("hey", false); motor.set(ControlMode.PercentOutput,getDouble("percentSetpoint " + slotID)); percentSetpoint = getDouble("percentSetpoint "+slotID);}
      
    }

}
package frc.robot.Auto.PIDClasses;

import frc.robot.SmartDashboardSubsystem;

public class NEOPIDWithSmartDashboard extends SmartDashboardSubsystem{

    public NEOPIDWithSmartDashboard(){
        super("PID 0");
    }
    public NEOPIDWithSmartDashboard(int slot){
        super("PID " + slot);
    }

}
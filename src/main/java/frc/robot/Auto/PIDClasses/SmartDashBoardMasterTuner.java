package frc.robot.Auto.PIDClasses;

import frc.robot.SmartDashboardSubsystem;

public class SmartDashBoardMasterTuner extends SmartDashboardSubsystem{
    public SmartDashBoardMasterTuner(){
        super("Master Tuner Program");
      
    }
    public void addMotor(){}
   
    @Override
    public void periodic(){
        manageVariables();
        
    }
}
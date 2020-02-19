package frc.robot.Auto.PIDClasses;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NEOController {
    static NEOController mainController;
    
    ArrayList<NEO> neoList = new ArrayList<NEO>();
    ArrayList<NEOPIDWithSmartDashboard> neoSDPidList = new ArrayList<NEOPIDWithSmartDashboard>();
    ArrayList<Integer> neoID = new ArrayList<Integer>();
    public NEOController(){

    }
    public static NEOController getInstance(){
        if(mainController==null){
            mainController=new NEOController();
        }
        return mainController;
    }
    public void addNEO(NEO neo){
        neoList.add(neo);
        neoSDPidList.add(new NEOPIDWithSmartDashboard(neo));
        
    }
    public void periodic(){
    }
}
package frc.robot.Auto.PIDClasses;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NEOController {
    static NEOController mainController;
    ArrayList<NEO> neoList;
    ArrayList<NEOPIDWithSmartDashboard> neoSDPidList; 
    ArrayList<Integer> neoID;
    
    public NEOController(){
        neoList= new ArrayList<NEO>();
        neoSDPidList = new ArrayList<NEOPIDWithSmartDashboard>();
        neoID = new ArrayList<Integer>();
        
    }
    
    public static NEOController getInstance(){
        if(mainController==null){
            mainController=new NEOController();
        }
        return mainController;
    }

    public void addNEO(NEO neo){
        neoList.add(neo);
        
    }
    
    public void periodic(){
    }
}
package frc.robot.Framework.Logging;

import java.io.IOException;
import java.util.ArrayList;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj2.command.CommandBase;
 
public class CSVLogger{
    public ArrayList<String> headersForLoggedVariables = new ArrayList<String>();
    public ArrayList<String> variableValueList = new ArrayList<String>();
    public ArrayList<String[]> loggedVariableList = new ArrayList<String[]>();
    public ArrayList<Supplier<Double>> variablesBeingRecorded = new ArrayList<Supplier<Double>>();
    static CSVLogger instance;
    boolean sendDataOverDS = false; 
    boolean currentClearState = false;
   //will send data if true, this way the thread that stops is on this notifier not the main ones
    CSVServer ourServer;
    Notifier runner;

    public CSVLogger(){
        runner = new Notifier(this::run);
        runner.startPeriodic(.02);//run at 50hz, we want our own notifier because if the server crashed we dont wanna crash our whole robot
                
        ourServer = new CSVServer();
    }

    public static CSVLogger getInstance(){
        if(instance==null){
            instance = new CSVLogger();
        }
        return instance;
    }
    public void addHeader(String[] header){
        for(int i =0; i < header.length; i++){
            headersForLoggedVariables.add(header[i]);
        }
    }

    public void addStringToHeader(String s){
        headersForLoggedVariables.add(s);
    }
    
    public void addVariableToSendToDs(String value, String name){
        try{
            Double.parseDouble(value);
            variableValueList.add(name+value);
        }catch(Exception e){
            //if the value is not a parsable value(e.g. it is not a double, then dont add as a variable)
        }
    }
    public void addVariablesToRecored(Supplier<Double> variable){
        variablesBeingRecorded.add(variable);

    }
    public void updateVariablesThatWeAreRecording(){
        String[] currVarList = new String[variablesBeingRecorded.size()];
        if(!RobotState.isDisabled()){
            for(int i =0; i < variablesBeingRecorded.size();i++){
                Supplier<Double> variableObject= variablesBeingRecorded.get(i);
            
                String variableValue = variableObject.get().toString();//thanks antonio
                if(variableValue.equals("NaN")){
                    currVarList[i]= ""+0;
                }else{
                     currVarList[i] = variableValue;
                }
            }
            loggedVariableList.add(currVarList);
        }
    }
    /**
     * Use this method if you wanna send data to the driverstation
     */
    public void sendDataOverDS(){
        sendDataOverDS=true;
    }
    
    /**
     * Don't use this method the internal class requires this method
     */
    public void sendDataOverServer(){
        
        String[] headerList = new String[headersForLoggedVariables.size()];
        String[] variableList = new String[variableValueList.size()+1];
        
        for(int i =0; i < headerList.length;i++){
            headerList[i] = headersForLoggedVariables.get(i);
        }
        variableList[0]="variables";
        for(int i =1;i < variableList.length;i++){
               variableList[i]=variableValueList.get(i-1);
        }
        loggedVariableList.set(0,headerList);
        loggedVariableList.add(variableList);
        try {
            ourServer.sendDataAccrossNetwork(loggedVariableList);
            DriverStation.reportError("server sending data", false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void clearArrayList(ArrayList listToClear){
        for(int i =0; i < listToClear.size();i++){
            listToClear.remove(0);
        }
    }
    public void sendDataToDS(boolean clearAllData){
        sendDataOverServer();
        if(clearAllData){
            clearArrayList(loggedVariableList);
            clearArrayList(variableValueList);
            clearArrayList(headersForLoggedVariables);       
        }else{
            //do stuff
        }
    }
    
    public void run(){
        if(sendDataOverDS){
            sendDataToDS(currentClearState);
            sendDataOverDS = false;
        }
        updateVariablesThatWeAreRecording();
        
    }
    

}

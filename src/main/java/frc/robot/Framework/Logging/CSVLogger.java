package frc.robot.Framework.Logging;

import java.util.ArrayList;
import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class CSVLogger extends CommandBase {
    public ArrayList<String> headersForLoggedVariables = new ArrayList<String>();
    public ArrayList<String> variableValueList = new ArrayList<String>();
    public ArrayList<String[]> loggedVariableList = new ArrayList<String[]>();
    static CSVLogger instance;

    public CSVLogger(){

    }

    @Override
    public void initialize(){
        getInstance();//initialize if doesn't exist 
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
    public static void addVariableToSendToDs(String value, String name){
        
    }
    public static void addVariablesToRecored(){

    }
    public void updateVariablesThatWeAreRecording(){

    }
    @Override 
    public void execute(){
        updateVariablesThatWeAreRecording();

    }
    @Override 
    public void end(boolean isInterupted){
        
    }
    @Override 
    public boolean isFinished(){
        return false;//dont end plz 
    }
}

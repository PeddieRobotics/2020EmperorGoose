package frc.robot.Framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;


public class CommandLooper{
    static CommandLooper mainLooper; 
    Notifier runner;//this will run all the commands
    Vector<Command> listOfCommands;//vector is just thread safe arrayLis
    HashMap<Integer,ArrayList<Command>> listOfSmartCommands;//for convience all keys will be in num
    ArrayList<Integer> runTimesForSmartCommands;
    boolean hasBeenScheduled;
    int m_Hz;
    public CommandLooper(){
        m_Hz = 0;
       hasBeenScheduled=false;
        runner = new Notifier(this::run);//run our run method
        listOfCommands = new Vector<Command>();//initialize stuff
        runTimesForSmartCommands = new ArrayList<Integer>();
        listOfSmartCommands = new HashMap<Integer, ArrayList<Command>>();

    }
    /**
     * Everything should be run through this!(to make life easier)
     * @return the static commandLooper
     */
    public static synchronized CommandLooper getInstance(){
        if(mainLooper==null){
            DriverStation.reportError("successfully initialized", false);
            mainLooper = new CommandLooper();
        }else{
            DriverStation.reportError("sucessfuly used",false);
        }
        
        return mainLooper;
    }
    public void addCommand(Command c){
        listOfCommands.add(c);
        c.initialize();
    }
    public void setPeriodic(int periodMs){
        if(!hasBeenScheduled){
            startAndSetPeriodic(periodMs);
        }else{
            runner.stop();//cancel the current process if not running and then restart at different hertz
            startAndSetPeriodic(periodMs);
        }
        

    }
    public void addSmartScheduledCommand(Command c, int periodMs){
        int hertz = 1000/periodMs;
        if(hertz<m_Hz&&m_Hz%hertz==0){
            if(listOfSmartCommands.containsKey(hertz)){
                c.initialize();
                listOfSmartCommands.get(hertz).add(c);
            }
            else{
                c.initialize();
                listOfSmartCommands.put(new Integer(hertz),new ArrayList<Command>());
                listOfSmartCommands.get(hertz).add(c);
                runTimesForSmartCommands.add(m_Hz/hertz);
            }
        }
        Shuffleboard.disableActuatorWidgets();
    }
    /**
     * 
     * @param periodMs the period of the notifier in milliseconds, so it will run once every this amount
     */
    public void startAndSetPeriodic(int periodMs){
        hasBeenScheduled = true;
        m_Hz= 1000/periodMs;
        runner.startPeriodic((double)periodMs/(double)1000);//convert from ms-> seconds
        //use doubles to make sure we get accurate decimal 
    }//freq(100) 20

    //
    /**
     * Run all the methods in our array. Check is finished, and if not true run execute method
     * If it is finished end command and remove from list
     */
    
    public void run(){
        Iterator<Map.Entry<Integer,ArrayList<Command>>> iterator =listOfSmartCommands.entrySet().iterator();
        int index = 0;
        while(iterator.hasNext()){
            Map.Entry<Integer,ArrayList<Command>> currentCommandList = (Map.Entry<Integer,ArrayList<Command>>)(iterator.next());
            runTimesForSmartCommands.set(index, (Integer)(runTimesForSmartCommands.get(index)-1));
            int startLoc = runTimesForSmartCommands.get(index);
            
            for(int i =startLoc; i < currentCommandList.getValue().size();i+=(m_Hz/(int)currentCommandList.getKey())){
                if(i<currentCommandList.getValue().size()){
                    if(!currentCommandList.getValue().get(i).isFinished()){
                        currentCommandList.getValue().get(i).execute();
                    }
                    else{
                        currentCommandList.getValue().get(i).end(false);//we don't handle interupted case(TO-DO: Handle this case :) )
                        currentCommandList.getValue().remove(i);
                    }
                }
            }
            if(runTimesForSmartCommands.get(index).equals(0)){
                runTimesForSmartCommands.set(index,(Integer)(m_Hz/(Integer)currentCommandList.getKey()));
            }
            
            index++;
        }
        for(int i =0; i < listOfCommands.size();i++){
            
            if(!listOfCommands.get(i).isFinished()){

                listOfCommands.get(i).execute();
            }
            else{
                listOfCommands.get(i).end(false);//we don't handle interupted case(TO-DO: Handle this case :) )
                listOfCommands.remove(i);
            }
        }
    }
	
}

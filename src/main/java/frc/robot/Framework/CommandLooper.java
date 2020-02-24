package frc.robot.Framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;


public class CommandLooper{
    static CommandLooper mainLooper; 
    Notifier runner;//this will run all the commands
    Vector<Command> listOfCommands;//vector is just thread safe arrayList, so far seems to be no need for it :/ 
    HashMap<Integer,ArrayList<Command>> listOfSmartCommands;//for convience all keys will be in num
    ArrayList<Set<Subsystem>> commandRequirementList; //we need to implement this, but should be for interupted thigns
    ArrayList<Integer> startLocationForSmartCommandList;// we need to keep track of our location in smart command array
    ArrayList<String> slowRemoveList, fastRemoveList; // two remove ques, one instantly removed, other garunteed @ 10hz rate
    ArrayList<String> basicCommandRemoveList; 
    boolean hasBeenScheduled;
    int m_Hz;
    int slowRemoveListHz = 10;
    int slowRemoveLoc = 0;
    public CommandLooper(){
        m_Hz = 0;
       hasBeenScheduled=false;
        runner = new Notifier(this::run);//run our run method
        listOfCommands = new Vector<Command>();//initialize stuff
        startLocationForSmartCommandList = new ArrayList<Integer>();
        listOfSmartCommands = new HashMap<Integer, ArrayList<Command>>();
        slowRemoveList = new ArrayList<String>();
        fastRemoveList = new ArrayList<String>();
        basicCommandRemoveList = new ArrayList<String>();
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
    /**
     * Clears all of our lists 
     */
    public void clearCommandLists(){
        listOfSmartCommands.clear();
        listOfCommands.clear();
        startLocationForSmartCommandList.clear();
        slowRemoveList.clear();
        fastRemoveList.clear();
    }
    /**
     * 
     * @param c Adds a command to the basic looper list
     */
    public void addCommand(Command c){
        listOfCommands.add(c);
        c.initialize();
    }
    /**
     * 
     * @param periodMs Changes the rate of the looper. If it hasn't been scheduled just start and set perioidc 
     * Other wise stop the looper and then set the perioidc 
     */
    public void setPeriodic(int periodMs){
        if(!hasBeenScheduled){
            startAndSetPeriodic(periodMs);
        }else{
            runner.stop();//cancel the current process if not running and then restart at different hertz
            startAndSetPeriodic(periodMs);
        }
        

    }
    /**
     * Slow command list, this is removed from at a rate of 10hz instead of looper hz. If there are multiple commands that need to be
     * removed but not urgently they can be stopped this way
     * @param nameOfCommand the class name of a command(just do Command.class.getSimpleName()) .class static for all objs.
     */
    public synchronized void addToSlowRemoveQue(String nameOfCommand){
        slowRemoveList.add(nameOfCommand);
        
    }
    /**
     * Fast command list, if you want immediate removal add to this(don't really see a need for immedaite removal but can add it if need)
     * @param nameOfCommand the class name of a command(just do Command.class.getSimpleName()) once again .class static for all ojbs
     */
    public synchronized void addToFastRemoveQue(String nameOfCommand){
        fastRemoveList.add(nameOfCommand);
    }
    /**
     * Fast command list, if you want immediate removal add to this(don't really see a need for immedaite removal but can add it if need)
     * @param nameOfCommand the class name of a command(just do Command.class.getSimpleName()) once again .class static for all ojbs
     */
    public synchronized void addToRemoveBasicList(String nameOfCommand){

    }
    /**
     *  this takes a command(c) and adds it to the smartCommands hash map. If there is a list for commands that want to be 
     * run at it's freq; then add it to that list. Other wise create a new key and add it to that 
     * @param c the Command we want to add to the looper
     * @param periodMs period that the command should be run at
     */
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
                startLocationForSmartCommandList.add(m_Hz/hertz);
            }
        }
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
     * Main method( the notifier runs at your desired period, rn we are using 200hz or 5ms)
     * First we create an iterator to move through teh array
     * Decrement the value of the startLocationForStartCommand(i) for each group of smart commands. For each smart command list we 
     * automatically move through it in clumps of m_Hz/commandListHz(looperRate/commmandList rate). By moving through the list this way 
     * we effectively  create  clumps of commands(each supposed to be run at same freq. ) and we use startLocation to move through these
     *  groups. Later in the code you'll see that we move back up to (m_Hz/hz) if it equals 0
     * Then we iterate through, and run all commands unless three conditions are met 
     * it is in the fastRemoveList->immediate removal
     * isFinished removes true
     * third more complicated method-> remove from slow comand list
        * This is a similar implementatoin to the startLocation list. This list is removed from at rate of 10hz, and the task of
        removing split up across m_Hz/(slowHz(right now 10hz)) loops. 
     * we do removal in here this way we don't need extra iterations of the command list, as it is already running fast 
     * and slowing it down anymore would be counter productive, thus we add to the list instead 
     */

    
    public void run(){
        Iterator<Map.Entry<Integer,ArrayList<Command>>> iterator =listOfSmartCommands.entrySet().iterator();
        int index = 0;
        while(iterator.hasNext()){
            Map.Entry<Integer,ArrayList<Command>> currentCommandList = (Map.Entry<Integer,ArrayList<Command>>)(iterator.next());
            startLocationForSmartCommandList.set(index, (Integer)(startLocationForSmartCommandList.get(index)-1));
            int startLoc = startLocationForSmartCommandList.get(index);
            slowRemoveLoc--;
            for(int i =startLoc; i < currentCommandList.getValue().size();i+=(m_Hz/(int)currentCommandList.getKey())){
                if(i<currentCommandList.getValue().size()){
                    for(int j = 0; j < fastRemoveList.size();j++){
                        if(fastRemoveList.get(i).equals(currentCommandList.getValue().get(i).getName())){
                            currentCommandList.getValue().get(i).end(false);//we don't handle interupted case(TO-DO: Handle this case :) )
                            currentCommandList.getValue().remove(i);
                            fastRemoveList.remove(i);
                            break;
                        }
                    }
                    
                    //slowly iterate through remove que
                    for(int j = slowRemoveLoc;j< slowRemoveList.size();j+= (m_Hz/slowRemoveListHz)){
                        if(slowRemoveList.get(i).equals(currentCommandList.getValue().get(i).getName())){
                            currentCommandList.getValue().get(i).end(false);//we don't handle interupted case(TO-DO: Handle this case :) )
                            currentCommandList.getValue().remove(i);
                            slowRemoveList.remove(j);
                            break; 
                        }
                    }
                    if(!currentCommandList.getValue().get(i).isFinished()){
                        currentCommandList.getValue().get(i).execute();
                        
                    }
                    else{
                        currentCommandList.getValue().get(i).end(false);//we don't handle interupted case(TO-DO: Handle this case :) )
                        currentCommandList.getValue().remove(i);
                    }
                }
            }
            if(slowRemoveLoc==0){
                slowRemoveLoc=m_Hz/slowRemoveListHz;
            }
            if(startLocationForSmartCommandList.get(index).equals(0)){
                startLocationForSmartCommandList.set(index,(Integer)(m_Hz/(Integer)currentCommandList.getKey()));
            }
            
            index++;
        }
        for(int i =0; i < listOfCommands.size();i++){
            for(int j =0; j  < basicCommandRemoveList.size();j++){
                if(listOfCommands.get(i).getName().equals(basicCommandRemoveList.get(i))){
                    
                    listOfCommands.get(i).end(false);//we don't handle interupted case(TO-DO: Handle this case :) )
                    listOfCommands.remove(i);
                    basicCommandRemoveList.remove(i);
                }
            }
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

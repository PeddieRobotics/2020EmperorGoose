package frc.robot.Framework;

import java.util.Vector;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.PathFollower;

public class CommandLooper{
    static CommandLooper mainLooper; 
    Notifier runner;//this will run all the commands
    Vector<Command> listOfCommands;//vector is just thread safe arrayList
    
    public CommandLooper(){
        runner = new Notifier(this::run);//run our run method
        listOfCommands = new Vector<Command>();//initialize stuff
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
    ParallelCommandGroup c;
    /**
     * 
     * @param periodMs the period of the notifier in milliseconds, so it will run once every this amount
     */
    public void startAndSetPeriodic(int periodMs){
        runner.startPeriodic((double)periodMs/(double)1000);//convert from ms-> seconds
        //use doubles to make sure we get accurate decimal 
    }
    /**
     * Run all the methods in our array. Check is finished, and if not true run execute method
     * If it is finished end command and remove from list
     */
    public synchronized void run(){
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

package frc.robot;

import java.util.Vector;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj2.command.Command;

public class CommandLooper{
    static CommandLooper mainLooper; 
    Notifier runner;//this will run all the commands
    Vector<Command> listOfCommands;//vector is just thread safe arrayList
    public CommandLooper(){
        runner = new Notifier(this::run);//run our run method

    }
    /**
     * We want to use a static runner to make life easier
     * @return
     */
    public CommandLooper getInstance(){
        if(mainLooper==null){
            mainLooper = new CommandLooper();
        }
        return mainLooper;
    }
    public void addCommand(Command c){
        listOfCommands.add(c);
        c.initialize();
    }
    /**
     * 
     * @param periodMs the period of the notifier in milliseconds
     */
    public void startAndSetPeriodic(int periodMs){
        runner.startPeriodic(periodMs/1000);//convert from ms-> seconds
    }
    /**
     * Run all the methods
     * No need to be thread safe because we are using vectors(this is why not synchonized void like old looper)
     */
    public void run(){
        for(int i =0; i < listOfCommands.size();i++){
            
            if(!listOfCommands.get(i).isFinished()){

                listOfCommands.get(i).execute();
            }
            else{
                listOfCommands.get(i).end(false);//we don't handle interupted case
                listOfCommands.remove(i);//remove the command once it is over
            }
        }
    }
}

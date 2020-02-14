package frc.robot.Auto;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * An easy way to use the csv values spit out by bob
 * Each method returns the column that the given value is located at in a path csv
 */
public class GenPathSetup{
   
    public GenPathSetup(){

    }
    /**
     * 
     * @return the column in the csv for delta time
     */
    public static int dt(){
        return 0;
    }
    /**
     * 
     * @return x loc(in coordinates) column in csv
     */
    public static int x(){
        return 1;
    }
    /**
     * 
     * @return y loc(in coordinates) column in csv
     */
    public static int y(){
        return 2;
    
    }
    /**
     * 
     * @return encoder ticks, in position
     */
    public static int pos(){
        return 3;
    }
    /**
     * 
     * @return velocity, in ft/s
     */
    public static int vel(){
        return 4;
    }
    /**
     * 
     * @return accel in ft/s/s
     */
    public static int acc(){
        return 5;
    }
    /**
     * 
     * @return jerk in ft/s/s/s
     */
    public static int jerk(){
        return 6;
    }
    /**
     * 
     * @return heading in radians
     */
    public static int heading(){
        return 7;
    }

}
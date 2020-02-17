package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    //Motors - organized as drive, then hopper, then flywheel, and intake
    public static final int LEFT_MASTER = 1;
    public static final int LEFT_FOLLOWER = 2;
    public static final int RIGHT_MASTER = 3;
    public static final int RIGHT_FOLLOWER = 4;

    public static final int HOPPER_RIGHT_WALL = 6; //possibly will use if engineers do a hopper w/2 motors???
    public static final int HOPPER_FLOOR = 10;
    public static final int HOTDOG_LEFT = 5;
    public static final int HOTDOG_ROLLER = 10;

    public static final int FLYWHEEL_1 = 7;
    public static final int FLYWHEEL_2 = 8;
    public static final int INTAKE_MOTOR  = 9;

    public static final int TOWER_TOP = 12;
    public static final int TOWER_BOTTOM = 11;
    //Solenoids
    public static final int SOLENOID_INTAKE_1 = 1;
    public static final int SOLENOID_INTAKE_2 = 2;
    public static final int SOLENOID_HOOD = 3;
    public static final double p = 0.0004; 
    public static final double i = 0.0000;
    public static final double d = 0.0000; 
    public static final double ff = 0.000176 ;
    public static final double ffOffset = 0.000002;


    public static final double FLYWHEEL_P = 0;
    public static final double FLYWHEEL_I = 0;
    public static final double FLYWHEEL_D = 0;
    public static final double FLYWHEEL_FF = 0;
    public static final double accMultiplier = 0.23;
    public static final double accOffset = 0.00;

    //PID for Flywheel

    public static final double flywheelP = 0.0004; 
    public static final double flywheelI = 0.0000;
    public static final double flywheelD = 0.0000; 
    public static final double flywheelFF = 0.000176 ;
}

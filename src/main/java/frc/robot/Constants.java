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

    public static final int HOPPER_LEFT = 5;
    public static final int HOPPER_RIGHT = 6; //possibly will use if engineers do a hopper w/2 motors???

    public static final int FLYWHEEL_1 = 7;
    public static final int FLYWHEEL_2 = 8;

    public static final int INTAKE_MOTOR_1 = 9;
    public static final int INTAKE_MOTOR_2 = 10;

    //Solenoids
    public static final int SOLENOID_INTAKE_1 = 1;
    public static final int SOLENOID_INTAKE_2 = 2;

}

/**
 *  FRC 5895 (Peddie School Robotics)

 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

public final class Constants {

    //Motors - organized as drive, then hopper, then flywheel, and intake
    public static final int LEFT_MASTER = 1;
    public static final int LEFT_FOLLOWER = 2;
    public static final int RIGHT_MASTER = 3;
    public static final int RIGHT_FOLLOWER = 4;

    public static final int HOPPER_RIGHT_WALL = 6;
    public static final int HOPPER_FLOOR = 10;
    public static final int HOPPER_LEFT_WALL = 5;
    public static final int HOTDOG_ROLLER = 10;

    public static final int FLYWHEEL_1 = 7;
    public static final int FLYWHEEL_2 = 8;
    public static final int INTAKE_MOTOR  = 9;

    public static final int TOWER_TOP = 12;
    public static final int TOWER_BOTTOM = 11;
    //Solenoids
    public static final int SOLENOID_INTAKE = 7;
    public static final int SOLENOID_HOOD = 6;
    public static final int SOLENOID_CLIMBER_1 = 4;
    public static final int SOLENOID_CLIMBER_2 = 5;

    public static final double DRIVETRAIN_P = 0.0003; 
    public static final double DRIVETRAIN_I = 0.0000007;
    public static final double DRIVETRAIN_D = 0.000; 
    public static final double DRIVETRAIN_FF = 0.00018 ;
    public static final double DRIVETRAIN_FF_OFFSET = 0.000008;
    
    public static final double DRIVETRAIN_ACC = 0.0;
    public static final double DRIVETRAIN_ACC_OFFSET = 0.00;

    public static final boolean DRIVETRAIN_USE_SQUARED = true;

    public static final double FLYWHEEL_P = 0.00015;
    public static final double FLYWHEEL_I = 0.0000005;
    public static final double FLYWHEEL_D = 0;
    public static final double FLYWHEEL_FF = 0.00018;
    //PID for Flywheel

    public static final double RPM_LAYUP = 2100;
    public static final double RPM_FAR = 3500;
    public static final int THRESHOLD_LAYUP = 500;
    public static final int THRESHOLD_FAR = 100;

    public static final double REVERSE_PERCENT_INTAKE = 0.8;
    public static final double REVERSE_PERCENT_HOPPER = 0.8;
    public static final double REVERSE_PERCENT_TOWER = 0.8;

    public static final double TOWER_SHOT_SPEED = 0.8;

    public static final double INTAKE_MOTOR_OFF_DELAY = 1.0;

    public static final boolean USE_XBOX_CONTROLLER = true;
    public static final double XBOX_TRIGGER_DEADZONE = 0.02; // Jiggle room for the xbox triggers
    public static final double XBOX_TRIGGER_SENSITIVITY = 0.3;  // If the trigger is beyond this limit, say it has been pressed
    public static final double XBOX_JOYSTICK_DEADBAND = 0.08;
    public static final double XBOX_SPEED_SCALE_FACTOR = 0.8;
    public static final double XBOX_TURN_SCALE_FACTOR = 0.7;

    public static final double JOYSTICK_DEADBAND = 0.08;
    public static final double JOYSTICK_SPEED_SCALE_FACTOR = 1.0;
    public static final double JOYSTICK_TURN_SCALE_FACTOR = 1.0;

    public static final boolean COMPETITION_ROBOT = true;

    public static final double SLOW_MODE_SPEED_SCALE = 0.75;
    public static final double SLOW_MODE_TURN_SCALE = 0.75;

    public static final double CLIMB_MODE_SPEED_SCALE = 0.5;
    public static final double CLIMB_MODE_TURN_SCALE = 0.5;

    // Define all constants for trajectory following for autonomous
    public static final double K_S = 0.814; // volts
    public static final double K_V = 3.06; // volt seconds / meter
    public static final double K_A = 0.677; // volt sec^2 / meter
    public static final double K_P = 43.6; // volt meters / sec
    public static final double K_D = 20.2;

    public static final double K_TRACKWIDTH = 0.69; // meters
    public static final DifferentialDriveKinematics K_DRIVE_KINEMATICS =
    new DifferentialDriveKinematics(K_TRACKWIDTH);
    public static final double K_MAX_SPEED = 3; // meters/sec
    public static final double K_MAX_ACCEL = 3; // meters/sec^2

    public static final double K_RAMSETE_B = 2;
    public static final double K_RAMSETE_ZETA = 0.7;

    public static final boolean K_GYRO_REVERSED = false; // Does gyro measure clockwise?
    public static final double K_WHEEL_DIAMETER = 4.0; // wheel diameter in inches
    public static final double K_DRIVE_POS_CONV = 1.0; // Encoder position conversion factor
    public static final double K_DRIVE_VEL_CONV = 1.0; // Encoder velocity conversion factor

    public static final double CONVERT_INCHES_TO_METERS = 0.0254;
}

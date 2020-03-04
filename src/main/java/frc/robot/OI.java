package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ClimberCommands.LowerClimber;
import frc.robot.commands.ClimberCommands.RaiseClimber;
import frc.robot.commands.ClimberCommands.ToggleClimberUpDown;
import frc.robot.commands.DriveCommands.DriveFast;
import frc.robot.commands.DriveCommands.DriveSlow;
import frc.robot.commands.DriveCommands.ToggleDriveSlow;
import frc.robot.commands.FlywheelCommands.RunFlywheelUntilTowerHasStopped;
import frc.robot.commands.FlywheelCommands.ShootFromFar;
import frc.robot.commands.FlywheelCommands.ShootLayup;
import frc.robot.commands.FlywheelCommands.ToggleHoodUpDown;
import frc.robot.commands.HopperCommands.UnjamHopper;
import frc.robot.commands.IntakeCommands.StartIntake;
import frc.robot.commands.IntakeCommands.StopIntake;
import frc.robot.commands.IntakeCommands.ToggleIntakeOnOff;
import frc.robot.commands.IntakeCommands.UnjamIntake;
import frc.robot.commands.LimelightCommands.Centering;
import frc.robot.commands.LimelightCommands.ToggleLight;
import frc.robot.commands.MiscCommands.StopAllSubsystems;
import frc.robot.commands.TowerCommands.RunTowerBasedOffFlyWheel;
import frc.robot.commands.TowerCommands.ToggleTowerOnOff;
import frc.robot.commands.TowerCommands.UnjamTower;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Tower;

public class OI {
    private final Drivetrain m_driveTrain;
    private final Tower m_tower;
    private final Hopper m_hopper;
    private final Flywheel m_flywheel;
    private final Intake m_intake;
    private final Climber m_climber;
    private final Limelight m_limelight;

    private Joystick leftJoystick, rightJoystick, operatorJoystick, driverXboxController;

    private JoystickButton leftTrigger, leftButton2, leftButton3, leftButton4;
    private JoystickButton rightTrigger, rightButton2, rightButton3, rightButton4;
    private JoystickButton opTrigger, opButton2, opButton3, opButton4, opButton5, opButton6, opButton7, opButton8, opButton9, opButton10, opButton11, opButton12;
    private JoystickButton driverButtonA, driverButtonB, driverButtonX, driverButtonY, driverButtonLeftBumper, driverButtonRightBumper, driverButtonBack, driverButtonStart;

    private XboxTrigger driverLeftTrigger, driverRightTrigger;

    public OI(Drivetrain d, Tower t, Hopper h, Flywheel f, Intake i, Climber c, Limelight l){
        m_driveTrain = d;
        m_tower = t;
        m_hopper = h;
        m_flywheel = f;
        m_intake = i;
        m_climber = c;
        m_limelight = l;

        if(Constants.USE_XBOX_CONTROLLER){
            initializeXboxControllers();
            configureXboxControllers();
            m_driveTrain.setDriverXboxController(driverXboxController);
        }
        else{
            initializeJoysticks();
            configureJoysticks();
            m_driveTrain.setJoysticks(leftJoystick, rightJoystick);
        }
}

  private void initializeJoysticks() {
  
    leftJoystick = new Joystick(0);
    rightJoystick = new Joystick(1);
    operatorJoystick = new Joystick(2);

    leftTrigger = new JoystickButton(leftJoystick, 1);
    leftButton2 = new JoystickButton(leftJoystick, 2);
    leftButton3 = new JoystickButton(leftJoystick, 3);
    leftButton4 = new JoystickButton(leftJoystick, 4);
    
    rightTrigger = new JoystickButton(rightJoystick, 1);
    rightButton2 = new JoystickButton(rightJoystick, 2);
    rightButton3 = new JoystickButton(rightJoystick, 3);
    rightButton4 = new JoystickButton(rightJoystick, 4);

    opTrigger = new JoystickButton(operatorJoystick, 1);
    opButton2 = new JoystickButton(operatorJoystick, 2);
    opButton3 = new JoystickButton(operatorJoystick, 3);
    opButton4 = new JoystickButton(operatorJoystick, 4);
    opButton5 = new JoystickButton(operatorJoystick, 5);
    opButton6 = new JoystickButton(operatorJoystick, 6);
    opButton7 = new JoystickButton(operatorJoystick, 7);
    opButton8 = new JoystickButton(operatorJoystick, 8);
    opButton9 = new JoystickButton(operatorJoystick, 9);
    opButton10 = new JoystickButton(operatorJoystick, 10);
    opButton11 = new JoystickButton(operatorJoystick, 11);
    opButton12 = new JoystickButton(operatorJoystick, 12);

  }

  private void configureJoysticks() {

    leftTrigger.whenPressed(new StartIntake(m_intake, m_hopper, m_tower));
    leftButton2.whenPressed(new StopIntake(m_intake, m_hopper));
    leftButton3.whileHeld(new ParallelCommandGroup(
      new UnjamTower(m_tower, Constants.REVERSE_PERCENT_TOWER),
      new UnjamHopper(m_hopper, Constants.REVERSE_PERCENT_HOPPER)
    ));
    leftButton4.toggleWhenPressed(new ToggleDriveSlow(m_driveTrain));
    
    rightTrigger.whileHeld(new ParallelCommandGroup(
                            new ShootLayup(m_flywheel, Constants.RPM_LAYUP, false), 
                            new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel)));
    rightTrigger.whenReleased(new RunFlywheelUntilTowerHasStopped(m_tower, m_flywheel));
    rightButton2.whileHeld(new ParallelCommandGroup(
                            new Centering(m_limelight, m_driveTrain, 0, false),
                            new ShootFromFar(m_flywheel, Constants.RPM_FAR, false),
                            new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel)));
    rightButton2.whenReleased(new RunFlywheelUntilTowerHasStopped(m_tower, m_flywheel));
    rightButton3.whenPressed(new LowerClimber(m_climber));
    rightButton4.whenHeld(new RaiseClimber(m_climber));

    opTrigger.whileHeld(new ParallelCommandGroup(
      new UnjamTower(m_tower, Constants.REVERSE_PERCENT_TOWER),
      new UnjamHopper(m_hopper, Constants.REVERSE_PERCENT_HOPPER)
    ));
    opButton2.whileHeld(new ParallelCommandGroup(
      new UnjamTower(m_tower, Constants.REVERSE_PERCENT_TOWER),
      new UnjamHopper(m_hopper, Constants.REVERSE_PERCENT_HOPPER),
      new UnjamIntake(m_intake, Constants.REVERSE_PERCENT_INTAKE)
    ));
    opButton3.whenHeld(new ToggleHoodUpDown(m_flywheel));
    opButton4.whenHeld(new UnjamTower(m_tower, Constants.REVERSE_PERCENT_TOWER));
    opButton5.whenHeld(new UnjamHopper(m_hopper, Constants.REVERSE_PERCENT_HOPPER));
    opButton6.whenHeld(new UnjamIntake(m_intake, Constants.REVERSE_PERCENT_INTAKE));
    opButton7.toggleWhenPressed(new ToggleClimberUpDown(m_climber));
    opButton8.toggleWhenPressed(new ToggleIntakeOnOff(m_intake, m_tower, m_hopper));
    opButton9.toggleWhenPressed(new ToggleTowerOnOff(m_tower));
    opButton10.toggleWhenPressed(new ToggleLight(m_limelight));
    opButton11.whenPressed(new StopAllSubsystems(m_intake, m_tower, m_hopper, m_flywheel));

  }

  private void initializeXboxControllers(){
    driverXboxController = new Joystick(0);
    driverLeftTrigger = new XboxTrigger(driverXboxController, 2);
    driverRightTrigger = new XboxTrigger(driverXboxController, 3);
	driverButtonA = new JoystickButton(driverXboxController, 1);
	driverButtonB = new JoystickButton(driverXboxController, 2);
	driverButtonX = new JoystickButton(driverXboxController, 3);
	driverButtonY = new JoystickButton(driverXboxController, 4);
	driverButtonLeftBumper = new JoystickButton(driverXboxController, 5);
	driverButtonRightBumper = new JoystickButton(driverXboxController, 6);
	driverButtonBack = new JoystickButton(driverXboxController, 7);
	driverButtonStart = new JoystickButton(driverXboxController, 8);
  }

  private void configureXboxControllers(){
    driverLeftTrigger.whenPressed(new StartIntake(m_intake, m_hopper, m_tower));
    driverButtonLeftBumper.whenPressed(new StopIntake(m_intake, m_hopper));

    driverRightTrigger.whileHeld(new ParallelCommandGroup(
        new ShootLayup(m_flywheel, Constants.RPM_LAYUP, false), 
        new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel)));
    driverRightTrigger.whenReleased(new RunFlywheelUntilTowerHasStopped(m_tower, m_flywheel));

    driverButtonRightBumper.whileHeld(new ParallelCommandGroup(
        new UnjamTower(m_tower, Constants.REVERSE_PERCENT_TOWER),
        new UnjamHopper(m_hopper, Constants.REVERSE_PERCENT_HOPPER)
      ));
      
    driverButtonA.whileHeld(new ParallelCommandGroup(
        new Centering(m_limelight, m_driveTrain, 0, false),
        new ShootFromFar(m_flywheel, Constants.RPM_FAR, false),
        new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel)));
    driverButtonA.whenReleased(new RunFlywheelUntilTowerHasStopped(m_tower, m_flywheel));
    
    driverButtonB.whenHeld(new RaiseClimber(m_climber));
    driverButtonX.whenPressed(new LowerClimber(m_climber));
    
    driverButtonBack.whenPressed(new DriveSlow(m_driveTrain));
    driverButtonStart.whenPressed(new DriveFast(m_driveTrain));

  }

   /**
     * This class is used to represent one of the two
     * Triggers on an Xbox360 controller.
     */
    public static class XboxTrigger extends JoystickButton {
        
        /* Instance Values */
        private final Joystick m_parent;        
        private int m_axis;
        
        public XboxTrigger(Joystick joystick, int axis) {
            super(joystick, axis);
            m_parent = joystick;
            m_axis = axis;

        }
        
        /**
         * 0 = Not pressed
         * 1 = Completely pressed
         * @return How far its pressed
         */
        @Override
        public boolean get() {
            double rawInput = m_parent.getRawAxis(m_axis);
            
            return (createDeadZone(rawInput, Constants.XBOX_TRIGGER_DEADZONE) > Constants.XBOX_TRIGGER_SENSITIVITY);
        }
        
            /**
         * Creates a deadzone, but without clipping the lower values.
         * turns this
         * |--1--2--3--4--5--|
         * into this
         * ______|-1-2-3-4-5-|
         * @param input
         * @param deadZoneSize
         * @return adjusted_input
         */
        private double createDeadZone(double input, double deadZoneSize) {
            final   double  negative;
                    double  deadZoneSizeClamp = deadZoneSize;
                    double  adjusted;
            
            if (deadZoneSizeClamp < 0 || deadZoneSizeClamp >= 1) {
                deadZoneSizeClamp = 0;  // Prevent any weird errors
            }
            
            negative    = input < 0 ? -1 : 1;
            
            adjusted    = Math.abs(input) - deadZoneSizeClamp;  // Subtract the deadzone from the magnitude
            adjusted    = adjusted < 0 ? 0 : adjusted;          // if the new input is negative, make it zero
            adjusted    = adjusted / (1 - deadZoneSizeClamp);   // Adjust the adjustment so it can max at 1
            
            return negative * adjusted;
        }
        
    }
}

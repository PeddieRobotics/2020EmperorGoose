/**
 * FRC 5895 (Peddie School Robotics)
 * Initializes and configures all controls.
 * Also initializes all subsystems for the robots.
 * 
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Framework.CommandLooper;
import frc.robot.commands.AutoCommands.FollowPath;
import frc.robot.commands.ClimberCommands.LowerClimber;
import frc.robot.commands.ClimberCommands.ToggleClimberUpDown;
import frc.robot.commands.DriveCommands.Drive;
import frc.robot.commands.FlywheelCommands.LowerHood;
import frc.robot.commands.FlywheelCommands.StopFlywheel;
import frc.robot.commands.FlywheelCommands.ToggleFlywheelOnOff;
import frc.robot.commands.FlywheelCommands.ToggleHoodUpDown;
import frc.robot.commands.HopperCommands.StopHopper;
import frc.robot.commands.HopperCommands.ToggleHopperOnOff;
import frc.robot.commands.IntakeCommands.RaiseIntake;
import frc.robot.commands.IntakeCommands.StopIntake;
import frc.robot.commands.IntakeCommands.ToggleIntakeOnOff;
import frc.robot.commands.IntakeCommands.ToggleIntakeUpDown;
import frc.robot.commands.JoystickCommands.ShootFlywheel;
import frc.robot.commands.TowerCommands.IndexPowerCells;
import frc.robot.commands.TowerCommands.StopTower;
import frc.robot.commands.TowerCommands.ToggleTowerOnOff;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.TestSubsystem;
import frc.robot.subsystems.Tower;

public class RobotContainer {
  // Default to code for competition robot, but can switch this boolean here to run practice robot
  private static boolean isCompetitionRobot = true;
  
  // If it's test mode, we may want to do a few things differently...
  private static boolean isTestMode = false;

  // The robot's subsystems are defined here...
  private final Drivetrain m_driveTrain;
  private final Tower m_tower;
  private final Hopper m_hopper;
  private final Flywheel m_flywheel;
  private final Intake m_intake;
  private final Hood m_hood;
  private final Climber m_climber;
  private final Limelight m_limelight;
  
  private final TestSubsystem test;

  private final SendableChooser<String> chooser;

  private Joystick leftDriverJoystick, rightDriverJoystick, operatorJoystick;

  private JoystickButton leftButton1, leftButton2, leftButton3, leftButton4, leftButton5, leftButton6, leftButton7, leftButton8;
  private JoystickButton rightButton1, rightButton2, rightButton3, rightButton4, rightButton5, rightButton6, rightButton7, rightButton8;
  private JoystickButton operatorButton1, operatorButton2, operatorButton3, operatorButton4, operatorButton5, operatorButton6, operatorButton7, operatorButton8;
  
  public RobotContainer() {

    // Set up the command looper to manage command scheduling
    CommandLooper.getInstance().startAndSetPeriodic(5);

    // Set up driver and operator joysticks, along with all of their buttons
    initializeJoysticks();

    // Initialize all subsystems
    m_driveTrain = new Drivetrain(leftDriverJoystick, rightDriverJoystick);
    m_tower = new Tower();
    m_hopper = new Hopper();
    m_flywheel = new Flywheel();
    m_intake = new Intake(); 
    m_hood = new Hood();
    m_climber = new Climber();
    m_limelight = new Limelight();
    
    // Vijay's temporary test subsystem for running new robot
    // Should be refactored/removed
    test = new TestSubsystem();
  
    // Set default behaviors for subsystems which should start active
    m_driveTrain.setDefaultCommand(new Drive(m_driveTrain));
    if(!isTestMode){
      m_tower.setDefaultCommand(new IndexPowerCells(m_tower, m_hopper));
    }

    // Configure menu for SmartDashboard to select auto routines to be sent to robot
    chooser = new SendableChooser<String>();
    chooser.addOption("turn 12 move 12s","testPath");
    chooser.addOption("real 10s","real10");
    chooser.addOption("real 20s","real20");
    
  }


  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public void configureButtonBindings() {
    // leftButton1.toggleWhenPressed(new toggleIntakeState(m_Intake));
    leftButton2.whileActiveContinuous(new ShootFlywheel(m_tower, m_flywheel, m_hopper, 1300));
    // final PathFollower pathFollower = new PathFollower(m_driveTrain,path2.getSelected(),true);
    // CommandLooper.getInstance().addCommand(new testAuto(m_hopper, m_tower, m_shooter,follow2));
    //rightButton2.whenActive(new buttonAim(m_driveTrain, m_limelight));

  }

  public void configureTestButtonBindings() {
    isTestMode = true;

    leftButton1.whenPressed(new ToggleHoodUpDown(m_hood));
    leftButton2.whenPressed(new ToggleIntakeUpDown(m_intake));
    leftButton3.whenPressed(new ToggleClimberUpDown(m_climber));
    leftButton4.whenPressed(new ToggleIntakeOnOff(m_intake));
    leftButton5.whenPressed(new ToggleHopperOnOff(m_hopper));
    leftButton6.whenPressed(new ToggleTowerOnOff(m_tower));
    leftButton7.whenPressed(new ToggleFlywheelOnOff(m_flywheel));
    leftButton8.whenPressed(new ParallelCommandGroup(new StopIntake(m_intake), new StopHopper(m_hopper),
                                  new StopTower(m_tower), new StopFlywheel(m_flywheel), new LowerClimber(m_climber),
                                  new LowerHood(m_hood), new RaiseIntake(m_intake)));
  }

  private void initializeJoysticks() {
  
    leftDriverJoystick = new Joystick(0);
    rightDriverJoystick = new Joystick(1);
    operatorJoystick = new Joystick(2);

    leftButton1 = new JoystickButton(leftDriverJoystick, 1);
    leftButton2 = new JoystickButton(leftDriverJoystick, 2);
    leftButton3 = new JoystickButton(leftDriverJoystick, 3);
    leftButton4 = new JoystickButton(leftDriverJoystick, 4);
    leftButton5 = new JoystickButton(leftDriverJoystick, 5);
    leftButton6 = new JoystickButton(leftDriverJoystick, 6);
    leftButton7 = new JoystickButton(leftDriverJoystick, 7);
    leftButton8 = new JoystickButton(leftDriverJoystick, 8);

    rightButton1 = new JoystickButton(rightDriverJoystick, 1);
    rightButton2 = new JoystickButton(rightDriverJoystick, 2);
    rightButton3 = new JoystickButton(rightDriverJoystick, 3);
    rightButton4 = new JoystickButton(rightDriverJoystick, 4);
    rightButton5 = new JoystickButton(rightDriverJoystick, 5);
    rightButton6 = new JoystickButton(rightDriverJoystick, 6);
    rightButton7 = new JoystickButton(rightDriverJoystick, 7);
    rightButton8 = new JoystickButton(rightDriverJoystick, 8);

    operatorButton1 = new JoystickButton(operatorJoystick, 1);
    operatorButton2 = new JoystickButton(operatorJoystick, 2);
    operatorButton3 = new JoystickButton(operatorJoystick, 3);
    operatorButton4 = new JoystickButton(operatorJoystick, 4);
    operatorButton5 = new JoystickButton(operatorJoystick, 5);
    operatorButton6 = new JoystickButton(operatorJoystick, 6);
    operatorButton7 = new JoystickButton(operatorJoystick, 7);
    operatorButton8 = new JoystickButton(operatorJoystick, 8);

  }
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    FollowPath autoPathFromChooser = new frc.robot.commands.AutoCommands.FollowPath(m_driveTrain, chooser.getSelected(), true);
    // CommandLooper.getInstance().addCommand(new TestAuto(m_Hopper, m_Tower, m_Shoot,m_Hood));
    
    return autoPathFromChooser;
  }

  public void setBrakeMode(){
    m_driveTrain.setBrake();
  }

  public void setCoastMode(){
    m_driveTrain.setCoast();
  }
  
  public static boolean isCompetitionRobot(){
    return isCompetitionRobot;
  }
  
}

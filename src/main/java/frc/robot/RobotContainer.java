/**
 * Peddie 5895 FIRST Robotics
 * RobotContainer.java
 * Initializes and configures all controls.
 * Also initializes all subsystems for the robots.
 * 
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */

package frc.robot;

import com.team319.trajectory.Path;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Framework.CommandLooper;
import frc.robot.commands.Drive;
import frc.robot.commands.FollowPath;
import frc.robot.commands.JoystickCommands.shootFlyWheel;
import frc.robot.commands.TowerCommands.indexPowerCells;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TestSubsystem;
import frc.robot.subsystems.Tower;

public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_driveTrain;
  private final Tower m_tower;
  private final Hopper m_hopper;
  private final Shooter m_shooter;
  private final Intake m_intake;
  private final Hood m_hood;
  private final Limelight m_limelight;
  
  private final TestSubsystem test;

  private final SendableChooser<String> chooser;

  private final Joystick leftDriverJoystick, rightDriverJoystick, operatorJoystick;

  private final JoystickButton leftButton1, leftButton2, leftButton3, leftButton4;
  private final JoystickButton rightButton1, rightButton2, rightButton3, rightButton4;
  private final JoystickButton operatorButton1, operatorButton2, operatorButton3, operatorButton4;

  public RobotContainer() {

    // Set up the command looper to manage command scheduling
    CommandLooper.getInstance().startAndSetPeriodic(5);

    // Initialize all subsystems
    m_driveTrain = new Drivetrain();
    m_tower = new Tower();
    m_hopper = new Hopper();
    m_shooter = new Shooter();
    m_intake = new Intake(); 
    m_hood = new Hood();
    m_limelight = new Limelight();
    
    // Vijay's temporary test subsystem for running new robot
    // Should be refactored/removed
    test = new TestSubsystem();
  
    // Set default behaviors for subsystems which should start active
    m_driveTrain.setDefaultCommand(new Drive(m_driveTrain));
    m_tower.setDefaultCommand(new indexPowerCells(m_tower, m_hopper));
    
    // Configure driver and operator joysticks
    leftDriverJoystick = new Joystick(0);
    rightDriverJoystick = new Joystick(1);
    operatorJoystick = new Joystick(2);

    leftButton1 = new JoystickButton(leftDriverJoystick, 1);
    leftButton2 = new JoystickButton(leftDriverJoystick, 2);
    leftButton3 = new JoystickButton(leftDriverJoystick, 3);
    leftButton4 = new JoystickButton(leftDriverJoystick, 4);

    rightButton1 = new JoystickButton(rightDriverJoystick, 1);
    rightButton2 = new JoystickButton(rightDriverJoystick, 2);
    rightButton3 = new JoystickButton(rightDriverJoystick, 3);
    rightButton4 = new JoystickButton(rightDriverJoystick, 4);

    operatorButton1 = new JoystickButton(operatorJoystick, 1);
    operatorButton2 = new JoystickButton(operatorJoystick, 2);
    operatorButton3 = new JoystickButton(operatorJoystick, 3);
    operatorButton4 = new JoystickButton(operatorJoystick, 4);

    /* Now that all joysticks and buttons have been initialized,
    specify the commands that should be associated with each button press.
    */
    configureButtonBindings();

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
  private void configureButtonBindings() {
    // leftButton1.toggleWhenPressed(new toggleIntakeState(m_Intake));
    leftButton2.whileActiveContinuous(new shootFlyWheel(m_tower, m_shooter, m_hopper));
    // final PathFollower pathFollower = new PathFollower(m_driveTrain,path2.getSelected(),true);
    // CommandLooper.getInstance().addCommand(new testAuto(m_hopper, m_tower, m_shooter,follow2));
    //rightButton2.whenActive(new buttonAim(m_driveTrain, m_limelight));

  }

  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    FollowPath autoCommandFromChooser = new FollowPath(m_driveTrain, chooser.getSelected(), true);
    // CommandLooper.getInstance().addCommand(new testAuto(m_Hopper, m_Tower, m_Shoot,m_Hood));
    
    return autoCommandFromChooser;
  }

  public void setBrakeMode(){
    m_driveTrain.setBrake();
  }

  public void setCoastMode(){
    m_driveTrain.setCoast();
  }

  public double getSpeed() {
    return -leftDriverJoystick.getRawAxis(1);
  }

  public double getTurn() {
    return rightDriverJoystick.getRawAxis(0);
  }
  
}

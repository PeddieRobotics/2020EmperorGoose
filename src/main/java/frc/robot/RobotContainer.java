package frc.robot;

import java.util.ArrayList;

import com.team319.trajectory.Path;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Framework.CommandLooper;
import frc.robot.commands.Drive;
import frc.robot.commands.Intaking;
import frc.robot.commands.PathFollower;
import frc.robot.commands.Shoot;
import frc.robot.commands.testCommandForStuff;
import frc.robot.commands.FlyWheelCommands.putHoodDown;
import frc.robot.commands.FlyWheelCommands.putHoodUp;
import frc.robot.commands.IntakeCommands.toggleIntakeState;
import frc.robot.commands.IntakeCommands.stopIntake;
import frc.robot.commands.JoystickCommandGroups.DisableShootingSubsystems;
import frc.robot.commands.JoystickCommandGroups.toggleIntakeUpAndDown;
import frc.robot.commands.TowerCommands.indexPowerCells;
import frc.robot.commands.TowerCommands.stopTower;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TestSubsytem;
import frc.robot.subsystems.Tower;

public class RobotContainer {

  Notifier runPathFaster;
  // The robot's subsystems and commands are defined here...
  
  private PathFollower pFollower;
  private final Drivetrain m_driveTrain = new Drivetrain();

  SendableChooser<Path> chooser = new SendableChooser<Path>(); 
  SendableChooser<String> path2  = new SendableChooser<String>();

  //TestSubsytem test = new TestSubsytem();
  Tower m_Tower = new Tower();
  Hopper m_Hopper = new Hopper();
  Shooter m_Shooter = new Shooter();
  Intake m_Intake = new Intake(); 
  Flywheel m_Flywheel = new Flywheel();
  Hood m_Hood = new Hood();

  Joystick leftJoystick;
  Joystick rightJoystick;
  Joystick opJoystick;

  JoystickButton leftTrigger, left2, left3, left4;
  JoystickButton rightTrigger, right2, right3, right4;
  JoystickButton opTrigger, op2, op3, op4, op5, op6;

  public RobotContainer() {

    CommandLooper.getInstance().startAndSetPeriodic(5);
    m_Tower.setDefaultCommand(new indexPowerCells(m_Tower, m_Hopper));
    
    leftJoystick = new Joystick(0);
    rightJoystick = new Joystick(1);
    opJoystick = new Joystick(3);

    leftTrigger = new JoystickButton(leftJoystick, 1);
    left2 = new JoystickButton(leftJoystick, 2);
    left3 = new JoystickButton(leftJoystick, 3);
    left4 = new JoystickButton(leftJoystick, 4);

    rightTrigger = new JoystickButton(rightJoystick, 1);
    right2 = new JoystickButton(rightJoystick, 2);
    right3 = new JoystickButton(rightJoystick, 3);
    right4 = new JoystickButton(rightJoystick, 4);

    opTrigger = new JoystickButton(opJoystick, 1);
    op2 = new JoystickButton(opJoystick, 2);
    op3 = new JoystickButton(opJoystick, 3);
    op4 = new JoystickButton(opJoystick, 4);
    op5 = new JoystickButton(opJoystick, 5);
    op6 = new JoystickButton(opJoystick, 6);
   
    // chooser.addOption("real 30", realThirty);
    //  SmartDashboard.putData("path 1",chooser);
    //  SmartDashboard.putData("path 2",path2);
    // path2.addOption("turn 12 move 12s","testPath");
    
    // path2.addOption("real 10s","real10");
    
    //path2.addOption("real 20s","real20");
    
    //Configure the button bindings
    
    m_driveTrain.setDefaultCommand( new Drive( m_driveTrain, this ) );
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    leftTrigger.whenPressed( new Intaking( m_Intake, true, false ) );
    left2.whenPressed( new stopIntake( m_Intake ) );
    left3.whenHeld(new Intaking( m_Intake, true, true ) );

    rightTrigger.whenHeld( new Shoot( m_Flywheel, m_Tower ) );
    right2.whenPressed( new DisableShootingSubsystems( m_Tower, m_Shooter, m_Hopper ) );

    opTrigger.whenPressed( new putHoodUp( m_Hood ) );
    op2.whenPressed( new putHoodDown( m_Hood ) );
    
  }

  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    final PathFollower follow2 = new PathFollower(m_driveTrain,path2.getSelected(),true);
    CommandLooper.getInstance().addCommand(follow2);

    return follow2;

  }

  public void setBrakeMode() {
    m_driveTrain.setBrake();
  }

  public void setCoastMode() {
    m_driveTrain.setCoast();
  }

  public double getSpeed() {
    return -leftJoystick.getRawAxis(1);
  }

  public double getTurn() {
    return rightJoystick.getRawAxis(0);
  }
  
}

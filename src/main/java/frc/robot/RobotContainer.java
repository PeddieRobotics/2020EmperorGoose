/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

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
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Framework.CommandLooper;
import frc.robot.commands.Drive;
import frc.robot.commands.PathFollower;
import frc.robot.commands.testCommandForStuff;
import frc.robot.commands.FlyWheelCommands.putHoodUp;
import frc.robot.commands.FlyWheelCommands.startFlywheel;
import frc.robot.commands.IntakeCommands.toggleIntakeState;
import frc.robot.commands.JoystickCommandGroups.toggleIntakeUpAndDown;
import frc.robot.commands.LimelightCommands.buttonAim;
import frc.robot.commands.TowerCommands.indexPowerCells;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hood;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TestSubsytem;
import frc.robot.subsystems.Tower;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */

public class RobotContainer {
  Notifier runPathFaster;
  // The robot's subsystems and commands are defined here...
  
  private PathFollower follow10;
  private final Drivetrain m_driveTrain = new Drivetrain();
  Joystick left ;
  JoystickButton leftTrigger; 
  SendableChooser<Path> chooser = new SendableChooser<Path>(); 
  SendableChooser<String> path2  = new SendableChooser<String>();
  //TestSubsytem test = new TestSubsytem();
  Tower m_Tower = new Tower();
  Hopper m_Hopper = new Hopper();
 // Shooter m_Shoot = new Shooter();
  Intake m_Intake = new Intake(); 
  Hood m_Hood = new Hood();
  Limelight m_limelight = new Limelight();
  TestSubsytem test = new TestSubsytem();
  Joystick leftJoystick;
  Joystick rightJoystick;

  JoystickButton left1, left2, left3, left4;
  JoystickButton right1, right2, right3, right4;

  public RobotContainer() {

  CommandLooper.getInstance().startAndSetPeriodic(5);
   m_Tower.setDefaultCommand(new indexPowerCells(m_Tower, m_Hopper));
    
   leftJoystick = new Joystick(0);
    rightJoystick = new Joystick(1);

    left1 = new JoystickButton(leftJoystick, 1);
    left2 = new JoystickButton(leftJoystick, 2);
    left3 = new JoystickButton(leftJoystick, 3);
    left4 = new JoystickButton(leftJoystick, 4);

    right1 = new JoystickButton(rightJoystick, 1);
  right2 = new JoystickButton(rightJoystick, 2);
    right3 = new JoystickButton(rightJoystick, 3);
    right4 = new JoystickButton(rightJoystick, 4);
   
   // chooser.addOption("real 30", realThirty);
  //  SmartDashboard.putData("path 1",chooser);
  //  SmartDashboard.putData("path 2",path2);
   // path2.addOption("turn 12 move 12s","testPath");
    
   // path2.addOption("real 10s","real10");
    
    //path2.addOption("real 20s","real20");
    
    //Configure the button bindings
    
    m_driveTrain.setDefaultCommand(new Drive(m_driveTrain,this));
    configureButtonBindings();

  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    left1.toggleWhenPressed(new toggleIntakeState(m_Intake));
 //   right1.whenActive(new ParallelCommandGroup( new startFlywheel(m_Shoot), new putHoodUp(m_Hood)));
    right2.whenActive(new buttonAim(m_driveTrain, m_limelight));
    

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
  public void setBrakeMode(){
    m_driveTrain.setBrake();
  }
  public void setCoastMode(){
    m_driveTrain.setCoast();
  }
  public double getSpeed() {
    return -leftJoystick.getRawAxis(1);
  }

  public double getTurn() {
    return rightJoystick.getRawAxis(0);
  }
  
}

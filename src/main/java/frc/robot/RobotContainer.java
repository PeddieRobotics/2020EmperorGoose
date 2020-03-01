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

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoCommands.FollowPath;
import frc.robot.commands.AutoCommands.ShootNTimes;
import frc.robot.commands.ClimberCommands.LowerClimber;
import frc.robot.commands.ClimberCommands.RaiseClimber;
import frc.robot.commands.ClimberCommands.ToggleClimberUpDown;
import frc.robot.commands.DriveCommands.Drive;
import frc.robot.commands.FlywheelCommands.RaiseHood;
import frc.robot.commands.FlywheelCommands.ReverseFlywheel;
import frc.robot.commands.FlywheelCommands.RunFlywheelUntilTowerHasStopped;
import frc.robot.commands.FlywheelCommands.ShootFromFar;
import frc.robot.commands.FlywheelCommands.ShootLayup;
import frc.robot.commands.FlywheelCommands.ToggleFlywheelOnOff;
import frc.robot.commands.FlywheelCommands.ToggleHoodUpDown;
import frc.robot.commands.HopperCommands.ToggleHopperOnOff;
import frc.robot.commands.IntakeCommands.StartIntake;
import frc.robot.commands.IntakeCommands.StopIntake;
import frc.robot.commands.IntakeCommands.ToggleIntakeOnOff;
import frc.robot.commands.LimelightCommands.Centering;
import frc.robot.commands.LimelightCommands.ToggleLight;
import frc.robot.commands.MiscCommands.StopAllSubsystems;
import frc.robot.commands.TowerCommands.IndexPowerCells;
import frc.robot.commands.TowerCommands.RunTowerBasedOffFlyWheel;
import frc.robot.commands.TowerCommands.StopTower;
import frc.robot.commands.TowerCommands.ToggleTowerOnOff;
import frc.robot.commands.TowerCommands.UnjamTower;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Tower;
public class RobotContainer {
  // Default to code for competition robot, but can switch this boolean here to run practice robot
  private static boolean isCompetitionRobot = true;
  
  // If it's test mode, we may want to do a few things differently...
  private boolean isTestMode = false;

  // The robot's subsystems are defined here...
  private final Drivetrain m_driveTrain;
  private final Tower m_tower;
  private final Hopper m_hopper;
  private final Flywheel m_flywheel;
  private final Intake m_intake;
  private final Climber m_climber;
  private final Limelight m_limelight;

  private SendableChooser<String> chooser;

  private Joystick leftJoystick, rightJoystick, operatorJoystick;

  private JoystickButton leftTrigger, leftButton2, leftButton3, leftButton4, leftButton5, leftButton6, leftButton7, leftButton8;
  private JoystickButton rightTrigger, rightButton2, rightButton3, rightButton4, rightButton5, rightButton6, rightButton7, rightButton8;
  private JoystickButton opTrigger, opButton2, opButton3, opButton4, opButton5, opButton6, opButton7, opButton8;
  
  public RobotContainer() {
    // Set up the command looper to manage command scheduling
 
    // Set up driver and operator joysticks, along with all of their buttons
    initializeJoysticks();

    // Initialize all subsystems
    m_driveTrain = new Drivetrain(leftJoystick, rightJoystick);
    m_tower = new Tower();
    m_hopper = new Hopper();
    m_flywheel = new Flywheel();
    m_intake = new Intake();
    m_climber = new Climber();
    m_limelight = new Limelight();
    
    // Configure menu for SmartDashboard to select auto routines to be sent to robot
    configureAutoRoutines();
    configureSmartDashboard();
    
  }
    
  // Set default behaviors for subsystems which should start active
  public void configureDefaultBehaviors() {
    // Always make the drivetrain active in any mode
    m_driveTrain.setDefaultCommand(new Drive(m_driveTrain, true));
    // Don't index the tower by default in test mode
    if(!isTestMode){
      m_tower.setDefaultCommand(new IndexPowerCells(m_tower, m_hopper, m_intake));
    }
   
  }

  public void resetWhenDisabled(){
    setCoastMode();
  }

  public void resetForAuto(){
  }

  /* Use a SendableChooser to create a list of possible autonomous paths.
  *  Each path is defined by a String naming the .csv file to use for that path.
  */ 
  public void configureAutoRoutines(){
    chooser = new SendableChooser<String>();
    chooser.addOption("BackOffLine","BackOffLine");
    chooser.addOption("BackupShoot3NoLL","BackupShoot3NoLL");
    chooser.addOption("BackupShoot3LL","BackupShoot3LL");
    chooser.addOption("BackUp8Test","8feet");
    chooser.addOption("Backup12Test","12feet");
    SmartDashboard.putData("Auto routine", chooser);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  public void configureButtonBindings() {
    leftTrigger.whenPressed(new StartIntake(m_intake, m_hopper, m_tower));
    leftButton2.whenPressed(new StopIntake(m_intake, m_hopper));
    // leftButton3.whenHeld(new UnjamTower(m_tower, m_hopper, 0.5));
    // leftButton4.whenPressed(new StopAllSubsystems(m_intake, m_tower, m_hopper, m_flywheel));
    
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

    opTrigger.whenHeld(new ToggleHoodUpDown(m_flywheel));
    opButton2.toggleWhenPressed(new ToggleClimberUpDown(m_climber));
    opButton3.toggleWhenPressed(new ToggleIntakeOnOff(m_intake, m_tower, m_hopper));
    opButton4.toggleWhenPressed(new ToggleTowerOnOff(m_tower));
    opButton5.toggleWhenPressed(new ToggleFlywheelOnOff(m_flywheel));
    opButton6.toggleWhenPressed(new ToggleLight(m_limelight));
    opButton7.whenPressed(new StopAllSubsystems(m_intake, m_tower, m_hopper, m_flywheel));


  }

  public void configureSmartDashboard()
  {
    DriverStation.reportError("is being called ? ", false);
    SmartDashboard.putNumber("ShootLayup Setpoint", Constants.RPM_LAYUP);
    SmartDashboard.putNumber("ShootFar Setpoint", Constants.RPM_FAR);
    
    SmartDashboard.putNumber("feed velocity", m_tower.topMotorSpeed());
  }

  public void setTestMode(boolean mode){
    isTestMode = mode;
  }

  public boolean getTestMode(){
    return isTestMode;
  }

  public void configureTestButtonBindings() {

    leftTrigger.toggleWhenPressed(new ToggleHoodUpDown(m_flywheel));
    leftButton2.toggleWhenPressed(new ToggleClimberUpDown(m_climber));
    leftButton3.toggleWhenPressed(new ToggleIntakeOnOff(m_intake, m_tower, m_hopper));
    leftButton4.toggleWhenPressed(new ToggleHopperOnOff(m_hopper));
    leftButton5.toggleWhenPressed(new ToggleTowerOnOff(m_tower));
    leftButton6.toggleWhenPressed(new ToggleFlywheelOnOff(m_flywheel));
    leftButton7.toggleWhenPressed(new ToggleLight(m_limelight));

  }

  private void initializeJoysticks() {
  
    leftJoystick = new Joystick(0);
    rightJoystick = new Joystick(1);
    operatorJoystick = new Joystick(2);

    leftTrigger = new JoystickButton(leftJoystick, 1);
    leftButton2 = new JoystickButton(leftJoystick, 2);
    leftButton3 = new JoystickButton(leftJoystick, 3);
    leftButton4 = new JoystickButton(leftJoystick, 4);
    leftButton5 = new JoystickButton(leftJoystick, 5);
    leftButton6 = new JoystickButton(leftJoystick, 6);
    leftButton7 = new JoystickButton(leftJoystick, 7);
    leftButton8 = new JoystickButton(leftJoystick, 8);

    rightTrigger = new JoystickButton(rightJoystick, 1);
    rightButton2 = new JoystickButton(rightJoystick, 2);
    rightButton3 = new JoystickButton(rightJoystick, 3);
    rightButton4 = new JoystickButton(rightJoystick, 4);
    rightButton5 = new JoystickButton(rightJoystick, 5);
    rightButton6 = new JoystickButton(rightJoystick, 6);
    rightButton7 = new JoystickButton(rightJoystick, 7);
    rightButton8 = new JoystickButton(rightJoystick, 8);

    opTrigger = new JoystickButton(operatorJoystick, 1);
    opButton2 = new JoystickButton(operatorJoystick, 2);
    opButton3 = new JoystickButton(operatorJoystick, 3);
    opButton4 = new JoystickButton(operatorJoystick, 4);
    opButton5 = new JoystickButton(operatorJoystick, 5);
    opButton6 = new JoystickButton(operatorJoystick, 6);
    opButton7 = new JoystickButton(operatorJoystick, 7);
    opButton8 = new JoystickButton(operatorJoystick, 8);

  }
  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    String autoRoutineFromChooser = chooser.getSelected();
    configureDefaultBehaviors();
    if(autoRoutineFromChooser == "BackOffLine"){
      CommandScheduler.getInstance().schedule(new FollowPath(m_driveTrain,"BackOffLine",true,false,true));
    }
    else if(autoRoutineFromChooser == "BackupShoot3NoLL"){
      CommandScheduler.getInstance().schedule(new ParallelCommandGroup( 
        new FollowPath(m_driveTrain,"MoveOffLine",true,true,true)),  
        new ParallelRaceGroup(
          new ShootNTimes(m_tower, m_flywheel, Constants.RPM_FAR, 3),
          new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel)));
    }
    else if(autoRoutineFromChooser == "BackupShoot3LL"){
      CommandScheduler.getInstance().schedule( new SequentialCommandGroup( 
        new FollowPath(m_driveTrain,"MoveOffLine",true,false,true),
        new ParallelRaceGroup(new Centering(m_limelight, m_driveTrain, 0, false),
                                 new ShootNTimes(m_tower, m_flywheel, Constants.RPM_FAR, 3),
                                 new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel))));
    }
    else if(autoRoutineFromChooser=="Backup8Test"){
      
      CommandScheduler.getInstance().schedule( new SequentialCommandGroup( 
        new FollowPath(m_driveTrain,"8feet",true,false,true),
        new ParallelRaceGroup(new Centering(m_limelight, m_driveTrain, 0, false),
                                 new ShootNTimes(m_tower, m_flywheel, Constants.RPM_FAR, 3),
                                 new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel))));
    }
    else if(autoRoutineFromChooser=="Backup12Test"){
      
      CommandScheduler.getInstance().schedule( new SequentialCommandGroup( 
        new FollowPath(m_driveTrain,"12feet",true,false,true),
        new ParallelRaceGroup(new Centering(m_limelight, m_driveTrain, 0, false),
                                 new ShootNTimes(m_tower, m_flywheel, Constants.RPM_FAR, 3),
                                 new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel))));
    }
    else {
      CommandScheduler.getInstance().schedule( new SequentialCommandGroup( 
        new FollowPath(m_driveTrain,"MoveOffLine",true,false,true),
        new ParallelRaceGroup(new Centering(m_limelight, m_driveTrain, 0, false),
                                 new ShootNTimes(m_tower, m_flywheel, Constants.RPM_FAR, 3),
                                 new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel))));
    }
    return null;

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

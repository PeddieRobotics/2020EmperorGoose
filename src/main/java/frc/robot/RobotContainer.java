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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoCommands.FollowPath;
import frc.robot.commands.AutoCommands.ShootNTimes;
import frc.robot.commands.ClimberCommands.LowerClimber;
import frc.robot.commands.ClimberCommands.RaiseClimber;
import frc.robot.commands.ClimberCommands.ToggleClimberUpDown;
import frc.robot.commands.DriveCommands.Drive;
import frc.robot.commands.FlywheelCommands.RunFlywheelUntilTowerHasStopped;
import frc.robot.commands.FlywheelCommands.ShootFromFar;
import frc.robot.commands.FlywheelCommands.ShootLayup;
import frc.robot.commands.FlywheelCommands.StartFlywheel;
import frc.robot.commands.FlywheelCommands.ToggleFlywheelOnOff;
import frc.robot.commands.FlywheelCommands.ToggleHoodUpDown;
import frc.robot.commands.HopperCommands.ToggleHopperOnOff;
import frc.robot.commands.HopperCommands.UnjamHopper;
import frc.robot.commands.IntakeCommands.StartIntake;
import frc.robot.commands.IntakeCommands.StopIntake;
import frc.robot.commands.IntakeCommands.ToggleIntakeOnOff;
import frc.robot.commands.IntakeCommands.UnjamIntake;
import frc.robot.commands.LimelightCommands.Centering;
import frc.robot.commands.LimelightCommands.ToggleLight;
import frc.robot.commands.MiscCommands.StopAllSubsystems;
import frc.robot.commands.TowerCommands.IndexPowerCells;
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

public class RobotContainer {

  // The robot's subsystems are defined here...
  private final Drivetrain m_driveTrain;
  private final Tower m_tower;
  private final Hopper m_hopper;
  private final Flywheel m_flywheel;
  private final Intake m_intake;
  private final Climber m_climber;
  private final Limelight m_limelight;

  private SendableChooser<String> chooser;

  // Operator interface (controls for driver and operator)
  private OI oi;

  public RobotContainer() {
    // Set up the command looper to manage command scheduling

    // Initialize all subsystems except drivetrain
    m_driveTrain = new Drivetrain();
    m_tower = new Tower();
    m_hopper = new Hopper();
    m_flywheel = new Flywheel();
    m_intake = new Intake();
    m_climber = new Climber();
    m_limelight = new Limelight();
    
    // Set up driver and operator joysticks, along with all of their buttons
    oi = new OI(m_driveTrain, m_tower, m_hopper, m_flywheel, m_intake, m_climber, m_limelight);
    
    configureAutoRoutines();
    configureSmartDashboard();
    
  }
    
  // Set default behaviors for subsystems which should start active
  public void configureDefaultBehaviors(boolean isTestMode) {
    // Always make the drivetrain active in any mode
    m_driveTrain.setDefaultCommand(new Drive(m_driveTrain, true));

    // Don't index the tower by default in test mode
    if(!isTestMode){
      m_tower.setDefaultCommand(new IndexPowerCells(m_tower, m_hopper, m_intake));
    }
   
  }

  /* Use a SendableChooser to create a list of possible autonomous paths.
  *  Each path is defined by a String naming the .csv file to use for that path.
  */ 
  public void configureAutoRoutines(){
    chooser = new SendableChooser<String>();

    chooser.addOption("BackOffLine","BackOffLine");
    chooser.addOption("BackupShoot3","BackupShoot3");

    SmartDashboard.putData("Auto routine", chooser);
  }

  public void configureSmartDashboard()
  {
    SmartDashboard.putNumber("ShootLayup Setpoint", Constants.RPM_LAYUP);
    SmartDashboard.putNumber("ShootFar Setpoint", Constants.RPM_FAR);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    String autoRoutineFromChooser = chooser.getSelected();
    if(autoRoutineFromChooser == "BackOffLine"){
      return new FollowPath(m_driveTrain,"BackOffLine",true,false,true);
    }
    else if(autoRoutineFromChooser == "BackupShoot3"){
      return new SequentialCommandGroup( 
        new ParallelCommandGroup(new FollowPath(m_driveTrain,"MoveOffLine",true,false,true),
                                 new StartFlywheel(m_flywheel, 3350)),
        new ParallelRaceGroup(new Centering(m_limelight, m_driveTrain, 0, false),
                                 new ShootNTimes(m_tower, m_flywheel, 3350, 3),
                                 new RunTowerBasedOffFlyWheel(m_hopper, m_tower, m_flywheel)));
    }
    return null;

  }

  public void configureSmartDashboardTest()
  {
    SmartDashboard.putNumber("Flywheel", 0.0);
    SmartDashboard.putNumber("LeftWall", 0.0);
    SmartDashboard.putNumber("RightWall", 0.0);
    SmartDashboard.putNumber("Floor", 0.0);
    SmartDashboard.putNumber("TopTower", 0.0);
    SmartDashboard.putNumber("BottomTower", 0.0);
    SmartDashboard.putNumber("Intake Setpoint", 0.0);
    SmartDashboard.putBoolean("Intake Down", false);

  }

  public void testAllSystems(){
    double flywheel_rpm = SmartDashboard.getNumber("Flywheel", 0.0);
    if(flywheel_rpm < 3500 && flywheel_rpm > 300){
      m_flywheel.setMotors(flywheel_rpm);
    }
    m_hopper.runAll(SmartDashboard.getNumber("LeftWall", 0.0),SmartDashboard.getNumber("RightWall", 0.0),SmartDashboard.getNumber("Floor", 0.0));
    m_tower.runTopMotor(SmartDashboard.getNumber("TopTower", 0.0));
    m_tower.runBottomMotor(SmartDashboard.getNumber("BottomTower", 0.0));
    m_intake.setIntakeMotor(SmartDashboard.getNumber("Intake Setpoint", 0.0));
    m_intake.setSolenoid(SmartDashboard.getBoolean("Intake Down", false));
  }

  public void setBrakeMode(){
    m_driveTrain.setBrake();
  }

  public void setCoastMode(){
    m_driveTrain.setCoast();
  }
  
}

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

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.paths.EightFeet;
import frc.paths.FourFeet;
import frc.paths.GetThreeFromTrench;
import frc.paths.GetTwoFromTrench;
import frc.paths.MiddleTwoThenShoot;
import frc.paths.SixFeet;
import frc.paths.TenFeetStraight;
import frc.paths.TwelveFeet;
import frc.robot.Auto.HelixPathFollower;
import frc.robot.commands.DriveCommands.Drive;
import frc.robot.commands.DriveCommands.TurnToAngle;
import frc.robot.commands.IntakeCommands.StartIntake;
import frc.robot.commands.IntakeCommands.StopIntake;
import frc.robot.commands.LimelightCommands.Centering;
import frc.robot.commands.LimelightCommands.TurnUntilSeesTarget;
import frc.robot.commands.TowerCommands.IndexPowerCells;
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
  private Tower m_tower;
  private Hopper m_hopper;
  private Flywheel m_flywheel;
  private Intake m_intake;
  private  Climber m_climber;
  private Limelight m_limelight;

  private SendableChooser<String> chooser;

  // Operator interface (controls for driver and operator)
  private OI oi;
  Joystick leftJoystick;
  JoystickButton button1;
  public RobotContainer() {
    // Set up the command looper to manage command scheduling
    leftJoystick = new Joystick(0);
    button1 = new JoystickButton(leftJoystick,1);
      // Initialize all subsystems except drivetrain
    m_driveTrain = new Drivetrain();
  //  m_tower = new Tower();
  //  m_hopper = new Hopper();
 //   m_flywheel = new Flywheel();
 //   m_intake = new Intake();
 //   m_climber = new Climber();
 //   m_limelight = new Limelight();
    
    // Set up driver and operator joysticks, along with all of their buttons
    //oi = new OI(m_driveTrain, m_tower, m_hopper, m_flywheel, m_intake, m_climber, m_limelight);
    
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

    chooser.addOption("Get2TrenchShoot5", "Get2TrenchShoot5");
    chooser.addOption("Shoot3Get3TrenchShoot3", "Shoot3Get3TrenchShoot3");
    chooser.addOption("4FeetTest", "4FeetTest");
    chooser.addOption("6FeetTest", "6FeetTest");
    chooser.addOption("6feetotherway", "6feetotherway");
    chooser.addOption("lefthandturn", "lefthandturn");
    chooser.addOption("righthandturn", "righthandturn");

    chooser.addOption("8FeetTest", "8FeetTest");
    chooser.addOption("10FeetTest", "10FeetTest");
    chooser.addOption("12FeetTest", "12FeetTest");
    chooser.addOption("TurnRad3","TurnRad3");
    chooser.addOption("Trench8Ball","Trench8Ball");
    chooser.addOption("BumpMidTest","BumpMidTest");
    chooser.addOption("TwoMiddleBall", "TwoMiddleBall");
    SmartDashboard.putData("Auto routine", chooser);
  }

  public void configureSmartDashboard()
  {    
    SmartDashboard.putNumber("velocity const",20); 
    SmartDashboard.putNumber("max vel",3000);
    SmartDashboard.putNumber("ShootLayup Setpoint", Constants.RPM_LAYUP);
    SmartDashboard.putNumber("ShootFar Setpoint", Constants.RPM_FAR);
    SmartDashboard.putNumber("angle goal",20);
    button1.whenPressed(new TurnToAngle(m_driveTrain, 45));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    String autoRoutineFromChooser = chooser.getSelected();
    if(autoRoutineFromChooser == "Get2TrenchShoot5"){
      return new SequentialCommandGroup(
        new ParallelRaceGroup(
          new StartIntake(m_intake, m_hopper, m_tower), 
          new HelixPathFollower(new GetTwoFromTrench(), m_driveTrain),
          new WaitCommand(6)
        ),
        new ParallelCommandGroup(new StopIntake(m_intake, m_hopper),
          new TurnUntilSeesTarget(m_driveTrain, m_limelight)),
        new Centering(m_limelight, m_driveTrain, 0, false)
      );
        
    }
    else if(autoRoutineFromChooser == "Shoot3Get3TrenchShoot3"){
      return new SequentialCommandGroup(
      new TurnToAngle(m_driveTrain, 180),  
      new HelixPathFollower(new FourFeet(),m_driveTrain),
      new TurnToAngle(m_driveTrain, 180),
      new HelixPathFollower(new FourFeet(), m_driveTrain)
        
      );
        
    }
    else if(autoRoutineFromChooser == "4FeetTest"){
      return new HelixPathFollower(new FourFeet(), m_driveTrain).sendData();
    }

    else if(autoRoutineFromChooser == "6FeetTest"){
      return new HelixPathFollower(new SixFeet(), m_driveTrain);
    }

    else if(autoRoutineFromChooser == "8FeetTest"){
      return new HelixPathFollower(new EightFeet(), m_driveTrain);
    }

    else if(autoRoutineFromChooser == "10FeetTest"){
      return new HelixPathFollower(new TenFeetStraight(), m_driveTrain);
    }

    else if(autoRoutineFromChooser == "12FeetTest"){
      return new HelixPathFollower(new TwelveFeet(), m_driveTrain);
    }
    else if(autoRoutineFromChooser == "TwoMiddleBall"){
      return new HelixPathFollower(new MiddleTwoThenShoot(), m_driveTrain);
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
  public void resetGyro(){
    m_driveTrain.resetADIS();
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

  public void calibrateGyro() {
    m_driveTrain.calibrateIMU();
  }
    
}

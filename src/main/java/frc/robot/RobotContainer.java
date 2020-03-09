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

import java.util.List;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.paths.EightFeet;
import frc.paths.FourFeet;
import frc.paths.GetThreeFromTrench;
import frc.paths.GetTwoFromTrench;
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

    chooser.addOption("Get2TrenchShoot5", "Get2TrenchShoot5");
    chooser.addOption("Shoot3Get3TrenchShoot3", "Shoot3Get3TrenchShoot3");
    chooser.addOption("4FeetTest", "4FeetTest");
    chooser.addOption("6FeetTest", "6FeetTest");
    chooser.addOption("8FeetTest", "8FeetTest");
    chooser.addOption("10FeetTest", "10FeetTest");
    chooser.addOption("12FeetTest", "12FeetTest");

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
    // Create a voltage constraint to ensure we don't accelerate too fast
    var autoVoltageConstraint =
        new DifferentialDriveVoltageConstraint(
            new SimpleMotorFeedforward(Constants.K_S,
                                       Constants.K_V,
                                       Constants.K_A),
            Constants.K_DRIVE_KINEMATICS,
            10);

    // Create config for trajectory
    TrajectoryConfig config =
        new TrajectoryConfig(Constants.K_MAX_SPEED,
                             Constants.K_MAX_ACCEL)
            // Add kinematics to ensure max speed is actually obeyed
            .setKinematics(Constants.K_DRIVE_KINEMATICS)
            // Apply the voltage constraint
            .addConstraint(autoVoltageConstraint);

    // An example trajectory to follow.  All units in meters.
    Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0, 0, new Rotation2d(0)),
        // Pass through these two interior waypoints, making an 's' curve path
        List.of(
            new Translation2d(1, 1),
            new Translation2d(2, -1)
        ),
        // End 3 meters straight ahead of where we started, facing forward
        new Pose2d(3, 0, new Rotation2d(0)),
        // Pass config
        config
    );

    RamseteCommand ramseteCommand = new RamseteCommand(
        exampleTrajectory,
        m_driveTrain::getPose,
        new RamseteController(Constants.K_RAMSETE_B, Constants.K_RAMSETE_ZETA),
        new SimpleMotorFeedforward(Constants.K_S,
                                   Constants.K_V,
                                   Constants.K_A),
        Constants.K_DRIVE_KINEMATICS,
        m_driveTrain::getWheelSpeeds,
        new PIDController(Constants.K_P, 0, 0),
        new PIDController(Constants.K_P, 0, 0),
        // RamseteCommand passes volts to the callback
        m_driveTrain::setDriveVoltage,
        m_driveTrain
    );

    // Run path following command, then stop at the end.
    return ramseteCommand.andThen(() -> m_driveTrain.setDriveVoltage(0, 0));

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

  public void calibrateGyro() {
    m_driveTrain.calibrateADIS();
  }

  public void resetGyro() {
    m_driveTrain.resetADIS();
  }
    
}

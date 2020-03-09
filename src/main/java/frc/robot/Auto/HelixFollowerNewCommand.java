package frc.robot.Auto;

import static com.team319.trajectory.Path.SegmentValue.CENTER_POSITION;
import static com.team319.trajectory.Path.SegmentValue.HEADING;
import static com.team319.trajectory.Path.SegmentValue.LEFT_VELOCITY;
import static com.team319.trajectory.Path.SegmentValue.RIGHT_VELOCITY;

import java.sql.Driver;
import java.util.ArrayList;

import com.team2363.controller.PIDController;
import com.team2363.logger.HelixEvents;
import com.team319.trajectory.Path;
import com.team319.trajectory.Path.SegmentValue;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Framework.Logging.CSVServer;

public abstract class HelixFollowerNewCommand extends CommandBase {
  private Notifier pathNotifier = new Notifier(this::moveToNextSegment);
  private Notifier pidNotifier = new Notifier(this::calculateOutputs);
  
  
  // The trajectories to follow for each side
  public Path trajectory;
  
  private boolean mirror;
  private boolean reverse;

  public int currentSegment;
  private boolean isFinished;

  /**
   * This will import the path class based on the name of the path provided
   * 
   * @param path the name of the path to run
   */
  public HelixFollowerNewCommand(Path path) {
    trajectory = path;
    // Use addRequirements() here to declare subsystem dependencies.
    
  }

  /**
   * A decorator to flip the left and right direction of the path
   * @return the current PathFollower instance
   */

  public HelixFollowerNewCommand mirror() {
    mirror = true;
    return this;
  }

  /**
   * A decorator to run the path with the robot facing backwards
   * @return the current PathFollower instance
   */
  public HelixFollowerNewCommand reverse() {
    reverse = true;
    return this;
  }

  /**
   * Set the current encoder distance to 0
   */
  public abstract void resetDistance();

  /**
   * Get the PID Controller that will be used to correct the heading error during the path
   * 
   * @return the heading PID Controller
   */
  public abstract PIDController getHeadingController();

  /**
   * Get the PID Controller that will be used to correct the heading error during the path
   * 
   * @return the heading PID Controller
   */
  public abstract PIDController getDistanceController();

  /**
   * Get the current robot distance in the units that your path is stored in. 
   * This will typically be an average of both sides of the drivetrain.
   * 
   * @return the current robot distance
   */
  public abstract double getCurrentDistance();

  /**
   * Get the current robot heading in the units that your path is stored in. 
   * This will typically be in radians.
   * 
   * @return the current robot distance
   */
  public abstract double getCurrentHeading();

  /**
   * Use the velocity outputs generated by the path follower.
   * These values will be in the velocity units stored in your path files.
   * @param left the velocity of the left side
   * @param right the velocity of the left side
   */
  public abstract void useOutputs(double left, double right, double unLeft, double unRight);
  
  @Override
  public void initialize() {
    resetDistance();
    //Make sure we're starting at the beginning of the path
    getDistanceController().reset();
    getHeadingController().reset();
    currentSegment = 0;
    isFinished = false;
    
    // Start running the path
    pathNotifier.startPeriodic(trajectory.getValue(0, SegmentValue.TIME_STAMP));
    pidNotifier.startPeriodic(getDistanceController().getPeriod());

    HelixEvents.getInstance().addEvent("HelixFollower", "Starting path: " + trajectory.getClass().getSimpleName());
  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("Distance Path Error", getDistanceController().getError());
    SmartDashboard.putNumber("Heading Path Error", getHeadingController().getError());
  }

  @Override
  public boolean isFinished() {
    return isFinished;
  }

  @Override
  public void end(boolean interrupted) {
    pathNotifier.stop();
    pidNotifier.stop();
    HelixEvents.getInstance().addEvent("HelixFollower", "Finished path: " + trajectory.getClass().getSimpleName());
  }



  private void moveToNextSegment() {
    // Move to the next segment in the path
    currentSegment++;

    // Was that the last segment in our path?
    if (currentSegment >= trajectory.getSegmentCount()) {
      isFinished = true;
    }
  }

  private void calculateOutputs() {
    // We need to get the current segment right away so it doesn't change in the middle
    // of the calculations
    int segment = currentSegment;
    // If we're finished there are no more segments to read from and we should return
    if (segment >= trajectory.getSegmentCount()) {
      return;
    }
    
    // Get our expected velocities based on the paths
    double leftVelocity = trajectory.getValue(segment, mirror ^ reverse ? RIGHT_VELOCITY : LEFT_VELOCITY);
    double rightVelocity = trajectory.getValue(segment, mirror ^ reverse ? LEFT_VELOCITY : RIGHT_VELOCITY);
    
    if (reverse) {
      leftVelocity = -leftVelocity;
      rightVelocity = -rightVelocity;
    }

    // Set our expected position to be the setpoint of our distance controller
    // The position will be an average of both the left and right to give us the overall distance
    double expectedPosition = trajectory.getValue(segment, CENTER_POSITION);
    getDistanceController().setReference(reverse ? -expectedPosition : expectedPosition);
    double currentPosition = getCurrentDistance();
  //  DriverStation.reportError("currentPos" + currentPosition, false);
  //  DriverStation.reportError("expecPos" + expectedPosition, false);
  //  DriverStation.reportError("diffPos" + (expectedPosition-currentPosition), false);
    
    // Set our expected heading to be the setpoint of our direction controller
    double expectedHeading = trajectory.getValue(segment, HEADING);
    // If the path is flipped, invert the sign of the heading
    getHeadingController().setReference(mirror ? -expectedHeading : expectedHeading);
    double currentHeading = getCurrentHeading();

    // The final velocity is going to be a combination of our expected velocity corrected by our distance error and our heading error
    // velocity = expected + distanceError +/- headingError
    double correctedLeftVelocity = leftVelocity + getDistanceController().calculate(currentPosition) - getHeadingController().calculate(currentHeading);
    double correctedRightVelocity = rightVelocity + getDistanceController().calculate(currentPosition) + getHeadingController().calculate(currentHeading);
 
    useOutputs(correctedLeftVelocity, correctedRightVelocity,leftVelocity,rightVelocity);
  }
}

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {

  Joystick leftJoystick;
  Joystick rightJoystick;

  JoystickButton left1, left2, left3, left4;
  JoystickButton right1, right2, right3, right4;

  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

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
    
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    

  }

  public double getSpeed() {
    return leftJoystick.getRawAxis(0);
  }

  public double getTurn() {
    return rightJoystick.getRawAxis(1);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */


  /**
   * 
  public Command getAutonomousCommand() {   //error to be removed later when we have a command to run
    // An ExampleCommand will run in autonomous
  }

  */
}

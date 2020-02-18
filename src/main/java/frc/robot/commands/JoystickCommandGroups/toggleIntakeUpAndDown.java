package frc.robot.commands.JoystickCommandGroups;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.IntakeCommands.grabPowerCells;
import frc.robot.commands.IntakeCommands.stopIntake;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class toggleIntakeUpAndDown extends ParallelCommandGroup {
  /**
   * Creates a new toggleIntakeUpAndDown.
   */
  Intake m_Intake;

  /**
   * @param rcIntake Intake subsystem
   */
  public toggleIntakeUpAndDown( Intake rcIntake ) {

    super();

    DriverStation.reportError("is being called", false);

    m_Intake = rcIntake;

    if( m_Intake.isIntaking() ) {

      DriverStation.reportError( "stopping intake", false );
      addCommands( new stopIntake( rcIntake ) );

    } else {

      DriverStation.reportError( "starting intake", false );
      addCommands( new grabPowerCells( rcIntake ) );

    }
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());super();

  }
}

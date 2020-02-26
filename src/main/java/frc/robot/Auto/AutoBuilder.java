/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Tower;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoBuilder extends SequentialCommandGroup {
  /**
   * Creates a new AutoBuilder.
   */
  public AutoBuilder(Intake intake, Tower tower, Flywheel flywheel, Drivetrain driveTrain, Limelight limelight,String... s) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(generateAutoFromString(intake, tower, flywheel, driveTrain, limelight, s));
  }

  public static CommandGroupBase generateAutoFromString(Intake intake, Tower tower, Flywheel flywheel, Drivetrain driveTrain, Limelight limelight,String... s) {
    
    for(int i =0; i < s.length;i++){
      boolean pathShouldContinue = false;
      boolean pathIsReversed = false;
      if(s[i].contains("shoot")){
        
      }else{
        for(int j = i; j>=0;j--){

        }
      }
    }
    return null;
  }
}

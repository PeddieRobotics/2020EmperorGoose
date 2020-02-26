/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.JoystickCommands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.FlywheelCommands.ShootFromFar;
import frc.robot.commands.FlywheelCommands.StartFlywheel;
import frc.robot.commands.HopperCommands.StopHopper;
import frc.robot.commands.TowerCommands.RunTowerBasedOffFlyWheel;
import frc.robot.commands.TowerCommands.StopTower;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Flywheel;
import frc.robot.subsystems.Tower;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class ShootFlywheel extends SequentialCommandGroup {

  private Tower m_tower;
  private Flywheel m_flywheel;
  private Hopper m_hopper;
  Drivetrain m_driveTrain;
  public ShootFlywheel(Tower tower, Flywheel flywheel, Hopper hopper, Drivetrain driveTrain, Limelight limelight, double rpm) {
    
     //have drive train incase we wanna stop it 
    super(new ParallelCommandGroup(new ShootFromFar(flywheel, rpm,false), 
    new RunTowerBasedOffFlyWheel(hopper, tower, flywheel, limelight)), 
    new ParallelRaceGroup( new WaitCommand(1), new ShootFromFar(flywheel,rpm,true)));
    
    m_driveTrain = driveTrain;
    m_tower = tower;
    m_flywheel = flywheel;
    m_hopper = hopper;

    addRequirements(m_flywheel);
    addRequirements(m_hopper);
    addRequirements(m_tower);
  }
  public ShootFlywheel(Tower tower, Flywheel flywheel, Hopper hopper, Limelight limelight, double rpm){
    super(new ParallelCommandGroup(new ShootFromFar(flywheel, rpm,false), 
    new RunTowerBasedOffFlyWheel(hopper, tower, flywheel, limelight)), 
    new ParallelRaceGroup( new WaitCommand(1), new ShootFromFar(flywheel,rpm,true)));
      
      m_tower = tower;
      m_flywheel = flywheel;
      m_hopper = hopper;
    addRequirements(m_flywheel);
    addRequirements(m_hopper);
    addRequirements(m_tower);
  }
}

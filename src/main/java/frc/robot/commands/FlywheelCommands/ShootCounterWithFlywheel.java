/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.FlywheelCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.LinearRegression;
import frc.robot.subsystems.Flywheel;


public class ShootCounterWithFlywheel extends CommandBase {
  /**
   * Creates a new ShootCounterWithFlywheel.
   */

  Flywheel m_flywheel;
  int counter;
  double slope;
  LinearRegression linearRegression;
  int shotsToFire;
  double prevShotTime;

  public ShootCounterWithFlywheel(Flywheel f, int shotCount) {
    m_flywheel = f;
    shotsToFire = shotCount;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    counter = 0;
    prevShotTime = 0.0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //linearRegression = new LinearRegression(m_flywheel.getFlywheelX(),m_flywheel.getFlywheelSpeeds());
    //slope = linearRegression.slope();
    slope = (m_flywheel.getFlywheelSpeeds()[2]-m_flywheel.getFlywheelSpeeds()[0])/3.0;
    SmartDashboard.putNumber("Slope", slope);
    SmartDashboard.putNumber("Velocity", m_flywheel.getFlywheelSpeeds()[2]);
    double currentTime = Timer.getFPGATimestamp();
    if(slope < -2 && currentTime-prevShotTime >= 0.5){
      prevShotTime = currentTime;
      counter++;
    }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putNumber("ShotCount", counter);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return counter >= shotsToFire;
  }
}

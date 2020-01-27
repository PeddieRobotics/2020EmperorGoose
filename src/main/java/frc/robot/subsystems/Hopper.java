package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hopper extends SubsystemBase {

  private static enum Hopper_Mode_Type {
    INTAKING, DISABLED
  }

  private Hopper_Mode_Type mode;


  public Hopper() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    switch( mode )
    {

      case INTAKING:

      break;

      case DISABLED:

      break;

    }
  }
}

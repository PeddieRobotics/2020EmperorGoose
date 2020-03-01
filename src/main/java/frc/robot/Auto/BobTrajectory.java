package frc.robot.Auto;

import com.team319.trajectory.RobotConfig;
import com.team319.ui.BobTrajectoryApp;

public class BobTrajectory {
      
    public static void main(String... args) {
        RobotConfig.dt = 0.02;//we wanna gen. paths at 200hz(dt is in seconds, so this is a 5ms execute)
        new BobTrajectoryApp();
    }
}
package frc.robot;

import com.team319.trajectory.RobotConfig;
import com.team319.ui.BobTrajectoryApp;

public class BobTrajectory {
    public static void main(String... args) {
        RobotConfig.dt = 0.005;
        new BobTrajectoryApp();
    }
}
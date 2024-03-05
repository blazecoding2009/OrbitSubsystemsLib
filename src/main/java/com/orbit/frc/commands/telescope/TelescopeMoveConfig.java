package com.orbit.frc.commands.telescope;

import edu.wpi.first.math.trajectory.TrapezoidProfile;

import com.orbit.frc.util.OrbitPID;
import com.orbit.frc.subsystems.pivot.Telescope;

public class TelescopeMoveConfig {
    public Telescope pivot;

    public double maxVel, maxAccel;
    public TrapezoidProfile.Constraints motionProfileConstraints; 

    // PIDF controllers
    public OrbitPID pid;
}

package com.orbit.frc.commands.telescope;

import edu.wpi.first.math.trajectory.TrapezoidProfile;

import com.orbit.frc.util.OrbitPID;
import com.orbit.frc.subsystems.telescope.Telescope;

/* Configuration for a TelescopeMove command */
public class TelescopeMoveConfig {
    /* The Telescope to use */
    public Telescope telescope;

    /* Maximum velocity and acceleration during the movement */
    public double maxVel, maxAccel;
    /* Trapezoidal motion profile constraints */
    public TrapezoidProfile.Constraints motionProfileConstraints; 

    /* PID controller to use */
    public OrbitPID pid;
}

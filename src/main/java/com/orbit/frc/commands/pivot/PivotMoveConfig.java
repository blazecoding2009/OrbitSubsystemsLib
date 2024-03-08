package com.orbit.frc.commands.pivot;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.controller.ArmFeedforward;

import com.orbit.frc.util.OrbitPID;
import com.orbit.frc.subsystems.pivot.Pivot;

/* Configuration for a PivotMove command */ 
public class PivotMoveConfig {
    /* The pivot to control */
    public Pivot pivot;

    /* Maximum velocity and acceleration during the movement */
    public double maxVel, maxAccel;
    /* Trapezoidal motion profile constraints */
    public TrapezoidProfile.Constraints motionProfileConstraints; 

    /* PID controller to use */
    public OrbitPID pid;
    /* Feedforward controller to use */
    public ArmFeedforward feedForward;  
}

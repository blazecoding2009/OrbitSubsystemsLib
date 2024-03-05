package com.orbit.frc.commands.pivot;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.controller.ArmFeedforward;

import com.orbit.frc.util.OrbitPID;
import com.orbit.frc.subsystems.pivot.Pivot;

public class PivotMoveConfig {
    public Pivot pivot;

    public double maxVel, maxAccel;
    public TrapezoidProfile.Constraints motionProfileConstraints; 

    // PIDF controllers
    public OrbitPID pid;
    public ArmFeedforward feedForward;  
}

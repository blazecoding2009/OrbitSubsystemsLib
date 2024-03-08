package com.orbit.frc.commands.flywheels;

import com.orbit.frc.subsystems.flywheels.Flywheels;
import com.orbit.frc.util.OrbitPID;

/* Configuration for a SpinFlywheels command */
public class SpinFlywheelsConfig {
    /* The flywheels to control */
    public Flywheels flywheels;

    /* The PID controller to use */
    public OrbitPID[] pid;
}

package com.orbit.frc.subsystems.pivot;

import edu.wpi.first.wpilibj.AnalogEncoder;

import com.orbit.frc.subsystems.SubsystemConfig;

/* Configuration for a Pivot subsystem */
public class PivotConfig extends SubsystemConfig {
    /* Absolute encoder port */
    public int encoderPort;
    /* Constant value added to encoder output as an offset */
    public double encoderOffset;
    /* The absolute encoder on the output shaft */
    public AnalogEncoder absoluteEncoder;
}

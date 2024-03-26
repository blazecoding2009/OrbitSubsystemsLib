package com.orbit.frc.subsystems.pivot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/* Subsystem representing a pivoting arm */
public class Pivot extends SubsystemBase {
    /* The configuration class for this subsystem */
    private final PivotConfig config;

    /* Create a new Pivot with the given configuration */
    public Pivot(PivotConfig config) {
        this.config = config;
        this.resetEncoder();
    }

    /* Set motor output voltage directly */
    public void setVoltage(double v) {
        config.motors[0].setVoltage(v);
    }

    /* Set motor output voltage as fraction of 12.0 V */
    public void setNormalizedVoltage(double v) {
        setVoltage(v * 12.0);
    }

    /* Get output shaft position in rotations */
    public double getPositionRotations() {
        return config.motors[0].getEncoder().getPosition() - config.encoderOffset;
    }

    /* Get output shaft position in degrees */
    public double getPositionDegrees() {
        return getPositionRotations() * 360.0;
    }
    
    /* Get output shaft angluar velocity in RPM */
    public double getVelocityRPM() {
        return config.motors[0].getEncoder().getVelocity();
    }
    
    /* Set the encoder offset to be wherever the pivot is right now */
    public void resetEncoder() {
        double newPosition = config.absoluteEncoder.get() - config.encoderOffset;
        config.motors[0].getEncoder().setPosition(newPosition);
    }
}

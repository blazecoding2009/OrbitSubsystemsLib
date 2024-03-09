package com.orbit.frc.subsystems.telescope;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Telescope extends SubsystemBase {
    private final TelescopeConfig config;

    public Telescope(TelescopeConfig config) {
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

    public double getPositionRotations() {
        return config.motors[0].getEncoder().getPosition() - config.encoderOffset;
    }

    public double getPositionDegrees() {
        return getPositionRotations() * 360.0;
    }
    
    public double getVelocityRotations() {
        return config.motors[0].getEncoder().getVelocity();
    }

    public double getVelocityDegrees() {
        return getVelocityRotations() * 360.0;
    }

    public boolean getLimitSwitch() {
        // XOR to easily invert the result
        return config.limitSwitch.get() ^ config.limitSwitchInverted;
    }

    /* Set the encoder offset to be wherever the pivot is right now */
    public void resetEncoder() {
        config.motors[0].getEncoder().setPosition(0);
    }
}

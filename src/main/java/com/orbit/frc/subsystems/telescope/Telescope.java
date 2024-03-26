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

    /* Get the extended distance of the telescope, in meters */
    public double getPositionMeters() {
        return config.motors[0].getEncoder().getPosition();
    }
    
    /* Get the velocity of the telescope, in meters per second */
    public double getVelocityMeters() {
        return config.motors[0].getEncoder().getVelocity();
    }

    /* Get the state of the limit switch, inverted if needed */
    public boolean getLimitSwitch() {
        // XOR to easily invert the result
        return config.limitSwitch.get() ^ config.limitSwitchInverted;
    }

    /* Set the encoder offset based on the absolute encoder offset, if there is one */
    public void resetEncoder() {
        double newPosition = config.absoluteEncoder.get() - config.encoderOffset;
        config.motors[0].getEncoder().setPosition(newPosition);
    }
}

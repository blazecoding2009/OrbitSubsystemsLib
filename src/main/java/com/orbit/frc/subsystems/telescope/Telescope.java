package com.orbit.frc.subsystems.telescope;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Telescope extends SubsystemBase {
    private final TelescopeConfig config;

    public Telescope(TelescopeConfig config) {
        this.config = config;

        config.motors[0].getEncoder().setPositionConversionFactor(config.gearRatio);
        config.motors[0].getEncoder().setVelocityConversionFactor(config.gearRatio);
    }

    /* Set voltage directly */
    public void setVoltage(double v) {
        config.motors[0].setVoltage(v);
    }

    /* Set voltage as fraction of 12.0 V */
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

    public double getLimitSwitch() {
        // XOR to easily invert the result
        return config.limitSwitch.get() ^ config.limitSwitchInverted;
    }
}

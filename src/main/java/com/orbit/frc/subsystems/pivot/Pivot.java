package com.orbit.frc.subsystems.pivot;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.orbit.frc.util.OrbitPID;

public class Pivot extends SubsystemBase {
    private final PivotConfig config;

    // We keep this separate from configuration because it'd be annoying to make separate configurations for each setpoint
    private final double targetAngle;
    
    // Motion outputs & calculation stuff
    private double angularVelocity, lastAngle;
    private long lastTime;

    private boolean moving;

    public Pivot(PivotConfig config, double target) {
        this.config = config;
        this.targetAngle = target;

        config.motors[0].getEncoder().setPositionConversionFactor(config.gearRatio);
        config.motors[0].getEncoder().setVelocityConversionFactor(config.gearRatio);

        this.resetEncoder();
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
    
    /* Set the encoder offset to be wherever the pivot is right now */
    public void resetEncoder() {
        double newPosition = config.absoluteEncoder.get() - config.encoderOffset;
        config.motors[0].getEncoder().setPosition(newPosition);
    }
}

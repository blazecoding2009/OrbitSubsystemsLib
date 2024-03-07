package com.orbit.frc.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private final IntakeConfig config;

    public Intake(IntakeConfig config) {
        this.config = config;
    }

    public void setVoltage(double v) {
        this.config.motors[0].setVoltage(v);
    }

    public void setNormalizedVoltage(double v) {
        setVoltage(v * 12.0);
    }

    // get linear velocity of the flywheels in meters per second
    public double getLinearVelocity() {
        // multiply speed in rpm by circumference, and divide by 60 seconds in a minute
        return this.config.motors[0].getEncoder().getVelocity() * (2.0 * config.wheelRadius * 3.1415) / 60.0;
    }
}

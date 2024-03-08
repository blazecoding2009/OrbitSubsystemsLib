package com.orbit.frc.subsystems.intake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/* Subsystem representing an intake with rollers or wheels */
public class Intake extends SubsystemBase {
    /* The configuration for this subsystem */
    private final IntakeConfig config;

    /* Create a new intake from a configuration */
    public Intake(IntakeConfig config) {
        this.config = config;
    }

    /* Set the output voltage of all motors in the intake */
    public void setVoltage(double v) {
        this.config.motors[0].setVoltage(v);
    }

    /* Set the output voltage of all motors in the intake as a fraction of 12.0 V */
    public void setNormalizedVoltage(double v) {
        setVoltage(v * 12.0);
    }

    /* Get the linear velocity of the intake wheels in m/s */
    public double getLinearVelocity() {
        // multiply speed in rpm by circumference, and divide by 60 seconds in a minute
        return this.config.motors[0].getEncoder().getVelocity() * (2.0 * config.wheelRadius * 3.1415) / 60.0;
    }
}

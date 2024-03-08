package com.orbit.frc.subsystems.flywheels;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

/* Subsystem representing a set of flywheels used to shoot game pieces */
public class Flywheels extends SubsystemBase {

    /* The configuration class for this subsystem */
    private final FlywheelConfig config;

    /* Create a new Flywheels subsystem from a given configuration */
    public Flywheels(FlywheelConfig config) {
        this.config = config;
    }

    /* Get the number of motors in this subsystem */
    public int getMotorCount() {
        return config.motors.length;
    }

    /* Set the output voltage of the motor at index i in the subsystem */
    public void setVoltage(int i, double v) {
        config.motors[i].setVoltage(v);
    }

    /* Set the output voltage of the motor at index i in the subsystem as fraction of 12.0 V */
    public void setNormalizedVoltage(int i, double v) {
        setVoltage(i, v * 12.0);
    }
    
    /* Get the velocity of the motor at index i in RPM */
    public double getVelocityRPM(int i) {
        return config.motors[i].getEncoder().getVelocity();
    }
}

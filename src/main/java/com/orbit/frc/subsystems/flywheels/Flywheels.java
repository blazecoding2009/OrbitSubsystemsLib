package com.orbit.frc.subsystems.flywheels;

import com.revrobotics.CANSparkBase;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheels extends SubsystemBase {
    private final FlywheelConfig config;

    public Flywheels(FlywheelConfig config) {
        this.config = config;

        for(CANSparkBase motor : config.motors) {
            motor.getEncoder().setVelocityConversionFactor(config.gearRatio);
        }
    }

    public int getMotorCount() {
        return config.motors.length;
    }

    /* Set voltage directly */
    public void setVoltage(int i, double v) {
        config.motors[i].setVoltage(v);
    }

    /* Set voltage as fraction of 12.0 V */
    public void setNormalizedVoltage(int i, double v) {
        setVoltage(i, v * 12.0);
    }
    
    public double getVelocityRotations(int i) {
        return config.motors[i].getEncoder().getVelocity();
    }

    public double getVelocityDegrees(int i) {
        return getVelocityRotations(i) * 360.0;
    }
}

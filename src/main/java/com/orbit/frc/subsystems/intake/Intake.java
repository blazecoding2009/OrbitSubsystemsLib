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
}

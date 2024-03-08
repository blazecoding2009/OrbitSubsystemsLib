package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.subsystems.intake.Intake;

public class IntakeUntilStop extends IntakeCommand {
    private IntakeUntilStopConfig config;

    private double speed;

    public IntakeUntilStop(IntakeUntilStopConfig config, double speed) {
        super(config, speed);
        this.config = config;
        this.speed = speed;
    }

    @Override
    public boolean isFinished() {
        return this.config.stop.getAsBoolean() ^ this.config.stopInvert;
    }
}

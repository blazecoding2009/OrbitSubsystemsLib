package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.subsystems.intake.Intake;

public class IntakeUntilStop extends Command {
    private IntakeUntilStopConfig config;

    private double speed;

    public IntakeUntilStop(IntakeUntilStopConfig config, double speed) {
        this.config = config;
        this.speed = speed;
        addRequirements(config.intake);
    }

    @Override
    public void execute() {
        this.config.intake.setNormalizedVoltage(speed);
    }

    @Override
    public boolean isFinished() {
        return this.config.stop.getAsBoolean() ^ this.config.stopInvert;
    }

    @Override
    public void end(boolean interrupted) {
        this.config.intake.setNormalizedVoltage(0.0);
    }
}

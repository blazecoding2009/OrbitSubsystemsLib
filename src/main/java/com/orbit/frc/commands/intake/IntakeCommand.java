package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.subsystems.intake.Intake;

public class IntakeCommand extends Command {
    private IntakeCommandConfig config;
    protected double speed; // we keep this separate from the config to avoid making 5 billion configs for each speed u want
    
    public IntakeCommand(IntakeCommandConfig config, double speed) {
        this.config = config;
        this.speed = speed;
        addRequirements(config.intake);
    }

    @Override
    public void execute() {
        this.config.intake.setNormalizedVoltage(speed);
    }

    @Override
    public void end(boolean interrupted) {
        this.config.intake.setNormalizedVoltage(0.0);
    }
}

package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.subsystems.intake.Intake;

public class IntakeUntilStop extends IntakeCommand {
    private IntakeUntilStopConfig config;

    public IntakeUntilStop(IntakeUntilStopConfig config, double speed) {
        super(config, speed);
        this.config = config;
    }

    @Override
    public boolean isFinished() {
        return this.config.stop.getAsBoolean() ^ this.config.stopInvert;
    }
}

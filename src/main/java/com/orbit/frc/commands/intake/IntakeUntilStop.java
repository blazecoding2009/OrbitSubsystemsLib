package com.orbit.frc.commands.intake;

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

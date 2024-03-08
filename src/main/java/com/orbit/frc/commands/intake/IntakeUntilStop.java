package com.orbit.frc.commands.intake;

/* Command to intake until a BooleanSupplier is triggered, at which point it stops */
public class IntakeUntilStop extends IntakeCommand {
    /* The configuration class for this command */
    private IntakeUntilStopConfig config;

    /* Create a new IntakeUntilStop with a give config and speed */ 
    public IntakeUntilStop(IntakeUntilStopConfig config, double speed) {
        super(config, speed);
        this.config = config;
    }

    @Override
    public boolean isFinished() {
        return this.config.stop.getAsBoolean() ^ this.config.stopInvert;
    }
}

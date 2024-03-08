package com.orbit.frc.commands.intake;

/* Command that instakes at a given linear speed until a BooleanSupplier is triggered, at which point it stops */
public class IntakeLinearSpeedUntilStop extends IntakeLinearSpeed {
    /* The configuration class for this command */
    private IntakeLinearSpeedUntilStopConfig config;
   
    /* Create a new IntakeLinearSpeedUntilStop with a given config and speen in m/s */
    public IntakeLinearSpeedUntilStop(IntakeLinearSpeedUntilStopConfig config, double speed) {
        super(config, speed);
        this.config = config;
    }

    @Override
    public boolean isFinished() {
        return this.config.stop.getAsBoolean() ^ this.config.stopInvert;
    }
}

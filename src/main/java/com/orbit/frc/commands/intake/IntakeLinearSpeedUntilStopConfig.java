package com.orbit.frc.commands.intake;

import java.util.function.BooleanSupplier;

/* Configuration class for an IntakeLinearSpeedUntilStop command */
public class IntakeLinearSpeedUntilStopConfig extends IntakeLinearSpeedConfig {
    /* The BooleanSupplier that will trigger the stop */
    public BooleanSupplier stop;
    /* Whether or not to invert the stop condition */
    public boolean stopInvert;
}

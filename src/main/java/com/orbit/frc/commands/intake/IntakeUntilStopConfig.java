package com.orbit.frc.commands.intake;

import java.util.function.BooleanSupplier;

/* Configuration for an IntakeUntilStop command */
public class IntakeUntilStopConfig extends IntakeCommandConfig {
    /* The BooleanSupplier that will trigger the stop */
    public BooleanSupplier stop;
    /* Whether or not to invert the stop condition */
    public boolean stopInvert;
}

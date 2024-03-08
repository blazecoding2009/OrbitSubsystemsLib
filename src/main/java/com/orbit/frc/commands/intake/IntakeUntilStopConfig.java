package com.orbit.frc.commands.intake;

import java.util.function.BooleanSupplier;

public class IntakeUntilStopConfig extends IntakeCommandConfig {
    public BooleanSupplier stop;
    public boolean stopInvert;
}

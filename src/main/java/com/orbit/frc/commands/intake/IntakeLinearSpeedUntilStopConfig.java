package com.orbit.frc.commands.intake;

import java.util.function.BooleanSupplier;

public class IntakeLinearSpeedUntilStopConfig extends IntakeLinearSpeedConfig {
    public BooleanSupplier stop;
    public boolean stopInvert;
}

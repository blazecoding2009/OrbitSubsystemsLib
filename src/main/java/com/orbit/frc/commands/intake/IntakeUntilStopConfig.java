package com.orbit.frc.commands.intake;

import java.util.function.BooleanSupplier;

import com.orbit.frc.subsystems.intake.Intake;

public class IntakeUntilStopConfig {
    public Intake intake;

    public BooleanSupplier stop;
    public boolean stopInvert;
}

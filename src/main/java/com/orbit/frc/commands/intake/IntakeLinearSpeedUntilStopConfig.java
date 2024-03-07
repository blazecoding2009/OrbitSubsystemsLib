package com.orbit.frc.commands.intake;

import java.util.function.BooleanSupplier;

import com.orbit.frc.subsystems.intake.Intake;
import com.orbit.frc.util.OrbitPID;

public class IntakeLinearSpeedUntilStopConfig {
    public Intake intake;

    public OrbitPID pid;
    public BooleanSupplier stop;
    public boolean stopInvert;
}

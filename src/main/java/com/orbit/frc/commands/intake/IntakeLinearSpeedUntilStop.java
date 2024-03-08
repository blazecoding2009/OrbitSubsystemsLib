package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.util.OrbitPID;

/* Command that spins a set of flywheels at certain speeds using PID controllers
 * TODO: Maybe mod this to use intergrated PID on the SparkX controllers later
 */
public class IntakeLinearSpeedUntilStop extends IntakeLinearSpeed {

    private IntakeLinearSpeedUntilStopConfig config;

    // this changes often between commands for the same flywheels, let it be separate
    private double speed;
    
    public IntakeLinearSpeedUntilStop(IntakeLinearSpeedUntilStopConfig config, double speed) {
        super(config, speed);
        this.config = config;
        this.speed = speed;
    }

    @Override
    public boolean isFinished() {
        return this.config.stop.getAsBoolean() ^ this.config.stopInvert;
    }
}

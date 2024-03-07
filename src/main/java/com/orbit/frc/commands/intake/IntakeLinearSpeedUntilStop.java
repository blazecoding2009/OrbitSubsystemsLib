package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.util.OrbitPID;

/* Command that spins a set of flywheels at certain speeds using PID controllers
 * TODO: Maybe mod this to use intergrated PID on the SparkX controllers later
 */
public class IntakeLinearSpeedUntilStop extends Command {

    private IntakeLinearSpeedUntilStopConfig config;

    // this changes often between commands for the same flywheels, let it be separate
    private double speed;
    
    public IntakeLinearSpeedUntilStop(IntakeLinearSpeedUntilStopConfig config, double... speeds) {
        this.config = config;
        this.speed = speed;
        addRequirements(config.intake);
    }

    @Override
    public void initialize() {
        this.config.pid.reset();
    }

    @Override
    public void execute() {
        double input = this.config.intake.getLinearVelocity();
        double output = this.config.pid.calculate(speed, input);
        this.config.intake.setNormalizedVoltage(output);
    }

    @Override
    public boolean isFinished() {
        return this.config.stop.getAsBoolean() ^ this.config.stopInvert;
    }


    @Override
    public void end(boolean interrupted) {
        this.config.intake.setNormalizedVoltage(0.0);
    }
}

package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.util.OrbitPID;

/* Command that spins a set of flywheels at certain speeds using PID controllers
 * TODO: Maybe mod this to use intergrated PID on the SparkX controllers later
 */
public class IntakeLinearSpeed extends IntakeCommand {
    private IntakeLinearSpeedConfig config;

    public IntakeLinearSpeed(IntakeLinearSpeedConfig config, double speed) {
        super(config, speed);
        this.config = config;
    }

    @Override
    public void initialize() {
        this.config.pid.reset();
    }

    @Override
    public void execute() {
        double input = this.config.intake.getLinearVelocity();
        double output = this.config.pid.calculate(this.speed, input);
        this.config.intake.setNormalizedVoltage(output);
    }
}

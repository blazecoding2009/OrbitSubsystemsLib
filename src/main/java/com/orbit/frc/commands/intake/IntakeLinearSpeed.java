package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.util.OrbitPID;

/* Command that spins a set of flywheels at certain speeds using PID controllers
 * TODO: Maybe mod this to use intergrated PID on the SparkX controllers later
 */
public class IntakeLinearSpeed extends Command {

    private IntakeLinearSpeedConfig config;

    // this changes often between commands for the same flywheels, let it be separate
    private double speed;
    
    public IntakeLinearSpeed(IntakeLinearSpeedConfig config, double... speeds) {
        this.config = config;
        this.speed = speed;
        addRequirements(config.flywheels);
    }

    @Override
    public void initialize() {
        config.pid.reset();
    }

    @Override
    public void execute() {
        double input = config.intake.getLinearVelocity();
        double output = config.pid.calculate(speed, input);
        config.intake.setNormalizedVoltage(output);
    }
}

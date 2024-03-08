package com.orbit.frc.commands.flywheels;

import java.lang.IllegalArgumentException;

import edu.wpi.first.wpilibj2.command.Command;

/* Command to spin a set of flywheels at certain speeds using PID controllers
 * TODO: Maybe mod this to use intergrated PID on the SparkX controllers later
 */
public class SpinFlywheels extends Command {

    /* The configuration class for this command */ 
    private SpinFlywheelsConfig config;

    /* The target speeds for each flywheel in the subsystem in RPM*/ 
    private double[] speeds;

    /* The tolerance range for checking when the flywheels are ready to shoot */
    private double tolerance;

    /* Create a new SpinFlywheels command with a given configuration, tolerance, and set of speeds */
    public SpinFlywheels(SpinFlywheelsConfig config, double tolerance, double... speeds) {
        if(!(config.flywheels.getMotorCount() == config.pid.length && config.pid.length == speeds.length)) { 
            throw new IllegalArgumentException("The number of flywheels, PID controllers and speeds must be identical");
        }
        this.config = config;
        this.tolerance = tolerance;
        this.speeds = speeds;
        addRequirements(config.flywheels);
    }

    @Override
    public void initialize() {
        for(int i = 0; i < config.flywheels.getMotorCount(); i++) config.pid[i].reset();
    }

    @Override
    public void execute() {
       for(int i = 0; i < config.flywheels.getMotorCount(); i++) {
           double input = config.flywheels.getVelocityRPM(i);
           double output = config.pid[i].calculate(speeds[i], input);
           config.flywheels.setNormalizedVoltage(i, output);
       }
    }

    /* Check to see if all flywheel speeds are within tolerance for firing */
    public boolean ready() {
        for(int i = 0; i < config.flywheels.getMotorCount(); i++) {
            if(Math.abs(config.flywheels.getVelocityRPM(i) - speeds[i]) > tolerance)
                return false;
        }
        return true;
    }
}

package com.orbit.frc.commands.flywheels;

import java.lang.IllegalArgumentException;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.controller.ArmFeedforward;

import com.orbit.frc.subsystems.flywheels.Flywheels;
import com.orbit.frc.util.OrbitTimer;
import com.orbit.frc.util.OrbitPID;

/* Command that spins a set of flywheels at certain speeds using PID controllers
 * TODO: Maybe mod this to use intergrated PID on the SparkX controllers later
 */
public class SpinFlywheels extends Command {

    private SpinFlywheelsConfig config;

    // these two might change often between commands for the same flywheels, let it be separate
    private double[] speeds;
    private double tolerance; // tolerance array is probably not something we need right

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

    // Check if the flywheels are ready for firing
    public boolean ready() {
        for(int i = 0; i < config.flywheels.getMotorCount(); i++) {
            if(Math.abs(config.flywheels.getVelocityRPM(i) - speeds[i]) > tolerance)
                return false;
        }
        return true;
    }
}

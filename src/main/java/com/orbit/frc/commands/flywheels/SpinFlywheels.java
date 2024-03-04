package com.orbit.frc.commands.flywheels;

import java.lang.IllegalArgumentException;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.controller.ArmFeedforward;

import com.orbit.frc.subsystems.pivot.Pivot;
import com.orbit.frc.util.OrbitTimer;
import com.orbit.frc.util.OrbitPID;

/* Command that spins a set of flywheels at certain speeds using PID controllers
 * TODO: Maybe mod this to use intergrated PID on the SparkX controllers later
 */
public class SpinFlywheels extends Command {

    private SpinFlywheelsConfig config;

    // this changes often between commands for the same flywheels, let it be separate
    private double[] targets;
    
    public SpinFlywheels(SpinFlywheelsConfig config, double... speeds) {
        if(!(config.flywheels.getMotorCount() == config.pid.length && config.pid.length == speeds.length)) 
            throw IllegalArgumentException("The number of flywheels, PID controllers and speeds must be identical");
        this.config = config;
        this.targets = speeds;
        addRequirements(config.flywheels);
    }

    @Override
    public void initialize() {
        for(int i = 0; i < config.flywheels.getMotorCount(); i++) config.pid[i].reset();
    }

    @Override
    public void execute() {
       for(int i = 0; i < config.flywheels.getMotorCount(); i++) {
           double input = config.flywheels.getVelocityRotations(i);
           double output = config.pid[i].calculate(targets[i], input);
           config.flywheels.setNormalizedVoltage(i, output);
       }
    }
}

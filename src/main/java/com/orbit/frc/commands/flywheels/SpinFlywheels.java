package com.orbit.frc.commands.flywheels;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.math.controller.ArmFeedforward;

import com.orbit.frc.subsystems.pivot.Pivot;
import com.orbit.frc.util.OrbitTimer;
import com.orbit.frc.util.OrbitPID;

public class SpinFlywheels extends Command {

    private SpinFlywheelsConfig config;

    // this changes often between commands for the same flywheels, let it be separate
    private double[] targets;
    
    public PivotMove(PivotMoveConfig config, double... speeds) {
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

package com.orbit.frc.commands.pivot;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.util.OrbitTimer;

public class PivotMove extends Command {
    private PivotMoveConfig config;

    // this changes often between commands for the same pivot, let it be separate
    private double targetAngle;

    // interal motion profile state
    private TrapezoidProfile motionProfile;
    private TrapezoidProfile.State startState;
    private TrapezoidProfile.State endState;

    // timing for motion profile
    private OrbitTimer timer;

    // internal calculation vars
    private double target, input, pidOutput;
    
    public PivotMove(PivotMoveConfig config, double angle) {
        this.config = config;
        this.target = angle;

        this.timer = new OrbitTimer();
        addRequirements(config.pivot);
    }

    @Override
    public void initialize() {
        config.pid.reset();
        
        this.startState = new TrapezoidProfile.State(config.pivot.getPositionDegrees(), 0.0);
        this.endState = new TrapezoidProfile.State(this.target, 0.0);

        this.motionProfile = new TrapezoidProfile(config.motionProfileConstraints);

        this.timer.start();
    }

    @Override
    public void execute() {
        TrapezoidProfile.State profileTarget = 
            motionProfile.calculate(
                this.timer.getTimeDeltaSec(),
            	this.startState, this.endState
            );
	
        target = profileTarget.position;
        input = config.pivot.getPositionDegrees();
        pidOutput = config.pid.calculate(target, input);
        config.pivot.setNormalizedVoltage(pidOutput);
    }

    @Override
    public boolean isFinished() {
        return this.motionProfile.isFinished(this.timer.getTimeDeltaSec());
    }

    @Override
    public void end(boolean interrupted) {
        SmartDashboard.putNumber("Shoulder_Move_Time", this.timer.getTimeDeltaSec());
        config.pivot.setVoltage(0.0); // stop
    }
}

package com.orbit.frc.commands.pivot;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.util.OrbitTimer;

/* Command to move a pivot to a given position using a trapezoidal motion profile */
public class PivotMove extends Command {
    /* The configuration class for this command */
    private PivotMoveConfig config;

    /* The end goal of this movement */
    private double targetAngle;

    /* Trapezoidal motion profile to be used */ 
    private TrapezoidProfile motionProfile;
    
    /* The start and end states of the motion, calculated on initialization */
    private TrapezoidProfile.State startState, endState;

    /* Timer to follow the motion profile */
    private OrbitTimer timer;

    /* Create a new PivotMove to the given angle using the given configuration 
     * @param config The configuration to be used for the command
     * @param angle The target angle for the command
     */
    public PivotMove(PivotMoveConfig config, double angle) {
        this.config = config;
        this.targetAngle = angle;

        this.timer = new OrbitTimer();
        addRequirements(config.pivot);
    }

    @Override
    public void initialize() {
        config.pid.reset();
        
        this.startState = new TrapezoidProfile.State(config.pivot.getPositionDegrees(), 0.0);
        this.endState = new TrapezoidProfile.State(this.targetAngle, 0.0);

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
	
        double target = profileTarget.position;
        double input = config.pivot.getPositionDegrees();
        double pidOutput = config.pid.calculate(target, input);
        config.pivot.setNormalizedVoltage(pidOutput);
    }

    @Override
    public boolean isFinished() {
        return this.motionProfile.isFinished(this.timer.getTimeDeltaSec());
    }

    @Override
    public void end(boolean interrupted) {
        config.pivot.setVoltage(0.0); // stop
    }
}

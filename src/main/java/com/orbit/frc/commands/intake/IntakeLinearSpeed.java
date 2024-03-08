package com.orbit.frc.commands.intake;

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

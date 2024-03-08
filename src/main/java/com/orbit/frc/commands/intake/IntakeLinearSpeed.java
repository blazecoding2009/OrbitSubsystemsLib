package com.orbit.frc.commands.intake;

/* Command to intake at a set linear speed in m/s */
public class IntakeLinearSpeed extends IntakeCommand {
    /* The configuration class for this command */
    private IntakeLinearSpeedConfig config;

    /* Create a new IntakeLinearSpeed with a given config and speed, in m/s */
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

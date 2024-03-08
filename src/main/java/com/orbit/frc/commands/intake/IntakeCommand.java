package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

/* Base command for intaking
 * Spins wheels at a set speed
 * Inherit from this for other intake commands
 */
public class IntakeCommand extends Command {
    /* The configuration class for this command */
    private IntakeCommandConfig config;

    /* The speed to spin the wheels at. Must be from -1.0 to 1.0 */
    protected double speed; 

    /* Create a new IntakeCommand with a given config and speed
     */
    public IntakeCommand(IntakeCommandConfig config, double speed) {
        this.config = config;
        this.speed = speed;
        addRequirements(config.intake);
    }

    @Override
    public void execute() {
        this.config.intake.setNormalizedVoltage(speed);
    }

    @Override
    public void end(boolean interrupted) {
        this.config.intake.setNormalizedVoltage(0.0);
    }
}

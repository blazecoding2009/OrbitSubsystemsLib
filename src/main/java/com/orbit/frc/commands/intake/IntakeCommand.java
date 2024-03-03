package com.orbit.frc.commands.intake;

import edu.wpi.first.wpilibj2.command.Command;

import com.orbit.frc.subsystems.intake.Intake;

public class IntakeCommand extends Command {
    private Intake intake;
    private double speed;

    public IntakeCommand(Intake intake, double speed) {
        this.intake = intake;
        this.speed = speed;
    }

    @Override
    public void execute() {
        this.intake.setNormalizedVoltage(speed);
    }

    @Override
    public void end(boolean interrupted) {
        this.intake.setNormalizedVoltage(0.0);
    }
}

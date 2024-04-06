package com.orbit.frc.commands.telescope;

import com.orbit.frc.subsystems.telescope.Telescope;

/* Configuration for a TelescopeHome command */
public class TelescopeHomeConfig {
    /* The Telescope to use */
    public Telescope telescope;

    /* The normalized voltage to apply to the telescope */
    public double speed;
}

package com.orbit.frc.subsystems.telescope;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.AnalogEncoder;

import com.orbit.frc.subsystems.SubsystemConfig;

public class TelescopeConfig extends SubsystemConfig {
    /* Not shown here: gear ratio should be the ratio of input rotations to meters extended */

    /* If using an absolute encoder, the value at which the telescope is at the 'zero 'position */
    public double encoderOffset;
    /* The absolute encoder on the telescope */
    public AnalogEncoder absoluteEncoder;

    /* If using a limit switch, the DIO port it is on */
    public int limitSwitchPort;
    /* Whether or not the limit switch is inverted */
    public boolean limitSwitchInverted;
    /* DIO object to use as the limit switch */
    public DigitalInput limitSwitch;
}

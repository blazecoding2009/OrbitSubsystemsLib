package com.orbit.frc.subsystems.flywheels;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import com.orbit.frc.subsystems.SubsystemConfig;

/* Configuration for a Flywheels subsystem */
public class FlywheelConfig extends SubsystemConfig {
    
    /* Create a new FlywheelConfig from motor type and CAN IDs
     * Gear ratio is assumed to be 1.0, as flywheels typically have a direct connection between the motors and the wheels
     * This method is replaced to avoid flywheels following each other
     */
    public static FlywheelConfig fromCANSparkXIDs(MotorModel type, int... ids) {
        FlywheelConfig config = new FlywheelConfig();
        config.motorIDs = ids;
        config.motors = new CANSparkBase[ids.length];

        // set up the motors
        for(int i = 0; i < ids.length; i++) {
            switch(type) {
                case REV_NEO:
                case REV_NEO_550:
                    config.motors[i] = new CANSparkMax(ids[i], MotorType.kBrushless);
                    break;
                case REV_VORTEX:
                    config.motors[i] = new CANSparkFlex(ids[i], MotorType.kBrushless);
                    break;
            }
        }
        
        return config;
    }
}

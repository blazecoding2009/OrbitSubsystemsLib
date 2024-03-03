package com.orbit.frc.subsystems.flywheels;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import com.orbit.frc.subsystems.SubsystemConfig;

public class FlywheelConfig extends SubsystemConfig {
   
    public static SubsystemConfig fromCANSparkXIDs(MotorModel type, int... ids) {
        SubsystemConfig config = new SubsystemConfig();
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

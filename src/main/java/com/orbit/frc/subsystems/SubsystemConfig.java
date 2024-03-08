package com.orbit.frc.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

/* The base class for all subsystem configurations */
public class SubsystemConfig {

    /* Enum to represent different types of motors when configuring */
    public enum MotorModel {
        REV_NEO,
        REV_NEO_550,
        REV_VORTEX
    }

    /* Motor controller CAN IDs */
    public int[] motorIDs;
    /* Motor controller wrapper classes */
    public CANSparkBase[] motors;
    /* The gear ratio between the motor shafts and the output shaft of the subsystem */ 
    public double gearRatio;
    
    /* Create a new SubsystemConfig for a given motor type, gear ratio and CAN IDs */
    public static SubsystemConfig fromCANSparkXIDs(MotorModel type, double gearRatio, int... ids) {
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
            if(i > 0) config.motors[i].follow(config.motors[0]);
            config.motors[i].getEncoder().setPositionConversionFactor(gearRatio);
            config.motors[i].getEncoder().setVelocityConversionFactor(gearRatio);
        }
        
        return config;
    }
}

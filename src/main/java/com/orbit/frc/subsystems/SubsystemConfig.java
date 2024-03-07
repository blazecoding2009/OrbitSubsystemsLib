package com.orbit.frc.subsystems;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogEncoder;

public class SubsystemConfig {

    public enum MotorModel {
        REV_NEO,
        REV_NEO_550,
        REV_VORTEX
    }

    /* Motor config
     * For fast config, use the fromCANSparkXIDs method, then config individual motors as needed
     */
    public int[] motorIDs; 
    public CANSparkBase[] motors;
    public double gearRatio;
    
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

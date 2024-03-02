package com.orbit.frc.subsystems.pivot;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogEncoder;

import com.orbit.frc.subsystems.SubsystemConfig;

public class PivotConfig extends SubsystemConfig{

    /* Encoder config
     * 
     */
    public int encoderPort;
    public double encoderOffset;
    public AnalogEncoder absoluteEncoder;
}

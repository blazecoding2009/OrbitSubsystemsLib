package main.java.com.orbit.frc.subsystems.leds;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogEncoder;

import com.orbit.frc.subsystems.SubsystemConfig;

public class LedsConfig extends SubsystemConfig{

    /* Encoder config
     * 
     */
    public int LEDPort;
}

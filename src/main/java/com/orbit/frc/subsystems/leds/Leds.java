package com.orbit.frc.subsystems.leds;

import java.util.prefs.Preferences;
import java.util.HashMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import main.java.com.orbit.frc.subsystems.leds.PivotConfig.LEDStates;

public class Leds extends SubsystemBase{
    private final LedConfig config;

    private Spark LEDController;
    private double LEDColour;
    public LEDStates LEDstate;

    HashMap<LEDStates, Double> LEDStatesMap = new HashMap<>();

    public Leds(LedConfig config) {
        this.LEDController = new Spark(config.LEDPort);
        this.LEDColour = 0.0;
        this.LEDstate = LEDStates.ENABLED;
    }

    public void addLEDState(String state, double colour) {
        LEDStatesMap.put(state, colour);
    }
    
    public void setLEDState(String state) {
        this.LEDstate = state;
    }

    @Override
    public void periodic() {
        this.LEDColour = LEDStatesMap.get(this.LEDstate);
        this.LEDController.set(this.LEDColour);
    }
}

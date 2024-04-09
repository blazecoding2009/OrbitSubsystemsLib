/*
 * Package: com.orbit.frc.subsystems.leds
 * Description: This package contains classes related to controlling LEDs on a robot.
 */

package com.orbit.frc.subsystems.leds;

import java.util.HashMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*
 * Class: Leds
 * Description: This class represents the subsystem responsible for controlling LEDs on a robot.
 */
public class Leds {
    private final LedConfig config; // Configuration object for LEDs

    private double LEDColour; // Current color of LEDs
    public LEDStates LEDstate; // Current state of LEDs

    HashMap<LEDStates, Double> LEDStatesMap = new HashMap<>(); // Map to store LED states and corresponding colors

    /*
     * Constructor: Leds
     * Description: Initializes the LED subsystem with the provided configuration.
     * Parameters:
     *  - config: Configuration object for LEDs
     */
    public Leds(LedConfig config) {
        this.LEDController = new Spark(config.LEDPort); // Initialize LED controller
        this.LEDColour = 0.0; // Default LED color
        this.LEDstate = LEDStates.ENABLED; // Default LED state
    }

    /*
     * Method: addLEDState
     * Description: Adds a new LED state with the specified color to the LED states map.
     * Parameters:
     *  - state: Name of the LED state
     *  - colour: Color of the LED state from revdocs
     */
    public void addLEDState(String state, double colour) {
        LEDStatesMap.put(state, colour); // Add LED state to the map
    }
    
    /*
     * Method: setLEDState
     * Description: Sets the current LED state.
     * Parameters:
     *  - state: Name of the LED state to set
     */
    public void setLEDState(String state) {
        this.LEDstate = state; // Set LED state
    }

    /*
     * Method: periodic
     * Description: This method is called periodically to update the LED color based on the current LED state.
     */
    @Override
    public void periodic() {
        this.LEDColour = LEDStatesMap.get(this.LEDstate); // Get color for the current LED state
        this.LEDController.set(this.LEDColour); // Set LED color
    }
}

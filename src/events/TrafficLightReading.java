/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jaden
 */
public class TrafficLightReading {

    public enum LightState {
        red, yellow, green
    }
    private final LightState mainLaneState;
    private final LightState sideLaneState;

    public TrafficLightReading(LightState mainLaneState, LightState sideLaneState) {
        this.mainLaneState = mainLaneState;
        this.sideLaneState = sideLaneState;

    }
        public LightState getMainLaneState() {
        return mainLaneState;
    }

    public LightState getSideLaneState() {
        return sideLaneState;
    }

}

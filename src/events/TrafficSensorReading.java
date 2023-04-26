/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

/**
 *
 * @author Jaden
 */
public class TrafficSensorReading {

    public enum laneState {
        Empty, Busy
    }

    private final laneState mainLane;
    private final laneState sideLane;

    public TrafficSensorReading(laneState mainLane, laneState sideLane) {
        this.mainLane = mainLane;
        this.sideLane = sideLane;
    }

    public laneState getMainLane() {
        return mainLane;
    }

    public laneState getSideLane() {
        return sideLane;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import esper.Config;
import events.TrafficSensorReading;
import events.TrafficSensorReading.laneState;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaden
 */
public class TrafficSensor implements Runnable {

    private laneState mainLane;
    private laneState sideLane;
<<<<<<< Updated upstream
    
=======

    public laneState getMainLaneState() {
        return mainLane;
    }

    public laneState getSideLaneState() {
        return sideLane;
    }

    public void setMainLane(laneState mainLane) {
        this.mainLane = mainLane;
    }

    public void setSideLane(laneState sideLane) {
        this.sideLane = sideLane;
    }

    public TrafficSensor() {
        this.mainLane = laneState.Busy;
        this.sideLane = laneState.Empty;
    }

>>>>>>> Stashed changes
    @Override
    public void run() {
        while (true) {

            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
<<<<<<< Updated upstream
            
            Config.sendEvent(new TrafficSensorReading(laneState.Busy,laneState.Empty));
=======

            Config.sendEvent(new TrafficSensorReading(mainLane, sideLane));
>>>>>>> Stashed changes
        }
    }

}

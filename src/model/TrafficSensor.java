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
    
    @Override
    public void run() {
    while (true) {
            
            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Config.sendEvent(new TrafficSensorReading(laneState.Busy,laneState.Empty));
        }
    }

    
}

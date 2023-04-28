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
    private TrafficSystem system;
    private laneState mainLane;
    private laneState sideLane;

    public laneState getMainLaneState() {
        return mainLane;
    }

    public laneState getSideLaneState() {
        return sideLane;
    }

    public void setMainLane(laneState mainLane) {
        this.mainLane = mainLane;
        //system.getGui().getMainLaneState().setText(mainLane.toString());
        
    }

    public void setSideLane(laneState sideLane) {
        this.sideLane = sideLane;
        //system.getGui().getSideLaneState().setText(sideLane.toString());
    }

    public TrafficSensor(TrafficSystem system) {
        this.mainLane = laneState.Empty;
        this.sideLane = laneState.Busy;
        this.system = system;
        system.getGui().getMainLaneState().setText(mainLane.toString());
        system.getGui().getSideLaneState().setText(sideLane.toString());
    }

    @Override
    public void run() {
        while (true) {

            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("main: "+mainLane.toString());
            System.out.println("side: "+sideLane.toString());
            //Config.sendEvent(new TrafficSensorReading(mainLane, sideLane));
            system.getGui().getMainLaneState().setText(mainLane.toString());
            system.getGui().getSideLaneState().setText(sideLane.toString());
        }
    }

}

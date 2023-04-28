/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import esper.Config;
import events.TrafficLightReading;
import events.TrafficLightReading.LightState;
import events.TrafficSensorReading;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import events.TrafficSensorReading.laneState;

/**
 *
 * @author Jaden
 */
public class TrafficLight implements Runnable {

    private TrafficSystem system;
    private LightState mainLightState;
    private LightState sideLightState;

    public TrafficLight(TrafficSystem system) {
        this.mainLightState = LightState.green;
        this.sideLightState = LightState.red;
        this.system = system;
    }

    public void NormalChange() {
         laneState mainLane = system.getTrafficSensor().getMainLaneState();
        laneState sideLane = system.getTrafficSensor().getSideLaneState();
        //check of either the lanes are empty not both
        if ((mainLane == laneState.Empty || sideLane == laneState.Empty) && mainLane != sideLane) {
            
            QuickChange(mainLane, sideLane);

        }
        if (mainLightState == LightState.red) {

            sideLightState = LightState.yellow;
            try {
                java.lang.Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }
            mainLightState = LightState.green;
            sideLightState = LightState.red;
        } else {
            mainLightState = LightState.yellow;
             try {
                java.lang.Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }
            sideLightState = LightState.green;
            mainLightState = LightState.red;

        }
    }

    public void QuickChange(laneState mainLane, laneState sideLane) {

        if (mainLightState == LightState.red && mainLane == laneState.Busy && sideLane == laneState.Empty) {
            mainLightState = LightState.green;
            sideLightState = LightState.red;
            system.getTrafficSensor().setMainLane(laneState.Empty);
            try {
                java.lang.Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }
            mainLightState = LightState.red;
            sideLightState = LightState.green;

        } else if (sideLightState == LightState.red && sideLane == laneState.Busy && mainLane == laneState.Empty) {
            mainLightState = LightState.red;
            sideLightState = LightState.green;
            system.getTrafficSensor().setSideLane(laneState.Empty);
            try {
                java.lang.Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }
            mainLightState = LightState.green;
            sideLightState = LightState.red;

        }
    }

    @Override
    public void run() {
        while (true) {

            try {
                java.lang.Thread.sleep(7000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }
            NormalChange();
            System.out.println("main lane:" + mainLightState);
            System.out.println("side lane:" + sideLightState);
            //Config.sendEvent(new TrafficLightReading(mainLightState, sideLightState));
        }
    }
}

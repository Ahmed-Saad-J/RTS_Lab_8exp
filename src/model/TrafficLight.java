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

/**
 *
 * @author Jaden
 */
public class TrafficLight implements Runnable {

    private LightState mainLaneState;
    private LightState sideLaneState;

    public TrafficLight() {
        this.mainLaneState = LightState.green;
        this.sideLaneState = LightState.red;
    }

    public void NormalChange() {
        if (mainLaneState == LightState.red) {
            sideLaneState = LightState.yellow;
            try {
                java.lang.Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }
            mainLaneState = LightState.green;
            sideLaneState = LightState.red;
        } else {
            mainLaneState = LightState.yellow;
            try {
                java.lang.Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }
            sideLaneState = LightState.green;
            mainLaneState = LightState.red;
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
              System.out.println("main lane:"+mainLaneState);
              System.out.println("side lane:"+sideLaneState);
            //Config.sendEvent(new TrafficLightReading(mainLaneState, sideLaneState));
        }
    }
}

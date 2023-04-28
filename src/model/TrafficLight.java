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
import java.awt.Color;

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
        system.getGui().getMainLaneGreen().setBackground(Color.green);
        system.getGui().getSideLaneRed().setBackground(Color.RED);
    }

    public void NormalChange() {
        laneState mainLane = system.getTrafficSensor().getMainLaneState();
        laneState sideLane = system.getTrafficSensor().getSideLaneState();
        //check of either the lanes are empty not both
        if (mainLane == laneState.Empty || sideLane == laneState.Empty && (mainLane != sideLane)) {
            
            QuickChange(mainLane, sideLane);

        }
        if (mainLightState == LightState.red) {
            
            try {
                java.lang.Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }

            sideLightState = LightState.yellow;

            system.getGui().getMainLaneRed().setBackground(Color.RED);
            system.getGui().getMainLaneYellow().setBackground(Color.WHITE);
            system.getGui().getMainLaneGreen().setBackground(Color.WHITE);

            system.getGui().getSideLaneRed().setBackground(Color.WHITE);
            system.getGui().getSideLaneYellow().setBackground(Color.YELLOW);
            system.getGui().getSideLaneGreen().setBackground(Color.WHITE);

            try {
                java.lang.Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }

            mainLightState = LightState.green;
            sideLightState = LightState.red;

            system.getGui().getMainLaneRed().setBackground(Color.WHITE);
            system.getGui().getMainLaneYellow().setBackground(Color.WHITE);
            system.getGui().getMainLaneGreen().setBackground(Color.GREEN);

            system.getGui().getSideLaneRed().setBackground(Color.RED);
            system.getGui().getSideLaneYellow().setBackground(Color.WHITE);
            system.getGui().getSideLaneGreen().setBackground(Color.WHITE);

        } else {

            try {
                java.lang.Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }

            mainLightState = LightState.yellow;

            system.getGui().getMainLaneRed().setBackground(Color.WHITE);
            system.getGui().getMainLaneYellow().setBackground(Color.YELLOW);
            system.getGui().getMainLaneGreen().setBackground(Color.white);

            system.getGui().getSideLaneRed().setBackground(Color.RED);
            system.getGui().getSideLaneYellow().setBackground(Color.WHITE);
            system.getGui().getSideLaneGreen().setBackground(Color.WHITE);
            try {
                java.lang.Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }
            sideLightState = LightState.green;
            mainLightState = LightState.red;

            system.getGui().getMainLaneRed().setBackground(Color.RED);
            system.getGui().getMainLaneYellow().setBackground(Color.WHITE);
            system.getGui().getMainLaneGreen().setBackground(Color.white);

            system.getGui().getSideLaneRed().setBackground(Color.WHITE);
            system.getGui().getSideLaneYellow().setBackground(Color.WHITE);
            system.getGui().getSideLaneGreen().setBackground(Color.GREEN);
        }
    }

    public void QuickChange(laneState mainLane, laneState sideLane) {

        if (mainLightState == LightState.red && mainLane == laneState.Busy && sideLane == laneState.Empty) {

            mainLightState = LightState.green;
            sideLightState = LightState.red;

            system.getGui().getMainLaneRed().setBackground(Color.WHITE);
            system.getGui().getMainLaneYellow().setBackground(Color.WHITE);
            system.getGui().getMainLaneGreen().setBackground(Color.GREEN);

            system.getGui().getSideLaneRed().setBackground(Color.red);
            system.getGui().getSideLaneYellow().setBackground(Color.WHITE);
            system.getGui().getSideLaneGreen().setBackground(Color.WHITE);

            system.getTrafficSensor().setMainLane(laneState.Empty);
            NormalChange();

        } else if (sideLightState == LightState.red && sideLane == laneState.Busy && mainLane == laneState.Empty) {
            mainLightState = LightState.red;
            sideLightState = LightState.green;

            system.getGui().getMainLaneRed().setBackground(Color.red);
            system.getGui().getMainLaneYellow().setBackground(Color.WHITE);
            system.getGui().getMainLaneGreen().setBackground(Color.white);

            system.getGui().getSideLaneRed().setBackground(Color.WHITE);
            system.getGui().getSideLaneYellow().setBackground(Color.WHITE);
            system.getGui().getSideLaneGreen().setBackground(Color.GREEN);

            system.getTrafficSensor().setSideLane(laneState.Empty);
            NormalChange();

        }
       
    }

    @Override
    public void run() {
        while (true) {

            try {
                java.lang.Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficLight.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            NormalChange();
//            System.out.println("main lane:" + mainLightState);
//            System.out.println("side lane:" + sideLightState);
            //Config.sendEvent(new TrafficLightReading(mainLightState, sideLightState));
        }
    }
}

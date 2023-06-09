/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import view.TrafficSystemView;

/**
 *
 * @author Jaden
 */
public class TrafficSystem {
    private TrafficSystemView gui;
    private TrafficLight traficLight;
    private TrafficSensor trafficSensor;
    private ViolationSensor violationSensor;

    public TrafficSystem() {
        
        
        gui = new TrafficSystemView();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        
        traficLight = new TrafficLight(this);
        trafficSensor = new TrafficSensor(this);
        violationSensor = new ViolationSensor();

        Thread t1 = new Thread(traficLight);
        t1.start();
//        
//
        Thread t2 = new Thread(trafficSensor);
        t2.start();
        
        Thread t3 = new Thread(violationSensor);
        t3.start();
    }

    public TrafficLight getTraficLight() {
        return traficLight;
    }

    public TrafficSensor getTrafficSensor() {
        return trafficSensor;
    }
    
    
    //LaneLights.put("Main lane", LightState.red);

    public TrafficSystemView getGui() {
        return gui;
    }

    public ViolationSensor getViolationSensor() {
        return violationSensor;
    }
}

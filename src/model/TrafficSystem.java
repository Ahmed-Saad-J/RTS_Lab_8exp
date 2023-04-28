/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author Jaden
 */
public class TrafficSystem {
 
    private TrafficLight traficLight;
    private TrafficSensor trafficSensor;
    private ViolationSensor violationSensor;
    public TrafficSystem() {
        traficLight = new TrafficLight();
        trafficSensor = new TrafficSensor();
         violationSensor = new ViolationSensor();

//        Thread t1 = new Thread(traficLight);
//        t1.start();
//        
//
//        Thread t2 = new Thread(trafficSensor);
//        t2.start();
//        
        Thread t3 = new Thread(violationSensor);
        t3.start();
    }
    
    //LaneLights.put("Main lane", LightState.red);
}

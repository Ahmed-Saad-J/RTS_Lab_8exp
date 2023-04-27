/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

//import model.Kettle;
import events.TrafficLightReading.LightState;
import events.TrafficSensorReading.laneState;
import model.TrafficLight;
import model.TrafficSensor;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Youssef Negm
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);

        // Register events
        Config.registerEvents();

        // Create Kettle
        //final Kettle kettle = new Kettle();
        Config.createStatement("select mainLane, sideLane from TrafficSensorReading")
                .setSubscriber(new Object() {
                    public void update(laneState mainLane, laneState sideLane) {
                        System.out.println("main lane is: " + mainLane);
                        System.out.println("side lane is: " + sideLane);

                    }
                });

        Config.createStatement("select mainLaneState, sideLaneState from TrafficLightReading")
                .setSubscriber(new Object() {
                    public void update(LightState mainLaneState, LightState sideLaneState) {
                        System.out.println("main lane is: " + mainLaneState);
                        System.out.println("side lane is: " + sideLaneState);

                    }
                });

//        TrafficSensor s1 = new TrafficSensor();
//        Thread t1 = new Thread(s1);
//        t1.start();
        
        TrafficLight s2 = new TrafficLight();
        Thread t2 = new Thread(s2);
        t2.start();

    }

}
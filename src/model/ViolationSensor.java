/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import esper.Config;
import events.TrafficSensorReading;
import events.ViolationReading;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jaden
 */
public class ViolationSensor implements Runnable {

    
    private LocalDateTime now;
    private String carPlate;

 static String randomPlate() {
        Random random = new Random();
    int randomInteger = 0;
    for (int i = 0; i < 5; i++) {
      int digit = random.nextInt(10);
      randomInteger = randomInteger * 10 + digit;
    }
        return Integer.toString(randomInteger);
    }
    
    
     public void run() {
        while (true) {

            try {
                java.lang.Thread.sleep(12000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrafficSensor.class.getName()).log(Level.SEVERE, null, ex);
            }

            Config.sendEvent(new ViolationReading(randomPlate()));
        }
    }
}

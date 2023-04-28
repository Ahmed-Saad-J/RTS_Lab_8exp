/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package events;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jaden
 */
public class ViolationReading {
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  

    private final LocalDateTime now;
    private final String carPlate;

    public ViolationReading(String carPlate) {
        this.now = LocalDateTime.now();
        this.carPlate = carPlate;

//   System.out.println(dtf.format(now));  
    }

    public LocalDateTime getNow() {
        return now;
    }

    public String getCarPlate() {
        return carPlate;
    }

}

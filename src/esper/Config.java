/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import events.TrafficLightReading;
import events.TrafficSensorReading;
import events.ViolationReading;


/**
 *
 * @author Youssef Negm
 */
public class Config {

    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();

    public static void registerEvents() {
        engine.getEPAdministrator().getConfiguration().addEventType(TrafficSensorReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(TrafficLightReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(ViolationReading.class);
        System.out.println("Events Successfully Registered.");
    }

    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }
    
    public static void sendEvent(Object o)
    {
        engine.getEPRuntime().sendEvent(o);
    }

}

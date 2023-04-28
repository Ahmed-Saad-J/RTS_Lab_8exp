package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Timer;

/**
 *
 * @author yehiaelhosieny
 */
public class DetectTraffic 
{
    private final Traffic traffic;
    private final Timer requestT;
    private final ArrayList<Request> Requests;
    //private final AudioController audioController;
    
    public TrafficController(Traffic traffic) {
        
        this.traffic = traffic;
        this.requestManager = new Timer();
        this.Requests = new ArrayList<>();
        this.requestManager.schedule(new RequestManager(traffic, this), 0, 10000);
    }
        public void ChangeTrafficState(boolean trafficState){
        if (traffic.crowded() == true){
            this.traffic.changeGreenState().setGreenState(greenState);
            else
                    {   
                            this.traffic.changeNormalState().setNormalState(normalState);
                    }
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
}

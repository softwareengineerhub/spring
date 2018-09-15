package com.app.consumer.durabletopic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class DurableTopic3 {

    @JmsListener(destination = "myDurableTopic", containerFactory = "topicDurable3Factory")
    public void onMessage(Message message) {
        try {
            // Thread.sleep(20000);
            System.out.println("durableTopic3: " + message);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

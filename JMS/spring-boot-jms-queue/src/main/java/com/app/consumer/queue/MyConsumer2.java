package com.app.consumer.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MyConsumer2 {

    @JmsListener(destination = "appQueue1", containerFactory = "myQueueFactory")
    public void onMessage(Message message) {
        try {
            Thread.sleep(20000);
            System.out.println("MyConsumer2: " + message);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

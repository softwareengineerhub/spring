package com.app.consumer.queue;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class MyConsumer1 implements MessageListener {

    @JmsListener(destination = "appQueue1", containerFactory = "myQueueFactory")
    public void onMessage(Message message) {
        try {
            Thread.sleep(20000);
            System.out.println("MyConsumer1: " + message);
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }
}

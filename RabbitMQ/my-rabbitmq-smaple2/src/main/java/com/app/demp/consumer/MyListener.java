package com.app.demp.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MyListener implements MessageListener {

    //to publish go to admin console and publish message from here
    @Override
    public void onMessage(Message message) {
        System.out.println("-----------");
        String body = new String(message.getBody());
        System.out.println("message="+body+"; hash="+hashCode()+"; thread="+Thread.currentThread().getName());
        System.out.println("-----------");
    }
}

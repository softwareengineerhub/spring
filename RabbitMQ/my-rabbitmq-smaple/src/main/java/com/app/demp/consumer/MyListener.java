package com.app.demp.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MyListener implements MessageListener {

    //to publsih go to admin console and publish message from here
    @Override
    public void onMessage(Message message) {
        String body = new String(message.getBody());
        System.out.println("message="+body);
    }
}

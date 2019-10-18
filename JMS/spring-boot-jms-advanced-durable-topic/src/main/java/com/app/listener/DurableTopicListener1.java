package com.app.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class DurableTopicListener1 {

    @JmsListener(destination = "myDurableTopic", containerFactory = "topicDurable1Factory")
    public void onMessage(Message message){
        System.out.println(message);
    }
}

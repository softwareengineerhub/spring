package com.app.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class DurableTopicListener2 {

    @JmsListener(destination = "myDurableTopic", containerFactory = "topicDurable2Factory")
    public void onMessage(Message message){
        System.out.println(message);
    }
}

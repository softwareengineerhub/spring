package com.app.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
public class MyTopicListener3 {

    @JmsListener(destination = "topicSpringBeanName", containerFactory = "myTopicFactory")
    public void onMessage(Message message){
        System.out.println(message);
    }
}

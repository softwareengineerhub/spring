package com.app.consumer.topic;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import javax.jms.Message;
import javax.jms.MessageListener;

@Component
public class TopicListener1 {

    @JmsListener(destination = "appTopic1", containerFactory = "myTopicFactory")
    public void onMessage(Message message) {
        try {
            // Thread.sleep(20000);
            System.out.println("TopicListener1: " + message);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}

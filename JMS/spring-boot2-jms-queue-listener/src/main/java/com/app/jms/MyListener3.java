package com.app.jms;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.TextMessage;

@Component
public class MyListener3 {

    @JmsListener(destination = "myQueue")
    public void onMessage(Message msg){
        try {
            if (msg instanceof TextMessage) {
                TextMessage tmsg = (TextMessage) msg;
                System.out.println("Consumed3: " + tmsg.getText());
                Thread.sleep(5000);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}

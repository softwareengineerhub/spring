/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.consumer;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyConsumer2 implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        //TextMessage m = (TextMessage) msg;
        System.out.println("MyConsumer2: "+msg);
    }
    
}

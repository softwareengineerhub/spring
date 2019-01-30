/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example;

import javax.annotation.PostConstruct;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyListener implements MessageListener {

    @PostConstruct
    public void init() {
        System.out.println("QQQQQQQ");
    }

    @Override
    public void onMessage(Message msg) {
        try {
            Thread.sleep(100);
            System.out.println("MyConsumer1: " + msg);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

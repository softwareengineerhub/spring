/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.consumer;

import org.springframework.jms.annotation.JmsListener;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyConsumer1 {
    
    @JmsListener(destination = "myQueue", containerFactory = "myFactory")
    public void onMessage(Object msg){
        System.out.println("MyConsumer1: "+msg);
        //System.out.println("\t"+msg);
    }
    
}

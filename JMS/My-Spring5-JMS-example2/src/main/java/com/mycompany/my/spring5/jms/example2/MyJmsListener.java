/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example2;

import javax.jms.TextMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component
public class MyJmsListener {

    @JmsListener(destination = "myQueue")
    public void onMessage(TextMessage msg) {
        try {
            Thread.sleep(20000);
            System.out.println(msg);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}

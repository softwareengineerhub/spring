/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.dynamicchangeofpool;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Denys.Prokopiuk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestAppCofig01.class})
public class ConsumerTest1 {
    
    @Test
    public void qqq(){
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConsumerTest1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}

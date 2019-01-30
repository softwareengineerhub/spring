/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jms.example;

import javax.jms.Session;
import org.apache.activemq.broker.BrokerService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Denys.Prokopiuk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ProducerTest3 {

    private static BrokerService broker;

    @Autowired
    private JmsTemplate template;

    @BeforeClass
    public static void startUp() throws Exception {
        broker = new BrokerService();
        broker.addConnector("tcp://localhost:61616");
        broker.start();
        Thread.sleep(5000);
    }

    @Test
    public void test() {
        template.send((Session sn) -> sn.createTextMessage("TEST"));
    }

    @AfterClass
    public static void tearDown() throws Exception {
        broker.stop();
    }

}

package com.app.controller;

import com.app.producer.MyDurableTopicProducer;
import com.app.producer.MyJMSProducer;
import com.app.producer.MyJMSProducer2;
import com.app.producer.MyJMSTopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    @Autowired
    private MyJMSProducer myJMSProducer;
    @Autowired
    private MyJMSProducer2 myJMSProducer2;
    @Autowired
    private MyJMSTopicProducer jmsTopicProducer;
    @Autowired
    private MyDurableTopicProducer myDurableTopicProducer;

    @GetMapping(value = "/send/{msg}")
    public void sendMessage(@PathVariable("msg")  String msg){
        System.out.println("@Before send");
        myJMSProducer.sendMessage(msg);
        System.out.println("@After send");

    }

    @GetMapping(value = "/send2/{msg}")
    public void sendMessage2(@PathVariable("msg")  String msg){
        System.out.println("@Before2 send");
        myJMSProducer2.sendMessage(msg);
        System.out.println("@After2 send");

    }


    @GetMapping(value = "/topic/{msg}")
    public void sendToTopic(@PathVariable("msg")  String msg){
        jmsTopicProducer.sendMessage(msg);
    }

    @GetMapping(value = "/durabletopic/{msg}")
    public void sendToDurableTopic(@PathVariable("msg")  String msg){
        myDurableTopicProducer.sendMessage(msg);
    }

}

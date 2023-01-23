package com.app.demp.producer;

import com.app.demp.model.SimpleMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/create")
    public void produceSimpleMessage(@RequestParam int count) {
        for(int i=0;i<count;i++){
            sendBinaryMessage(i);
        }
    }

    private void sendBinaryMessage(int i){
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setName("Name1");
        simpleMessage.setDescription(i+"description1"+ LocalTime.now());
        rabbitTemplate.convertAndSend("TestExchange", "TestRoutingKey", simpleMessage);
    }

    private void sendToExchangeWithRoutingKey(){
        rabbitTemplate.convertAndSend("TestExchange", "TestRoutingKey", "simpleMessage");
    }
    private void sendToDefaultExchange(){
        rabbitTemplate.convertAndSend("Hello, Rabbit!!!");
    }


}

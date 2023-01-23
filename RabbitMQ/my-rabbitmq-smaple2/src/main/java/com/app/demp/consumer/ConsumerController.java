package com.app.demp.consumer;

import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    private SimpleMessageListenerContainer messageListenerContainer;

    @GetMapping("/stop")
    public void stopListener(){
        messageListenerContainer.stop(()->{
            System.out.println("####STOP RUNNABLE####");
        });
    }

    @GetMapping("/start")
    public void startListener(){
        System.out.println("####START RUNNABLE####---begin");
        messageListenerContainer.start();
        System.out.println("####START RUNNABLE####---end");
    }

    @GetMapping("/setup")
    public void concurrentConsumers(@RequestParam int concurrentConsumers){
        System.out.println("####concurrentConsumers="+concurrentConsumers);
        messageListenerContainer.setConcurrentConsumers(concurrentConsumers);

    }

}

package com.app.demp.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyQueueConfig {

    @Bean
    public Queue exampleQueue() {
        boolean durable = false;
        return new Queue("ExampleQueue", durable);
    }

    @Bean
    public Queue example2ndQueue() {
        return QueueBuilder.durable("Example2ndQueue").autoDelete().exclusive().withArgument("key", "value").build();
    }

}

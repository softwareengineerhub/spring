package com.app.demp.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyExchangeConfiguration {

    @Bean
    public Exchange exampleExchange(){
        return new TopicExchange("ExampleExchange");
    }

    @Bean
    public Exchange example2ndExchange(){
        return ExchangeBuilder.directExchange("Example2ndExchange").autoDelete().internal().build();
    }


    @Bean
    public Exchange newExchange(){
        return ExchangeBuilder.topicExchange("TopicTestExchange").autoDelete().build();
    }

    @Bean
    public Exchange fanoutExchange(){
        return ExchangeBuilder.fanoutExchange("FanoutTestExchange").autoDelete().build();
    }

    @Bean
    public Exchange headersExchange(){
        return ExchangeBuilder.headersExchange("HeadersTestExchange").autoDelete().build();
    }

}

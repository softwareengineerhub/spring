package com.app.main;

import com.app.config.DurableTopicSpringConfig;
import com.app.config.MySpringConfig;
import com.app.config.QueueSpringConfig;
import com.app.config.TopicSpringConfig;
import org.springframework.boot.SpringApplication;

import javax.jms.Topic;

public class Main {

    public static void main(String[] args) {
        /*SpringApplication.run(new Object[]{
                MySpringConfig.class,
                QueueSpringConfig.class,
                TopicSpringConfig.class,
                DurableTopicSpringConfig.class}, args);*/

        SpringApplication.run(new Object[]{
                DurableTopicSpringConfig.class,
                QueueSpringConfig.class,
                TopicSpringConfig.class,
                MySpringConfig.class}, args);
    }
}

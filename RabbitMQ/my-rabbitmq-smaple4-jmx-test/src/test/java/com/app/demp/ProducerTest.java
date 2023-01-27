package com.app.demp;

import com.app.demp.utils.JMXUtils;
import com.app.demp.utils.ProducerUtils;
import com.app.demp.utils.Utils;
import org.junit.Test;

public class ProducerTest {

    @Test
    public void test() throws Exception {
        String url = "http://127.0.0.1:15672/api/queues";
        String username = "guest";
        String password = "guest";
        String queueName = "MyQueue";
        //QueueStat queueStatBeforePublishing = Utils.getStatistics(url, username, password, queueName);
        //rabbitTemplate.convertAndSend("TestExchange", "TestRoutingKey", simpleMessage);
        String exchange = "MyTopicExchange";
        String routingKey = "topic";
        ProducerUtils.publish(5, exchange, routingKey);
    }
}

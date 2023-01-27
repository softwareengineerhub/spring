package com.app.demp;

import com.app.demp.utils.Utils;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QueueStatTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() throws Exception {
        String url = "http://127.0.0.1:15672/api/queues";
        String username = "guest";
        String password = "guest";
        String queueName = "MyQueue";
        QueueStat queueStatBeforePublishing = Utils.getStatistics(url, username, password, queueName);
        System.out.println("queueStatBeforePublishing=" + queueStatBeforePublishing);
        //publish();
        Thread.sleep(5000);
        QueueStat queueStatAfterPublishing = Utils.getStatistics(url, username, password, queueName);
        System.out.println("queueStatAfterPublishing=" + queueStatAfterPublishing);
    }

}

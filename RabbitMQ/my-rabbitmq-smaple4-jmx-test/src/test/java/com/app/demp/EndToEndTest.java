package com.app.demp;

import com.app.demp.utils.JMXUtils;
import com.app.demp.utils.ProducerUtils;
import com.app.demp.utils.Utils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EndToEndTest {


    @Test
    public void test() throws Exception {
        String url = "http://127.0.0.1:15672/api/queues";
        String username = "guest";
        String password = "guest";
        String queueName = "MyQueue";
        QueueStat queueStatBeforePublishing = Utils.getStatistics(url, username, password, queueName);
        System.out.println("queueStatBeforePublishing=" + queueStatBeforePublishing);

        String jmxUrl = "service:jmx:rmi://localhost/jndi/rmi://localhost:1099/myconnector";

        JMXUtils.stop(jmxUrl);
        ProducerUtils.publish(5, "MyTopicExchange", "topic");
        Thread.sleep(5000);
        QueueStat queueStatAfterPublishing = Utils.getStatistics(url, username, password, queueName);
        System.out.println("queueStatAfterPublishing=" + queueStatAfterPublishing);
        assertTrue(queueStatBeforePublishing.getAck() == queueStatAfterPublishing.getAck());
        assertTrue(queueStatBeforePublishing.getPublish()+5 == queueStatAfterPublishing.getPublish());

        JMXUtils.start(jmxUrl);
        Thread.sleep(5000);
        QueueStat queueStatAfterStartOfConsumer = Utils.getStatistics(url, username, password, queueName);
        System.out.println("queueStatAfterStartOfConsumer=" + queueStatAfterStartOfConsumer);

        assertTrue(queueStatBeforePublishing.getAck() + 5 == queueStatAfterStartOfConsumer.getAck());
        assertTrue(queueStatAfterPublishing.getAck() + 5 == queueStatAfterStartOfConsumer.getAck());

        assertTrue(queueStatBeforePublishing.getPublish() + 5 == queueStatAfterStartOfConsumer.getPublish());
        assertTrue(queueStatAfterPublishing.getPublish() == queueStatAfterStartOfConsumer.getPublish());
    }
}

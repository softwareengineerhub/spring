package com.app07.ack.deadletterexchange;

import com.rabbitmq.client.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class PublisherTest {
    private static String QUEUE_NAME = "my-dlq-sample";
    private static String EXCHANGE_NAME = "";
    private static String DLX_EXCHANGE_NAME = "user_dlx";

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setMetricsCollector(new NoOpMetricsCollector(){
            @Override
            public void basicCancel(Channel channel, String consumerTag) {
                System.out.println("\t\t@@@@@@@@@@@@@");
            }

            @Override
            public void consumedMessage(Channel channel, long deliveryTag, boolean autoAck) {
                System.out.println("\t\t@@@@@@@@@@@@@consumed1");
            }

            @Override
            public void consumedMessage(Channel channel, long deliveryTag, String consumerTag) {
                System.out.println("\t\t@@@@@@@@@@@@@consumed2");
            }
        });
        Connection connection = factory.newConnection("app:api:rest");

       // connection.close();

    }

}

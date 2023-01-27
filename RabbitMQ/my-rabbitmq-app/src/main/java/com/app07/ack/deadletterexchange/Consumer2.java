package com.app07.ack.deadletterexchange;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Consumer2 {
    static String ROUTING_KEY = "";
    static String QUEUE_NAME = "my-dlq-sample";
    private static String DLX_EXCHANGE_NAME = "user_dlx";

    //static String EXCHANGE_NAME = "quotes_exchange_headers";


    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
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
        factory.setHost("localhost");






        Connection connection = factory.newConnection("app:api:rest");
        Channel channel = connection.createChannel();


        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", DLX_EXCHANGE_NAME);
        arguments.put("x-dead-letter-routing-key", "user-dlx");
        boolean durable = false;
        boolean exclusive = false;
        boolean autoDelete = false;

        channel.exchangeDeclare(DLX_EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        channel.queueDeclare(QUEUE_NAME, durable, exclusive, autoDelete, arguments);

        boolean autoAck = true;
        channel.basicConsume(QUEUE_NAME, autoAck, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery delivery) throws IOException {
                System.out.println("consumerTag=" + consumerTag);
                byte[] data = delivery.getBody();
                String body = new String(data);
                System.out.println("body=" + body);
                AMQP.BasicProperties props = delivery.getProperties();
                System.out.println("props=" + props);
                Map<String, Object> msgHeaders = props.getHeaders();
                System.out.println("msgHeaders="+msgHeaders);
                MetricsCollector metricsCollector = factory.getMetricsCollector();

                System.out.println("----------------------------");
            }
        }, (CancelCallback) null);

    }

}

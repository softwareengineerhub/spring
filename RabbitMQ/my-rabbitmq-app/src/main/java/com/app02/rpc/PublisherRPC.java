package com.app02.rpc;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import java.util.UUID;

public class PublisherRPC {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection c = factory.newConnection("app:api:client");
        try (Channel channel = c.createChannel()) {
            String queueName = "loanApplicationQueue";






            boolean durable = false;
            boolean exclusive = false;
            boolean autoDelete = true;
            Map<String, Object> arguments = null;
            AMQP.Queue.DeclareOk declareOk = channel.queueDeclare(queueName, durable, exclusive, autoDelete, arguments);
            System.out.println("declareOk="+declareOk.getQueue());

            String replyTo = channel.queueDeclare().getQueue();
            //String replyTo = declareOk.getQueue();
            System.out.println("replyTo="+replyTo);

            System.out.println("#########start listener########");
            boolean autoAck = true;
            createConsumer(channel, replyTo, autoAck);
            System.out.println("#########listener started########");


            final String correlationId = UUID.randomUUID().toString();
            String exchange = "";
            String routingKey = queueName;
            AMQP.BasicProperties props = new AMQP.BasicProperties.Builder().correlationId(correlationId).replyTo(replyTo).build();

            for(int i=0;i<30;i++) {
                String message = i+" my test message " + LocalTime.now();
                channel.basicPublish(exchange, routingKey, props, message.getBytes());
                System.out.println(i+"Message was published!!!");
                Thread.sleep(10000);
            }





            /*channel.basicConsume(replyTo, autoAck, new DeliverCallback() {
                @Override
                public void handle(String consumerTag, Delivery delivery) throws IOException {
                    System.out.println("-----Publisher recieved message------consumerTag=" + consumerTag);
                    String body = new String(delivery.getBody());
                    System.out.println("body=" + body);
                    BasicProperties basicProperties = delivery.getProperties();
                    System.out.println("basicProperties=" + basicProperties);
                }
            }, new CancelCallback() {
                @Override
                public void handle(String consumerTag) throws IOException {
                    System.out.println("-----Publisher CancelCallback message------consumerTag=" + consumerTag);
                }
            });*/
        }

    }

    private static void createConsumer(Channel channel, String replyTo, boolean autoAck) throws IOException {
        channel.basicConsume(replyTo, autoAck, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery delivery) throws IOException {
                System.out.println("\t\t\t-----Publisher recieved message------consumerTag=" + consumerTag);
                String body = new String(delivery.getBody());
                System.out.println("\t\t\tbody=" + body);
                BasicProperties basicProperties = delivery.getProperties();
                System.out.println("\t\t\tbasicProperties=" + basicProperties);
            }
        }, new CancelCallback() {
            @Override
            public void handle(String consumerTag) throws IOException {
                System.out.println("\t\t\t-----Publisher CancelCallback message------consumerTag=" + consumerTag);
            }
        });
    }

}

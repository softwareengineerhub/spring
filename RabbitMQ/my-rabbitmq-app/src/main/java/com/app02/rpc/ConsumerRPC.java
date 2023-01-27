package com.app02.rpc;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import java.util.UUID;

public class ConsumerRPC {
    static long index=0;

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection c = factory.newConnection("app:api:client");
        Channel channel = c.createChannel();
        String queueName = "loanApplicationQueue";
        boolean durable = false;
        boolean exclusive = false;
        boolean autoDelete = true;
        Map<String, Object> arguments = null;
        channel.queueDeclare(queueName, durable, exclusive, autoDelete, arguments);
        boolean autoAck = true;


        channel.basicConsume(queueName, autoAck, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery delivery) throws IOException {
                System.out.println("------------handler start----------------");
                System.out.println("consumerTag=" + consumerTag);
                byte[] data = delivery.getBody();
                String body = new String(data);
                System.out.println("body=" + body);

                AMQP.BasicProperties props = delivery.getProperties();
                String correlationId = props.getCorrelationId();
                String replyTo = props.getReplyTo();
                System.out.println("correlationId="+correlationId);
                System.out.println("replyTo="+replyTo);


                String exchange = "";
                //String routingKey = queueName;
                String routingKey = replyTo;
                props = new AMQP.BasicProperties.Builder().correlationId(correlationId).build();
                String message = (++index)+ " !!!CONSUMER REPLY " +LocalTime.now()+"!!!";

                //String s = null;
                //s.toLowerCase();
                if(routingKey!=null) {
                    channel.basicPublish(exchange, routingKey, props, message.getBytes());
                    System.out.println("COMSUMER PUBLISHED MESSAGE");
                    System.out.println("------------handler finish----------------");
                }

            }
        }, (CancelCallback) null);





    }

}

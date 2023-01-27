package com.app01.pollandbasic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.GetResponse;

import java.util.Map;

public class Consumer01Pull {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection("app:api:rest");
        try(Channel channel = connection.createChannel()){
            String queueName = "users";
            boolean durable = false;
            boolean exclusive = false;
            boolean autoDelete = false;
            Map<String, Object> arguments = null;
            channel.queueDeclare(queueName,durable, exclusive, autoDelete, arguments);

            while(true) {
                boolean autoAck = true;
                GetResponse getResponse = channel.basicGet(queueName, autoAck);
                //reads messages 1 by 1
                //if response ==null --> no messages in Queue for now
                // int count - how many message left in Queue (0 - then we consumed last message)

                if (getResponse != null) {
                    int count = getResponse.getMessageCount();
                    System.out.println("count=" + count);
                    byte[] data = getResponse.getBody();
                    String body = new String(data);
                    System.out.println("body="+body);
                }
            }
        }
    }

}

package test;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 生产者提交消息。
 */
public class Producter {
    public static void main(String[] args) {

        try {
            ConnectionFactory factory = new ConnectionFactory();

            factory.setHost("192.168.233.168");
            factory.setPort(5672);
            factory.setUsername("lyg");
            factory.setPassword("123456");
            factory.setVirtualHost("/");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.exchangeDeclare("test_exchange", "fanout", true);
            channel.queueDeclare("test_queue", true, false, true, null);
            channel.queueBind("test_queue", "test_exchange", "test_bandingkey");
            String uuid = UUID.randomUUID().toString();
            System.out.println("提交消息：" + uuid);
            channel.basicPublish("test_exchange", "test_bandingkey", null, uuid.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
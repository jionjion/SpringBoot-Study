package top.jionjion.rabbit.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  工作队列模式
 *  生产者, 产生消息
 * @author Jion
 */
public class Provider {

    /** 发送队列消息 */
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123456");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("work", false, false, false, null);

        // 循环发送消息
        for (int i=0; i<=10; i++){
            channel.basicPublish("", "work", null, ("hello rabbit work queue .. " + i).getBytes());
        }

        // 关闭连接
        channel.close();
        connection.close();
    }
}

package top.jionjion.rabbit.fanout;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  广播队列模式
 *  生产者, 产生消息
 * @author Jion
 */
@SuppressWarnings("ALL")
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

        // 声明交换机. 交换机名称, 交换机类型(广播类型).
        channel.exchangeDeclare("exchange", BuiltinExchangeType.FANOUT);

        // 发送消息,指定交换机
        channel.basicPublish("exchange", "", null, ("hello rabbit fanout queue .. ").getBytes());

        // 关闭连接
        channel.close();
        connection.close();
    }
}

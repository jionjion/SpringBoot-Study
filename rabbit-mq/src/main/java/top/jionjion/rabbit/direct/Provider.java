package top.jionjion.rabbit.direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
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

        // 声明交换机. 交换机名称, 交换机类型(路由类型).
        channel.exchangeDeclare("direct", BuiltinExchangeType.DIRECT);
        // 发送消息,指定交换机. 无需绑定队列, 指定路由关键字
        channel.basicPublish("direct", "error", null, ("这是路由规则 .. " + "error").getBytes());
        channel.basicPublish("direct", "warning", null, ("这是路由规则 .. " + "warning").getBytes());
        channel.basicPublish("direct", "info", null, ("这是路由规则 .. " + "info").getBytes());

        // 关闭连接
        channel.close();
        connection.close();
    }
}

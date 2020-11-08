package top.jionjion.rabbit.peer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  生产者, 产生消息
 * @author Jion
 */
public class Provider {

    /** 发送队列消息 */
    public static void main(String[] args) throws IOException, TimeoutException {
        // 连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 地址
        connectionFactory.setHost("127.0.0.1");
        // 端口
        connectionFactory.setPort(5672);
        // 虚拟主机
        connectionFactory.setVirtualHost("/ems");
        // 认证, 用户名密码
        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("123456");

        // 获取连接
        Connection connection = connectionFactory.newConnection();
        // 获取通达
        Channel channel = connection.createChannel();

        // 通道绑定对应消息队列. 参数:
        // 队列名(不存在则创建),
        // 是否持久化(队列重启后是否丢失, 消息是否丢失取决于发送时参数),
        // 是否独占队列, 当前队列只被当前连接访问.
        // 是否在消费完成后自动删除,
        // 额外的配置参数
        channel.queueDeclare("hello", false, false, false, null);

        // 发布消息. 参数:
        // 交换机名称,
        // 队列名称(真正发送到的队列名),
        // 额外属性参数(重启后恢复消息内容),
        // 消息内容
        channel.basicPublish("", "hello", MessageProperties.PERSISTENT_TEXT_PLAIN, "hello rabbit-mq".getBytes());

        // 关闭连接
        channel.close();
        connection.close();
    }
}

package top.jionjion.rabbit.peer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  消费者
 * @author Jion
 */
public class Customer {

    /** 接受队列消息 */
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

        // 生产者,消费者的队列特性要求严格一致
        // 通道绑定对应消息队列. 队列名(不存在则创建), 是否持久化, 是否独占队列, 是否在消费完成后自动删除, 额外的配置参数
        channel.queueDeclare("hello", false, false, false, null);

        // 消费消息. 队列名, 是否自动确认消息, 消费回调接口
        channel.basicConsume("hello", true, new DefaultConsumer(channel){
            /**
             * No-op implementation of {@link Consumer#handleDelivery}.
             *
             * @param consumerTag 参数标签
             * @param envelope     信封
             * @param properties  属性
             * @param body  消息内容
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("获得消息... " + new String(body));
            }
        });

        // 关闭连接, 建议不关闭, 持续监听消息.
        // channel.close();
        // connection.close();
    }
}

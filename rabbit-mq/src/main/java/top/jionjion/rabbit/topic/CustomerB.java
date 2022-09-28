package top.jionjion.rabbit.topic;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  动态路由模式
 *  消费者B
 * @author Jion
 */
@SuppressWarnings("ALL")
public class CustomerB {

    /** 接受队列消息 */
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
        channel.exchangeDeclare("topic", BuiltinExchangeType.TOPIC);

        // 临时队列
        String queueName = channel.queueDeclare().getQueue();
        // 基于路由关键字,绑定交换机和队列. 临时队列名, 交换机名, 路由的关键字,通配符方式. # 配配多个单词,单用全部
        channel.queueBind(queueName, "topic", "user.#");
        channel.queueBind(queueName, "topic", "#");

        // 消费
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                System.out.println("消费者A获得消息... " + new String(body));
            }
        });
    }
}

package top.jionjion.rabbit.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  广播队列模式
 *  消费者A
 * @author Jion
 */
public class CustomerA {

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

        // 绑定交换机
        channel.exchangeDeclare("exchange", BuiltinExchangeType.FANOUT);

        // 临时队列
        String queueName = channel.queueDeclare().getQueue();
        // 绑定交换机和队列. 临时队列名, 交换机名, 路由的关键字
        channel.queueBind(queueName, "exchange", "");

        // 消费
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                System.out.println("消费者A获得消息... " + new String(body));
            }
        });
    }
}

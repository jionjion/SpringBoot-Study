package top.jionjion.rabbit.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *  工作队列模式
 *  消费者B
 *  手动确认消息,并限制流量
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

        channel.queueDeclare("work", false, false, false, null);
        // 2.每次消费通道只会处理一条
        channel.basicQos(1);
        // 1.修改, 不会自动确认消息
        channel.basicConsume("work", false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者B获得消息... " + new String(body));
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 3. 手动确认. 队列中的消息唯一编码,  是否开启多个消息确认
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }
}

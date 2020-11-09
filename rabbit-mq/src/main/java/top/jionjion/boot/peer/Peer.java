package top.jionjion.boot.peer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *  使用SpringBoot实现点对点模型
 * @author Jion
 */
@Component
public class Peer {

    /**
     * 接收消息
     */
    @RabbitListener(queuesToDeclare = @Queue(name = "hello"))
    @RabbitHandler
    public void reviewMessage(String message) {
        System.out.println("获得消息... " + message);
    }
}
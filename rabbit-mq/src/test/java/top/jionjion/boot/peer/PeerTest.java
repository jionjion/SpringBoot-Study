package top.jionjion.boot.peer;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  使用SpringBoot实现点对点模型
 * @author Jion
 */
@SpringBootTest
public class PeerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /** 发送消息 */
    @Test
    public void sendMessage(){
        // 将对象转为底层的字节. 队列名, 内容对象
        rabbitTemplate.convertAndSend("hello", "hello rabbit-mq");
    }
}
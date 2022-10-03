package top.jionjion.boot.fanout;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  使用SpringBoot实现广播模式
 * @author Jion
 */
@SpringBootTest
class FanoutTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /** 发送消息 */
    @Test
    void sendMessage(){
        // 将对象转为底层的字节. 路由, 路由关键字, 内容对象
        rabbitTemplate.convertAndSend("fanout", "", "hello rabbit fanout queue .. ");
    }
}
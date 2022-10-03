package top.jionjion.boot.direct;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  使用SpringBoot实现路由模式
 * @author Jion
 */
@SpringBootTest
class DirectTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /** 发送消息 */
    @Test
    void sendMessage(){
        // 将对象转为底层的字节. 路由, 路由关键字, 内容对象
        rabbitTemplate.convertAndSend("direct", "error", "这是路由规则 .. error");
        rabbitTemplate.convertAndSend("direct", "warning", "这是路由规则 .. warning");
        rabbitTemplate.convertAndSend("direct", "info", "这是路由规则 .. info");
    }
}
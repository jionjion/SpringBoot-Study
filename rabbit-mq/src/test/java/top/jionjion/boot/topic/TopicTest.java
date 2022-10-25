package top.jionjion.boot.topic;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 使用SpringBoot实现动态路由模式
 * @author Jion
 */
@SpringBootTest
class TopicTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /** 发送消息 */
    @Test
    void sendMessage() {
        rabbitTemplate.convertAndSend("topic", "user.login", "这是路由规则 .. user.login");
        rabbitTemplate.convertAndSend("topic", "user.logout", "这是路由规则 .. user.logout");
        rabbitTemplate.convertAndSend("topic", "user.info.all", "这是路由规则 .. user.info.all");
    }
}
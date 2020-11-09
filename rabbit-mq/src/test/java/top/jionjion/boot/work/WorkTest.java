package top.jionjion.boot.work;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  使用SpringBoot实现工作队列模型. 公平轮询
 * @author Jion
 */
@SpringBootTest
public class WorkTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /** 发送消息 */
    @Test
    public void sendMessage(){
        // 将对象转为底层的字节. 队列名, 内容对象
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "hello rabbit work queue .. " + i);
        }
    }
}
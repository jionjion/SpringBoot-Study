package top.jionjion.boot.work;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *  使用SpringBoot实现工作队列模型. 公平轮询
 * @author Jion
 */
@SpringBootTest
class WorkTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /** 接收消息 */
    @RabbitListener(queuesToDeclare = @Queue(name = "work", durable = "false", autoDelete = "true"))
    @RabbitHandler
    public void reviewMessageA(String message){
        System.out.println("消费者A获得消息... " + message);
    }

    /** 接收消息 */
    @RabbitListener(queuesToDeclare = @Queue(name = "work", durable = "false", autoDelete = "true"))
    @RabbitListener(queues = "work")
    @RabbitHandler
    public void reviewMessageB(String message){
        System.out.println("消费者B获得消息... " + message);
    }

    /** 发送消息 */
    @Test
    public void sendMessage(){
        // 将对象转为底层的字节. 队列名, 内容对象
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "hello rabbit work queue .. " + i);
        }
    }
}
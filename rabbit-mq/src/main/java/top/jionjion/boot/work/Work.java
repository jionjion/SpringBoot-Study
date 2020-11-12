package top.jionjion.boot.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 使用SpringBoot实现工作队列模式
 * @author Jion
 */
@Component
public class Work {

    /** 接收消息 声明一个队列 */
    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    public void reviewMessageA(String message){
        System.out.println("消费者A获得消息... " + message);
    }

    /** 接收消息 */
    @RabbitListener(queuesToDeclare = @Queue(name = "work"))
    public void reviewMessageB(String message){
        System.out.println("消费者B获得消息... " + message);
    }

}

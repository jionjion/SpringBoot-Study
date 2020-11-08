package top.jionjion.boot.fanout;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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

    /** 接收消息 */
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(name = "temp-a", durable = "false", autoDelete = "true"), // 临时队列
                            exchange = @Exchange(value = "fanout-a", type = ExchangeTypes.FANOUT))})
    public void reviewMessageA(String message){
        System.out.println("消费者A获得消息... " + message);
    }

    /** 接收消息 */
    @RabbitListener(bindings = {@QueueBinding(value = @Queue(name = "temp-b", durable = "false", autoDelete = "true"), exchange = @Exchange(value = "fanout", type = ExchangeTypes.FANOUT))})
    public void reviewMessageB(String message){
        System.out.println("消费者B获得消息... " + message);
    }

    /** 发送消息 */
    @Test
    public void sendMessage(){
        // 将对象转为底层的字节. 路由, 路由关键字, 内容对象
        rabbitTemplate.convertAndSend("fanout", "", "hello rabbit fanout queue .. ");
    }
}
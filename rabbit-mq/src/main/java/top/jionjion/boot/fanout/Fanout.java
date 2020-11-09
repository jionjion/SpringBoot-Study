package top.jionjion.boot.fanout;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *  使用SpringBoot实现广播模式
 * @author Jion
 */
@Component
public class Fanout {


    /** 接收消息, 使用临时队列接受 */
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue, exchange = @Exchange(value = "fanout", type = ExchangeTypes.FANOUT))})
    public void reviewMessageA(String message){
        System.out.println("消费者A获得消息... " + message);
    }

    /** 接收消息 */
    @RabbitListener(bindings = {@QueueBinding(value = @Queue, exchange = @Exchange(value = "fanout", type = ExchangeTypes.FANOUT))})
    public void reviewMessageB(String message){
        System.out.println("消费者B获得消息... " + message);
    }

}
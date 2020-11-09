package top.jionjion.boot.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 *  使用SpringBoot实现动态路由模式
 * @author Jion
 */
@Component
public class Topic {

    /** 接收消息, 使用临时队列接受 */
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,
                    exchange = @Exchange(value = "topic", type = ExchangeTypes.TOPIC),
                    key = {"user.*"})})
    public void reviewMessageA(String message){
        System.out.println("消费者A获得消息... " + message);
    }

    /** 接收消息, 指定路由匹配规则 */
    @RabbitListener(bindings = {@QueueBinding(value = @Queue, exchange = @Exchange(value = "topic", type = ExchangeTypes.TOPIC), key = {"user.#", "#"})})
    public void reviewMessageB(String message){
        System.out.println("消费者B获得消息... " + message);
    }

}
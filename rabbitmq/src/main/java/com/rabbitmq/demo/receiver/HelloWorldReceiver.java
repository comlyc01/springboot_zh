package com.rabbitmq.demo.receiver;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;


/**
 * MQ简单模式
 * 消费者
 */
@Component
public class HelloWorldReceiver {

    @RabbitHandler
    @RabbitListener(queues = "helleWorld")      // 监听队列
    //@RabbitListener(queuesToDeclare = @Queue("helleWorld"))    // 创建队列
    //@RabbitListener(bindings = @QueueBinding(value =  @Queue("myQueue"), key = "mobi", exchange = @Exchange("myExchange")))    //自动创建队列并对Exchange和Queue进行绑定
    public void helloReceiver(String messages){
        System.out.println("【简单模式】——消费者接收消息为 = " + messages);
    }


}

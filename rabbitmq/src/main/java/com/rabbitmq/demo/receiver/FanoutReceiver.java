package com.rabbitmq.demo.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * MQ订阅模式
 * 消费者
 */
@Component
public class FanoutReceiver {


    @RabbitHandler
    @RabbitListener(queues = "fanout1")   // 监听队列
    public void fanoutReceiver1(String messages) {
        System.out.println("【订阅模式】接收者1 = " + messages);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout2")   // 监听队列
    public void fanoutReceiver2(String messages) {
        System.out.println("【订阅模式】接收者2 = " + messages);
    }
}

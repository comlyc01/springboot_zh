package com.rabbitmq.demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * MQ工作模式
 * 消费者
 */
@Component
public class WorkQueuesReceiver {

    @RabbitHandler
    @RabbitListener(queues = "workQueues")    // 监听队列
    public void workReceiver1(String messages){
        System.out.println("【work模式】消费者1 = " + messages);
    }

    @RabbitHandler
    @RabbitListener(queues = "workQueues")    // 监听队列
    public void workReceiver2(String messages){
        System.out.println("【work模式】消费者2 = " + messages);
    }
}

package com.rabbitmq.demo.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicReceiver {


    @RabbitHandler
    @RabbitListener(queues = "topic1")
    public void topicReceicer1(String messages) {
        System.out.println("【Topic模式】接收者key1 = " + messages);
    }

    @RabbitHandler
    @RabbitListener(queues = "topic1")
    public void topicReceicer2(String messages) {
        System.out.println("【Topic模式】接收者key2 = " + messages);
    }

}

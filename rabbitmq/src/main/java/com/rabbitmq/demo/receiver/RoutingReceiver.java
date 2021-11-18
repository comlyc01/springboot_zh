package com.rabbitmq.demo.receiver;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RoutingReceiver {

    @RabbitHandler
    @RabbitListener(queues = "routing1")
    public void routingReceiver1(String messages) {
        System.out.println("【路由模式】接受者key1 = " + messages);
    }

    @RabbitHandler
    @RabbitListener(queues = "routing1")
    public void routingReceiver2(String messages) {
        System.out.println("【路由模式】接受者key2 = " + messages);
    }

}

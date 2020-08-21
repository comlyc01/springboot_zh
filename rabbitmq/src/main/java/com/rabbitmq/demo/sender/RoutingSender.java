package com.rabbitmq.demo.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RoutingSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void routingSender1(int i){
        String context = "【路由模式】_数据key1_"+i;
        System.out.println("【路由模式】key1发送者 = " + context);
        rabbitTemplate.convertAndSend("exchange_direct","routing.key1",context);
    }

    public void routingSender2(int i){
        String context = "【路由模式】_数据key2_"+i;
        System.out.println("【路由模式】key2发送者 = " + context);
        rabbitTemplate.convertAndSend("exchange_direct","routing.14hg1j41f4j1",context);
    }

}

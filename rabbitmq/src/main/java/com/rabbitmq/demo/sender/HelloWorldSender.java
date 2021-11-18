package com.rabbitmq.demo.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * MQ简单模式
 * 生产者
 */
@Component
public class HelloWorldSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void helloSender(int i) {
        String context = "【简单模式】_数据_" + i;
        System.out.println("【简单模式】发送者 = " + context);
        // 参数1： 队列 ，参数2： 消息内容
        this.rabbitTemplate.convertAndSend("helleWorld", context);
    }
}

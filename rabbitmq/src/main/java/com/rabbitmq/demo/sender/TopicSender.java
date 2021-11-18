package com.rabbitmq.demo.sender;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TopicSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void topicSender1(int i) {
        String context = "【topic模式】_数据key1_" + i;
        System.out.println("【topic模式】发送者key1 = " + context);
        rabbitTemplate.convertAndSend("exchange_topic", "topic.key1", context);
    }

    public void topicSender2(int i) {
        String context = "【topic模式】_数据key2_" + i;
        System.out.println("【topic模式】发送者key2 = " + context);
        rabbitTemplate.convertAndSend("exchange_topic", "topic.kkkkk", context);
    }

}

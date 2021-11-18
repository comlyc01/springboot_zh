package com.rabbitmq.demo.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MQ工作模式
 * 生产者
 */
@Component
public class WorkQueuesSender {


    @Resource
    private RabbitTemplate rabbitTemplate;

    public void workSender(int i) {
        String context = "【work模式】_数据_" + i;
        System.out.println("【work模式】发送者 = " + context);
        // 参数1： 队列，参数2：消息内容
        rabbitTemplate.convertAndSend("workQueues", context);
    }

}

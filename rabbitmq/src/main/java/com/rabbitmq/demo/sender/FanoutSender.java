package com.rabbitmq.demo.sender;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MQ订阅模式
 * 生产者
 */
@Component
public class FanoutSender {


    @Resource
    private RabbitTemplate rabbitTemplate;

    public void fanoutSender(int i) {
        String context = "【订阅模式】_数据_" + i;
        System.out.println("【订阅模式】发送者 = " + context);
        // 参数1：交换机，餐数2：队列名，为空则是该交换机下全部队列，参数3：消息内容
        rabbitTemplate.convertAndSend("exchange_fanout", "", context);
    }
}

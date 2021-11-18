package com.rabbitmq.demo;

import com.rabbitmq.demo.receiver.HelloWorldReceiver;
import com.rabbitmq.demo.sender.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
class DemoApplicationTests {
    @Resource
    private HelloWorldSender helloWorldSender;
    @Resource
    private WorkQueuesSender workQueuesSender;
    @Resource
    private FanoutSender fanoutSender;
    @Resource
    private RoutingSender routingSender;
    @Resource
    private TopicSender topicSender;
    @Resource
    private HelloWorldReceiver helloWorldReceiver;

    /**
     * MQ测试简单模式
     */
    @Test
    void helloWorld() {
        for (int i = 0; i < 100; i++) {
            helloWorldSender.helloSender(i);
        }

    }

    /**
     * MQ测试工作模式
     */
    @Test
    void work() {
        for (int i = 0; i < 100; i++) {
            workQueuesSender.workSender(i);
        }
    }

    /**
     * MQ测试订阅模式
     */
    @Test
    void fanout() {
        for (int i = 0; i < 20; i++) {
            fanoutSender.fanoutSender(i);
        }
    }

    /**
     * MQ测试路由模式
     */
    @Test
    void routing() {
        for (int i = 0; i < 30; i++) {
            routingSender.routingSender1(i);
            routingSender.routingSender2(i);
        }
    }

    /**
     * MQ测试Topic模式
     */
    @Test
    void topic() {
        for (int i = 0; i < 30; i++) {
            topicSender.topicSender1(i);
            topicSender.topicSender2(i);
        }
    }

}

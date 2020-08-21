package com.rabbitmq.demo.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
    public final static String msg1 = "queueTest";
    public final static String msg2 = "queresTest";

    /**
     * 队列1
     * queueTest
     * @return
     */
    @Bean
    public Queue msg1(){
        return new Queue(TopicRabbitConfig.msg1);
    }

    /**
     * 队列2
     * queresTest
     * @return
     */
    @Bean
    public Queue msg2(){
        return new Queue(TopicRabbitConfig.msg2);
    }

    /**
     * 交换机
     * @return
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchangesTest");
    }

    @Bean
    public Binding bindingExchangeMessages1(@Qualifier("msg1") Queue queueMessage, TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("amp.test1");
    }

    @Bean
    public Binding bindingExchangeMessages2(@Qualifier("msg2") Queue queueMessages,TopicExchange exchange){
        return BindingBuilder.bind(queueMessages).to(exchange).with("amp.#");
    }



}

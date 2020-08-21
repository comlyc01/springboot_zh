package com.eureka.demo.hystrix;

import com.eureka.demo.feign.HelloRemote;
import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String Hello(String name) {
        return "hello" +name+", this messge send failed ";
    }
}

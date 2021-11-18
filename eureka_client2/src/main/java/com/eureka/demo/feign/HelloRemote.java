package com.eureka.demo.feign;

import com.eureka.demo.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 此类中的方法和远程服务中contoller中的方法名和参数需保持一致。
 */
@FeignClient(name = "eureka-client01", fallback = HelloRemoteHystrix.class)   // name:远程服务名
public interface HelloRemote {
    @RequestMapping("/hello")
    public String Hello(@RequestParam(value = "name") String name);
}

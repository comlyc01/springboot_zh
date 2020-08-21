package com.eureka.demo.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String index(String name){
        return "hello"+name+",欢迎你使用Feign1";
    }
}

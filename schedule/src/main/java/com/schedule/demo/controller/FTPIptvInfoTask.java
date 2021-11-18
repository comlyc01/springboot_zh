package com.schedule.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component //表示将这个类交给spring容器管理
@PropertySource("classpath:/Quartz.xml")//读取properties配置文件
public class FTPIptvInfoTask {

    private static Logger LOGGER = (Logger) LogManager.getLogger(FTPIptvInfoTask.class);
    private static Map<String, String> propertiesInfo = new HashMap<>();

    //@Scheduled注解表示将这个方法标注为定时任务，触发条件为corn表达式
    //${}用于获取配置文件里面的值，配置文件为key/value的形式即（jobsiptv.schedule=0 0 2 * * ?）
    @Scheduled(cron = "*/5 * * * * ?")
    public void iptvUpLoad() throws Exception {
        //这里面写业务逻辑即可
        System.out.println("执行定时任务方法");
    }
}

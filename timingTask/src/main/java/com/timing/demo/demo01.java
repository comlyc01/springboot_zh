package com.timing.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class demo01 {


    private int count = 0;

    /**
     * 上一次开始执行时间点之后6秒再执行
     * 上一次执行完毕时间点之后6秒再执行
     */
    @Scheduled(cron = "*/6 * * * * ?")
    private void process(){
        System.out.println("这是调度程序任务运行：" + (count++));
    }
}

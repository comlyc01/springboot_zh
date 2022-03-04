package com.schedule.demo.controller;

import java.util.Date;

public class RunnableImpl2 implements Runnable {

    private String name;

    public RunnableImpl2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("RunnableImpl2:[开始]:" + new Date());
        for (int i = 0; i < 50; i++) {
            //for(long k=0;k<100000000;k++);
            System.out.println(name + "::::::" + i);
        }
        System.out.println("RunnableImpl2:[结束]:" + new Date());
    }
}

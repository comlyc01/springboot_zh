package com.schedule.demo.controller;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable {

    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    @Override
    public void run() {
        try {
            //上锁
            lock.lock();
            System.out.println(" 开始等待时间：" + System.currentTimeMillis());
            System.out.println("我陷入了等待...");
            //线程等待
            condition.await();
            //释放锁
            lock.unlock();
            System.out.println("锁释放了!");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("结束等待时间：" + System.currentTimeMillis());
            //通知等待线程
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}

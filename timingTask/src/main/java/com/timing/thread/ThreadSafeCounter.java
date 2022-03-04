package com.timing.thread;

/**
 * 线程安全计数器
 */
public class ThreadSafeCounter {

    private int counter = 0;

    public void increment() {
        synchronized (this) {
            counter++;
        }
    }

    public int get() {
        synchronized (this) {
            return counter;
        }
    }

}

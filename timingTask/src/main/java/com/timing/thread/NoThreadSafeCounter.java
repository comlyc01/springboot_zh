package com.timing.thread;

/**
 * 非线程安全计数器
 */
public class NoThreadSafeCounter {

    private int counter = 0;

    private void increment() {
        counter++;
    }

    public int get() {
        return counter;
    }

}

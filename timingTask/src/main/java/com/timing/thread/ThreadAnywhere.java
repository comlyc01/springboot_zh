package com.timing.thread;

public class ThreadAnywhere {


    public static void main(String[] args) {
        System.out.println("The main method : " + Thread.currentThread().getName());
        Helper helper = new Helper("Java Thread");
        //helper.run();

        // 创建线程
        Thread thread = new Thread(helper);
        // 设置线程名称
        thread.setName("A-Worker-Thread");
        //  启动线程
        thread.start();
    }


    static class Helper implements Runnable {

        private final String message;

        public Helper(String message) {
            this.message = message;
        }

        private void doSomething(String message) {
            System.out.println("The doSomething method :" + Thread.currentThread().getName());
            System.out.println("message = " + message);
        }

        @Override
        public void run() {
            doSomething(message);
        }
    }


}

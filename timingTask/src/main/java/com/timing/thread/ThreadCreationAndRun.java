package com.timing.thread;

public class ThreadCreationAndRun {

    private static volatile String a = "11a";

    public static void main(String[] args) {
        //Thread thread =  new CustomThread();
        //thread.start();
        a = "a210b";
        System.out.println(a);

    }


    static class CustomThread extends Thread {
        @Override
        public void run() {
            System.out.println("Running... ...");
        }
    }


}

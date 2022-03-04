package com.schedule.demo.controller;

import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo {
    /*public static void main(String[] args) {
        RunnableImpl ri1=new RunnableImpl("李白");
        RunnableImpl2 ri2=new RunnableImpl2("屈原");
        Thread t1=new Thread(ri1);
        Thread t2=new Thread(ri2);
        t1.start();
        t2.start();
    }*/

    /*private static String count = "";
    public static void main(String[] args) {
        int a = 10;
        //final String[] aaa = {""};
        new Thread(new Runnable() {
            public void run() {
                count = aaa(a);
                System.out.println("aaa = " + count);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                bbb(a);
            }
        }).start();
    }

    private static String aaa(int i){
        System.out.println("aaa:[开始]:" + new Date());
        *//*for (int i = 0; i < 100; i++) {
            System.out.println("方法aaa： "+ i);
        }*//*
        System.out.println("aaa:[结束]:" + new Date());
        return  "000";
    }

    private static void bbb(int cout){
        System.out.println("bbb:[开始]:" + new Date());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < cout; i++) {

            System.out.println("方法bbb： "+ i);
        }
        System.out.println("bbb:[结束]:" + new Date());
    }*/

    /**
     * 多线程工具类CountDownLatch的一个用法示例
     *
     * @param args
     */
   /* public static void main(String[] args) {
        //执行多线程之前的代码，本例中就是通知大家到目的地
        System.out.println("通知，大家快来这个地方");
        System.out.println("=========== 可以理解为多线程之前 ===========");

        //总的线程数为5（大家可以换这个变量，进行调试）

        //创建一个CountDownLatch类，构造入参线程数
        CountDownLatch countDownLatch = new CountDownLatch(3);

        //创建5个线程，并发同步执行

            new Thread(new Runnable() {
                @Override
                public void run() {
                    //10000以内的随机数，作为等待时间
                    int waitMillis = new Random().nextInt(10000);

                    try {
                        //模拟线程执行，耗费一定的时间（本例是10秒内）
                        Thread.sleep(waitMillis);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //线程执行完毕，报告结果
                    System.out.println(Thread.currentThread().getName() + "已到达目的地，所用毫秒数：" + waitMillis);

                    //CountDownLatch类计数减一
                    //注意，CountDownLatch类的实例要在新建多线程之前，然后入参需要
                    //统一完成后才往下执行的线程数。然后每个线程执行完后，或者
                    //部分执行完后，调用之前创建的CountDownLatch类的实例的countDown方法
                    countDownLatch.countDown();
                    System.out.println("countDownLatch = " + countDownLatch.toString());
                }
            }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //10000以内的随机数，作为等待时间
                int waitMillis = new Random().nextInt(10000);

                try {
                    //模拟线程执行，耗费一定的时间（本例是10秒内）
                    Thread.sleep(waitMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //线程执行完毕，报告结果
                System.out.println(Thread.currentThread().getName() + "已到达目的地，所用毫秒数：" + waitMillis);

                //CountDownLatch类计数减一
                //注意，CountDownLatch类的实例要在新建多线程之前，然后入参需要
                //统一完成后才往下执行的线程数。然后每个线程执行完后，或者
                //部分执行完后，调用之前创建的CountDownLatch类的实例的countDown方法
                countDownLatch.countDown();
                System.out.println("countDownLatch = " + countDownLatch.toString());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //10000以内的随机数，作为等待时间
                int waitMillis = new Random().nextInt(10000);

                try {
                    //模拟线程执行，耗费一定的时间（本例是10秒内）
                    Thread.sleep(waitMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //线程执行完毕，报告结果
                System.out.println(Thread.currentThread().getName() + "已到达目的地，所用毫秒数：" + waitMillis);

                //CountDownLatch类计数减一
                //注意，CountDownLatch类的实例要在新建多线程之前，然后入参需要
                //统一完成后才往下执行的线程数。然后每个线程执行完后，或者
                //部分执行完后，调用之前创建的CountDownLatch类的实例的countDown方法
                countDownLatch.countDown();
                System.out.println("countDownLatch = " + countDownLatch.toString());
            }
        }).start();


        try {
            //下面这句代码，CountDownLatch就阻塞在这里了
            //直到countDown()到0了（从构造入参的线程数开始减）
            //也即是所有线程都countDown了，
            //则解除阻塞，代码继续往下执行
            //注意，这句代码放在多线程countDown之后，多线程全部完成后
            //继续往下执行的代码之前，起一个分界线的作用
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //由于CountDownLatch发挥的作用，等到上面的5个线程都执行完毕了，
        //也就是都打印了"已到达目的地"，接下来才会往下执行，打印下面这句话
        System.out.println("=========== 可以理解为多线程之后 ===========");
        System.out.println("大家都到齐了，那就开始吧");
    }*/
    public static void main(String[] args) throws InterruptedException {
        RunnableImpl runnable = new RunnableImpl();
        RunnableImpl r1 = new RunnableImpl();
        Thread t1 = new Thread(r1);
        t1.start();
        Thread.sleep(3000);
        runnable.signal();

    }

    private static void aaa() {
        System.out.println(Thread.currentThread().getName() + "进入aaa方法: " + LocalTime.now());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "离开aaa方法: " + LocalTime.now());

    }

    private static void bbb() {
        System.out.println(Thread.currentThread().getName() + "进入bbb方法: " + LocalTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "离开bbb方法: " + LocalTime.now());
    }

    private static void ccc() {
        System.out.println(Thread.currentThread().getName() + "进入ccc方法: " + LocalTime.now());
        try {
            Thread.sleep(65000);
            String a = null;
            String substring = a.substring(0, 7);
            System.out.println("substring = " + substring);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "离开ccc方法: " + LocalTime.now());
    }


}

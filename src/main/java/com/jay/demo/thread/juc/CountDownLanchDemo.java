package com.jay.demo.thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * author JayNing
 * created by 2020/7/3 13:53
 *
 * 让一些线程堵塞直到另一个线程完成一系列操作后才被唤醒。CountDownLatch 主要有两个方法，
 * 当一个或多个线程调用 await 方法时，调用线程会被堵塞，其他线程调用 countDown 方法会将计数减一
 * （调用 countDown 方法的线程不会堵塞），当计数其值变为零时，因调用 await 方法被堵塞的线程会被唤醒，继续执行。
 * 类似生活场景：关门：等到商场里面所有的人都走了，才能够关门。
 *
 **/
public class CountDownLanchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + " 离开了...");
            }, "线程" + i).start();
        }
        countDownLatch.await();
        System.out.println("保安把门给关了...");
    }
}

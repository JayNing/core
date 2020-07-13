package com.jay.demo.thread.juc;

import java.util.concurrent.Semaphore;

/**
 * author JayNing
 * created by 2020/7/3 13:54
 *
 * semaphore 也就是我们常说的信号灯， semaphore 可以控
 * 制同时访问的线程个数
 *
 * 抢车位是最典型的例子
 **/
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(); // 获取一个许可
                    System.out.println(Thread.currentThread().getName() + " 抢到车位...");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + " 离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); // 释放一个许可
                }
            }, "线程 " + i).start();
        }
    }
}

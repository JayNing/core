package com.jay.demo.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * author JayNing
 * created by 2020/7/2 14:10
 **/
public class InterruptDemo1 {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("Num: " + i);
        },"InterruptDemo1");

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        thread.interrupt();

        System.out.println("thread.isInterrupted() = " + thread.isInterrupted());
        int i = 1 >> 4;
        int j = 1 << 30;
        System.out.println("1 >> 4 = " + i);
        System.out.println("1 << 30 = " + j);
    }
}

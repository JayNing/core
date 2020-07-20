package com.jay.demo.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * author JayNing
 * created by 2020/7/2 14:10
 **/
public class InterruptDemo2 {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                i++;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Num: " + i);
        },"InterruptDemo2");

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        thread.interrupt();

        System.out.println(thread.isInterrupted());
    }
}

package com.jay.demo.thread.threadlocal;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * author JayNing
 * created by 2020/7/20 17:51
 **/
public class ThreadLocalDemo1 {
    public static void main(String[] args) {
        //新建一个threadLocal
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        //新建一个随机数类
        Random random = new Random();
        //使用java8的Stream新建5个线程
        IntStream.range(0,5).forEach(a -> {
            new Thread(() -> {
                //为每一个线程设置响应的local值
                threadLocal.set(a + " " + random.nextInt(10));
                System.out.println("线程和local分别为" + threadLocal.get());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
    }
}

package com.jay.demo.thread.customlock;

import java.util.concurrent.CountDownLatch;

/**
 * ClassName: TestAQS
 * Description:
 * date: 2020/11/17 14:18
 *
 * @author ningjianjian
 */
public class TestAQS {
    static volatile int m=0;
    public static void main(String[] args) throws InterruptedException {
        MyLock lock = new MyLock();
        CountDownLatch latch = new CountDownLatch(100);
        for(int i=0;i<100;i++) {
            new Thread(()->{
                lock.lock();
                try {
                    for(int j=0;j<100;j++) {
                        m++;
                    }
                }finally {
                    lock.unlock();
                }
                latch.countDown();
            }).start();
        }
        latch.await();//等他们都执行完
        System.out.println(m);
    }
}

package com.interview.core.thread;

import org.junit.Test;

/**
 * ClassName: ThreadDemo
 * Description:
 * date: 2021/2/19 17:18
 *
 * @author ningjianjian
 */
public class ThreadDemo {

    @Test
    public void test1(){
        Thread a = new Thread(() -> {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("a -> i = " + i);
            }
        }, "aThread");

        Thread b = new Thread(() -> {
            for (int i = 0; i < 10; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("b -> i = " + i);
            }
        }, "bThread");

        a.start();
        b.start();
        //暂停当前正在执行的线程对象，并执行其他线程
//        a.yield();
        /**
         * static boolean interrupted()
         * 测试当前线程是否已经中断。
         * boolean isAlive()
         * 测试线程是否处于活动状态。
         * boolean isDaemon()
         * 测试该线程是否为守护线程。
         * boolean isInterrupted()
         * 测试线程是否已经中断。
         * void join()
         * 等待该线程终止。
         * void join(long millis)
         * 等待该线程终止的时间最长为 millis 毫秒。
         * void join(long millis, int nanos)
         * 等待该线程终止的时间最长为 millis 毫秒 + nanos 纳秒。
         */

    }

}

package com.interview.core.thread;

import org.junit.Test;

/**
 * ClassName: InterruptDemo
 * Description: interrupt()方法是用于中断线程的，但是实质上，它的使用效果并不会停止一个正在运行的线程，
 * 仅仅是在线程中打了一个停止的标记而已，需要加入一个判断才实现停止线程的功能。
 * date: 2021/2/19 18:14
 *
 * @author ningjianjian
 */
public class InterruptDemo {

    public static void main(String[] args) {
        try {
            Thread a = new Thread(() -> {
                for (int i = 0; i < 500000; i++){
                    System.out.println("i = " + i);
                }
            });
            a.start();
            Thread.sleep(1000);
            a.interrupt();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 运行结果：完成打印，线程并没有停止
     */
}

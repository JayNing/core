package com.interview.core.thread.interrupt;

/**
 * ClassName: InterruptedDemo
 * Description:  interrupted()检测当前线程是否中断，如果当前线程处于中断状态，在首次调用该方法时会返回true，标识当前线程已经中断；
 * 该方法具有在执行后清除状态标识的功能，即如果连续两次调用该方法，则第一次会返回true，第二次会返回false
 * date: 2021/2/19 18:27
 *
 * @author ningjianjian
 */
public class InterruptedDemo {

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 50000; i++){
                System.out.println("i = " + i);
            }
        });
        a.start();
        Thread.currentThread().interrupt();    //中断当前线程, 测试Thread.interrupted()的返回值

        System.out.println("是否停止1?: " + Thread.interrupted());
        System.out.println("是否停止2?: " + Thread.interrupted());
    }

    /**
     * 本例通过设置Thread.currentThread().interrupt();来测试Thread.interrupted()，
     * 连续两次调用该方法，第一次的返回结果都是true，第二次的返回结果是false，这表明当前线程main中断过，
     * 原因是Thread.interrupted()在第一次调用时捕捉到了中断标记，在第二次调用的时清除了该标记位。
     */

}

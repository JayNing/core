package com.interview.core.thread.interrupt;

/**
 * ClassName: IsInterruptedDemo
 * Description:  isInterrupted()检测该线程是否中断，线程的中断状态不会受到该方法的影响，即连续调用该方法，在执行后不会清除状态标识。
 *               并且isInterrupted()不是静态方法，不能直接使用Thread.isInterrupted()调用
 * date: 2021/2/19 18:33
 *
 * @author ningjianjian
 */
public class IsInterruptedDemo {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            for (int i = 0; i < 100000; i++){
                System.out.println("i = " + i);
            }
        });
        a.start();
        a.interrupt();    //中断a线程, 测试Thread.interrupted()的返回值

        System.out.println("是否停止1?: " + a.isInterrupted());
        System.out.println("是否停止2?: " + a.isInterrupted());
    }
}

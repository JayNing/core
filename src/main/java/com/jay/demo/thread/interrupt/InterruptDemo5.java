package com.jay.demo.thread.interrupt;

/**
 * author JayNing
 * created by 2020/7/20 14:12
 *  【使用 interrupt() + isInterrupted()来中断线程】
 *
 *     this.interrupt()方法: 作用是中断线程。
 *
 *   　Thread.interrupted():测试当前线程是否已经中断（静态方法）。如果连续调用该方法，则第二次调用将返回false。
 *   在api文档中说明interrupted()方法具有清除状态的功能。执行后具有将状态标识清除为false的功能。
 *
 * 　　this.isInterrupted():测试线程是否已经中断，但是不能清除状态标识。
 **/
public class InterruptDemo5 {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("线程启动了");
                while (!isInterrupted()) {
                    System.out.println(isInterrupted());//调用 interrupt 之后为true
                }
                System.out.println("线程结束了");
            }
        };
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("线程是否被中断：" + thread.isInterrupted());//true
    }

}

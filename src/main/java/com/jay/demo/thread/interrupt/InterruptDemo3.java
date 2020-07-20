package com.jay.demo.thread.interrupt;

/**
 * author JayNing
 * created by 2020/7/20 14:12
 *  使用退出标志中断线程
 **/
public class InterruptDemo3 {

    public static volatile boolean exit =false;  //退出标志

    public static void main(String[] args) {
        new Thread() {
            public void run() {
                System.out.println("线程启动了");
                while (!exit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程结束了");
            }
        }.start();

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        exit = true;//5秒后更改退出标志的值,没有这段代码，线程就一直不能停止
    }

}

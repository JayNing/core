package com.jay.demo.thread.interrupt;

/**
 * author JayNing
 * created by 2020/7/20 14:12
 * 【使用 interrupt() + InterruptedException来中断线程】
 *  原理：
 *  Thread.interrupt()方法只是改变中断状态，不会中断一个正在运行的线程。
 *  支持线程中断的方法（也就是线程中断后会抛出interruptedException的方法）就是在监视线程的中断状态，一旦线程的中断状态被置为“中断状态”，
 *  就会抛出中断异常。这一方法实际完成的是，给受阻塞的线程发出一个中断信号，这样受阻线程检查到中断标识，就得以退出阻塞的状态。
 *
 *   更确切的说，如果线程被Object.wait, Thread.join和Thread.sleep三种方法之一阻塞，此时调用该线程的interrupt()方法，那么该线
 *   程将抛出一个 InterruptedException中断异常（该线程必须事先预备好处理此异常），从而提早地终结被阻塞状态。如果线程没有被阻塞，
 *   这时调用 interrupt()将不起作用，直到执行到wait(),sleep(),join()时,才马上会抛出 InterruptedException。
 **/
public class InterruptDemo4 {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
                System.out.println("线程启动了");
                try {
                    Thread.sleep(1000 * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程结束了");
            }
        };
        thread.start();

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //作用是：在线程阻塞时抛出一个中断信号，这样线程就得以退出阻塞的状态
        thread.interrupt();
    }

}

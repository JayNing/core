package com.interview.core.thread.interrupt;

/**
 * ClassName: JoinDemo
 * Description: join() 该方法的作用是“等待该线程终止”，一直等待，直到线程终止，而带参数的方法的作用是“ 等待该线程终止,至多等待多少毫秒数 (或毫秒数+纳秒数)”。
 * date: 2021/2/19 18:42
 *
 * @author ningjianjian
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
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
        /**
         * 查看join(long millis)方法的源代码，首先该方式是synchronized，其次它的实现原理是调用了wait()方法。
         * 所以join()和sleep()这两个方法的区别，本质上是wait()和sleep()这两个方法的区别
         */
        a.join(); //等待a线程执行结束，才执行b线程
        b.start();
    }

    /**
     * wait()和sleep()的区别：
     *
     * 这两个方法来自不同的类，wait()方法来自Object类，sleep()方法来自Thread类；
     * wait()方法有三种形式：wait()、wait(long timeout)、wait(long timeout, int nanos)，而sleep()方法两种形式：sleep(long millis)、sleep(long millis, int nanos)，即sleep()方法没有无参形式。其次，sleep()方法是静态方法。
     * 其实区别主要还是来自于这两个方法对同步的处理上：wait()方法会释放锁，sleep()方法不释放锁。
     */
}

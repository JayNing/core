package com.jay.demo.thread;

/**
 * author JayNing
 * created by 2020/7/2 14:49
 **/
public class SynchronizedDemo {
    private static int count = 0;
    Object lock = new Object();

    /**
     * 实现某个对象的对象锁
     */
    public void inc5(){
        synchronized (lock){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }
    /**
     * 实现当前实例对象的对象锁
     */
    public void inc4(){
        synchronized (this){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
    }

    /**
     * Synchronized修饰的普通方法
     */
    public synchronized void inc3(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }

    /**
     * Synchronized修饰的静态方法
     */
    public static synchronized void inc2(){
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
    }


    /**
     *实现类级锁
     */
    public static void inc(){
        synchronized (SynchronizedDemo.class){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++){
            new Thread(()->{SynchronizedDemo.inc();}).start();
        }
        Thread.sleep(2000);
        System.out.println("inc 查看运行结果，count = " + count + ", 加锁是否成功：" + (count == 1000 ? "是" : "否"));

        count = 0;
        for (int i = 0; i < 1000; i++){
            new Thread(()->{SynchronizedDemo.inc2();}).start();
        }
        Thread.sleep(2000);
        System.out.println("inc2 查看运行结果，count = " + count + ", 加锁是否成功：" + (count == 1000 ? "是" : "否"));

        count = 0;
        for (int i = 0; i < 1000; i++){
            new Thread(()->{
                SynchronizedDemo demo = new SynchronizedDemo();
                demo.inc3();
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("inc3 查看运行结果，count = " + count + ", 加锁是否成功：" + (count == 1000 ? "是" : "否"));

        count = 0;
        SynchronizedDemo demo = new SynchronizedDemo();
        for (int i = 0; i < 1000; i++){
            new Thread(()->{
                demo.inc3();
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("inc3 （同一个对象） 查看运行结果，count = " + count + ", 加锁是否成功：" + (count == 1000 ? "是" : "否"));


        count = 0;
        for (int i = 0; i < 1000; i++){
            new Thread(()->{
                SynchronizedDemo demo4 = new SynchronizedDemo();
                demo4.inc4();
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("inc4 查看运行结果，count = " + count + ", 加锁是否成功：" + (count == 1000 ? "是" : "否"));


        count = 0;
        SynchronizedDemo demo4 = new SynchronizedDemo();
        for (int i = 0; i < 1000; i++){
            new Thread(()->{
                demo4.inc4();
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("inc4 （同一个对象） 查看运行结果，count = " + count + ", 加锁是否成功：" + (count == 1000 ? "是" : "否"));

        count = 0;
        for (int i = 0; i < 1000; i++){
            new Thread(()->{
                SynchronizedDemo demo5 = new SynchronizedDemo();
                demo5.inc5();
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("inc5 查看运行结果，count = " + count + ", 加锁是否成功：" + (count == 1000 ? "是" : "否"));


        count = 0;
        SynchronizedDemo demo5 = new SynchronizedDemo();
        for (int i = 0; i < 1000; i++){
            new Thread(()->{
                demo5.inc5();
            }).start();
        }
        Thread.sleep(2000);
        System.out.println("inc5 （同一个对象） 查看运行结果，count = " + count + ", 加锁是否成功：" + (count == 1000 ? "是" : "否"));

    }
}

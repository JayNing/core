package com.interview.core.thread;

/**
 * ClassName: Test_Thread_Method
 * Description: 测试Thread类的常用方法
 * date: 2021/2/19 18:40
 *
 * @author ningjianjian
 */
public class Test_Thread_Method implements Runnable {

    @Override
    public void run() {

        //用于输出当前执行线程的信息
        System.out.println("名字: "+Thread.currentThread().getName());
        System.out.println("id："+Thread.currentThread().getId());
        System.out.println("优先级："+Thread.currentThread().getPriority());
        System.out.println("状态："+Thread.currentThread().getState());
        System.out.println("是否存活："+Thread.currentThread().isAlive());
        System.out.println("所属线程组："+Thread.currentThread().getThreadGroup());
        System.out.println("该线程组活动线程数目："+Thread.activeCount());
        System.out.println("线程信息String: " + Thread.currentThread().toString());
        System.out.println("是否持有锁: " + Thread.holdsLock(this));
        synchronized (this) {
            System.out.println("是否持有锁: " + Thread.holdsLock(this));
        }


    }

    public static void main(String[] args) {

        Test_Thread_Method r = new Test_Thread_Method();
        Thread t = new Thread(r, "test");  //在创建线程时指定线程名字为"test"
        t.start();


        try {
            Thread.sleep(1000);  //休眠1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //用于输出线程t停止后当前线程的信息
        System.out.println();
        System.out.println("名字: "+Thread.currentThread().getName());
        System.out.println("id："+Thread.currentThread().getId());
        System.out.println("优先级："+Thread.currentThread().getPriority());
        System.out.println("状态："+Thread.currentThread().getState());
        System.out.println("是否存活："+Thread.currentThread().isAlive());
        System.out.println("所属线程组："+Thread.currentThread().getThreadGroup());
        System.out.println("该线程组活动线程数目："+Thread.activeCount());

        //用于输出线程t停止后的状态
        System.out.println();
        System.out.println("名字: "+t.getName());
        System.out.println("状态："+t.getState());
        System.out.println("是否存活："+t.isAlive());
    }

}
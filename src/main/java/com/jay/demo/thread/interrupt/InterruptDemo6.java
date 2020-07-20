package com.jay.demo.thread.interrupt;

/**
 * author JayNing
 * created by 2020/7/20 14:12
 *  【测试 interrupted】
 *   interrupted()是静态方法：内部实现是调用的当前线程的isInterrupted()，并且会重置当前线程的中断状态。
 *
 * 　　　　测试当前线程是否已经中断（静态方法）。返回的是上一次的中断状态，并且会清除该状态，所以连续调用两次，第一次返回true，第二次返回false。
 *
 * 　　isInterrupted()是实例方法，是调用该方法的对象所表示的那个线程的isInterrupted()，不会重置当前线程的中断状态
 *
 * 　　　　测试线程当前是否已经中断，但是不能清除状态标识。
 **/
public class InterruptDemo6 {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            public void run() {
               try {
                   Thread.sleep(1000 * 100);
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        };
        thread.start();

        //中断对象线程
        thread.interrupt();
        //中断main主线程
        Thread.currentThread().interrupt();

        System.out.println(thread.isInterrupted());
        System.out.println("第一次调用返回值：" + Thread.interrupted());//true
        System.out.println(thread.isInterrupted());
        System.out.println("第二次调用返回值：" + Thread.interrupted());//true
    }

}

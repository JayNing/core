package com.interview.core.thread.interrupt;

/**
 * ClassName: PrintABC
 * Description: 功能：三个线程，一个打印A，一个打印B，一个打印C，打印出6个连续的ABC。
 *
 * join()的作用分析
 * join()方法具有使线程依次串行执行的作用，也就是使线程排队运行。对于t.join()语句，其中的等待关系如下：
 * join()方法的作用是使线程t正常执行run()方法中的任务，而使当前线程s一直等待线程t终止，
 * 在很多情况下，主线程生成并起动了子线程，所以线程s有可能是主线程，也有可能是其它子线程。
 * 也就是t.join()方法后面的代码，只有等到t线程结束了才能执行。join()方法的使用方式是在线程t启动后直接调用。
 *
 * date: 2021/2/19 18:48
 *
 * @author ningjianjian
 */
public class PrintABC implements Runnable {
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("A")){
            System.out.print("A");
        }
        if(Thread.currentThread().getName().equals("B")){
            System.out.print("B");
        }
        if(Thread.currentThread().getName().equals("C")){
            System.out.print("C");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i=0; i<6; i++){
            PrintABC r = new PrintABC();
            Thread A = new Thread(r, "A");
            A.start();
            A.join();
            Thread B = new Thread(r, "B");
            B.start();
            B.join();
            Thread C = new Thread(r, "C");
            C.start();
            C.join();
        }
    }
}
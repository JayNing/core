package com.thread;

import com.jay.demo.thread.DynamicDataSourceEntity;

/**
 * @Author JAY
 * @Date 2019/7/8 14:12
 * @Description TODO
 **/
public class ThreadLocalTest {

    public static void main(String[] args) {
        DynamicDataSourceEntity dataSourceEntity = new DynamicDataSourceEntity();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                dataSourceEntity.set(1990);
                System.out.println(dataSourceEntity.get());
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
//                dataSourceEntity.set(2000);
                System.out.println(dataSourceEntity.get());
            }
        });

        thread1.start();
        thread2.start();




    }


}

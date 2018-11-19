package com.jay.demo.design.singleton;

/**
 * @Author JAY
 * @Date 2018/11/19 22:13
 * @Description 双重锁定------单例（防止多线程时，创建多个实例）
 **/
public class DoblueCheckLockingSingleton {

    private static DoblueCheckLockingSingleton instance;
    private static Object lock = new Object();

    private DoblueCheckLockingSingleton(){}

    public DoblueCheckLockingSingleton getInstance(){
        if (instance == null){
            synchronized (lock){
                if (instance == null){
                    instance = new DoblueCheckLockingSingleton();
                }
            }
        }
        return instance;
    }

}

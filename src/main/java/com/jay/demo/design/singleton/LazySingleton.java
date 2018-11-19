package com.jay.demo.design.singleton;

/**
 * @Author JAY
 * @Date 2018/11/19 22:08
 * @Description 懒汉-----单例模式
 **/
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton(){}

    public LazySingleton getInstance(){
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

}

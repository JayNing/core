package com.jay.demo.design.singleton;

/**
 * @Author JAY
 * @Date 2018/11/19 22:07
 * @Description 饿汉----单例模式
 **/
public class Hungury {

    private static Hungury hungury = new Hungury();

    private Hungury(){}

    public Hungury getInstance(){
        return hungury;
    }

}

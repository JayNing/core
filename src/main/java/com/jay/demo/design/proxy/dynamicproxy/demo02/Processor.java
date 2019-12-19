package com.jay.demo.design.proxy.dynamicproxy.demo02;

/**
 * author JayNing
 * created by 2019/12/19 19:35
 **/
public class Processor {

    public void preprocess(){
        System.out.println("进行前置处理。。。");
    }

    public void postprocess(){
        System.out.println("进行后置处理。。。");
    }

}

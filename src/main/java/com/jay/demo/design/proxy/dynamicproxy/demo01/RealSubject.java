package com.jay.demo.design.proxy.dynamicproxy.demo01;

/**
 * @Author JAY
 * @Date 2018/11/5 23:04
 * @Description 真实的角色
 **/
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("我是实际执行的方法");
    }
}

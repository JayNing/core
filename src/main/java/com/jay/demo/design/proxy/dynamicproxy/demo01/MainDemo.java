package com.jay.demo.design.proxy.dynamicproxy.demo01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author JAY
 * @Date 2018/11/5 23:08
 * @Description 主测试demo
 **/
public class MainDemo {

    public static void main(String[] args) {
        RealSubject rs = new RealSubject();
        InvocationHandler handler = new DynamicSubject(rs);
        Class cls = rs.getClass();
        //以下是分解步骤
		/*
		Class c = Proxy.getProxyClass(cls.getClassLoader(), cls.getInterfaces());
		Constructor ct = c.getConstructor(new Class[]{InvocationHandler.class});
		Subject subject =(Subject) ct.newInstance(new Object[]{handler});
		*/

        //以下是一次性生成
        Subject subject = (Subject)Proxy.newProxyInstance(cls.getClassLoader(),cls.getInterfaces(), handler);
        subject.request();
    }
}

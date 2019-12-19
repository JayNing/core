package com.jay.demo.design.proxy.dynamicproxy.demo02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * author JayNing
 * created by 2019/12/19 19:33
 **/
public class CollectionMain {

    public static void main(String[] args) {
        //不适用动态代理
        CollectionService collectionService = new CollectionServiceImpl();
        collectionService.collectionData("MDM01");

        //使用代理类对收集操作添加前后置处理
        InvocationHandler handler  = new CollectionDynamicProxy(new Processor(),new CollectionServiceImpl());
        CollectionService cs =
                (CollectionService) Proxy.newProxyInstance(CollectionServiceImpl.class.getClassLoader(),
                        CollectionServiceImpl.class.getInterfaces(),handler);
        cs.collectionData("MDM02");
    }

}

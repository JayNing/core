package com.jay.demo.design.proxy.dynamicproxy.demo02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * author JayNing
 * created by 2019/12/19 19:36
 **/
public class CollectionDynamicProxy implements InvocationHandler {

    private Processor processor;
    //真实对象的引用
    private Object realExecutor;

    public CollectionDynamicProxy(Processor processor,Object realExecutor) {
        this.realExecutor = realExecutor;
        this.processor = processor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        processor.preprocess();
        method.invoke(realExecutor,args);
        processor.postprocess();
        return null;
    }
}

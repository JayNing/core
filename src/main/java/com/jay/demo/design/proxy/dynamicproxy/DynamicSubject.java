package com.jay.demo.design.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author JAY
 * @Date 2018/11/5 23:05
 * @Description   动态代理， 它是在运行时生成的class，在生成它时你必须提供一组interface给它，
 * 然后该class就宣称它实现了这些interface。
 *  * 你当然可以把该class的实例当作这些interface中的任何一个来用。 当然啦，这个Dynamic
 *  * Proxy其实就是一个Proxy，它不会替你作实质性的工作， 在生成它的实例时你必须提供一个handler，由它接管实际的工作。
 **/
public class DynamicSubject implements InvocationHandler {

    private Object sub; //真实对象的引用

    DynamicSubject(Object sub){
        this.sub = sub;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling " + method);
        //实际调用
        method.invoke(sub,args);
        System.out.println("after  calling " + method);
        return null;
    }
}

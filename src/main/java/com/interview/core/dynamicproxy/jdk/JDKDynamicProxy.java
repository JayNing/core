package com.interview.core.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

/**
 * ClassName: JDKDynamicProxy
 * Description:
 * date: 2021/2/20 11:08
 *
 * @author ningjianjian
 */
public class JDKDynamicProxy {

    public static Object getProxy(Object object){
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(),
                new SmsInvocationHandler(object));
    }

}

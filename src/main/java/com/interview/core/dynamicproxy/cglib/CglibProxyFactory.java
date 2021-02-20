package com.interview.core.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * ClassName: CglibProxyFactory
 * Description:
 * date: 2021/2/20 12:37
 *
 * @author ningjianjian
 */
public class CglibProxyFactory {
    public static Object getProxy(Class < ? > clazz){
        //创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        //设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置被动态代理类
        enhancer.setSuperclass(clazz);
        //设置方法拦截器
        enhancer.setCallback(new CglibMethodInterceptor());
        //创建代理类
        return enhancer.create();
    }
}

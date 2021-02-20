package com.interview.core.dynamicproxy.cglib;

/**
 * ClassName: CglibProxyDemo
 * Description:
 * date: 2021/2/20 12:41
 *
 * @author ningjianjian
 */
public class CglibProxyDemo {
    public static void main(String[] args) {
        AliSmsService proxy = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        proxy.send("123");
    }
}

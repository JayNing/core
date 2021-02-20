package com.interview.core.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ClassName: SmsInvocationHandler
 * Description:
 * date: 2021/2/20 11:05
 *
 * @author ningjianjian
 */
public class SmsInvocationHandler implements InvocationHandler {

    private Object smsService;

    public SmsInvocationHandler(Object smsService) {
        this.smsService = smsService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before send msg ...");
        method.invoke(smsService, args);
        System.out.println("after send msg ...");
        return null;
    }
}

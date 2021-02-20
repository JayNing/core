package com.interview.core.dynamicproxy.jdk;

/**
 * ClassName: JDKDynamicProxyDemo
 * Description:
 * date: 2021/2/20 11:08
 *
 * @author ningjianjian
 */
public class JDKDynamicProxyDemo {

    public static void main(String[] args) {

        SmsService smsService = (SmsService) JDKDynamicProxy.getProxy(new SmsServiceImpl());
        smsService.sendMsg();
        smsService.sendEmail();

//        SmsService smsService2 = new SmsServiceImpl();
//        smsService2.sendMsg();

    }

}

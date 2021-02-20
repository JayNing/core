package com.interview.core.dynamicproxy.jdk;

/**
 * ClassName: SmsServiceImpl
 * Description:
 * date: 2021/2/20 11:04
 *
 * @author ningjianjian
 */
public class SmsServiceImpl implements SmsService{
    @Override
    public void sendMsg() {
        System.out.println("发送sms");
    }

    @Override
    public void sendEmail() {
        System.out.println("发送email");
    }
}

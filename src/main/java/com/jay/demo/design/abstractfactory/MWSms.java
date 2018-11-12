package com.jay.demo.design.abstractfactory;

/**
 * @Author JAY
 * @Date 2018/11/11 16:36
 * @Description 梦网短信
 **/
public class MWSms implements ISMS{
    @Override
    public void sendSms() {
        System.out.println("发送梦网短信");
    }
}

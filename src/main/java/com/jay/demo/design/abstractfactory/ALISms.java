package com.jay.demo.design.abstractfactory;

/**
 * @Author JAY
 * @Date 2018/11/11 16:36
 * @Description 阿里短信
 **/
public class ALISms implements ISMS{
    @Override
    public void sendSms() {
        System.out.println("发送阿里短信");
    }
}

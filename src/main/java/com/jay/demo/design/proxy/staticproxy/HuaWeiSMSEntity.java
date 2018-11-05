package com.jay.demo.design.proxy.staticproxy;

/**
 * @Author JAY
 * @Date 2018/11/5 22:47
 * @Description 华为短信服务实体类
 **/
public class HuaWeiSMSEntity implements SendSmsInterface{

    @Override
    public void sendSms(String name) {
        System.out.println("华为服务实际发送短信。。。。，发送短信给：" + name);
    }
}

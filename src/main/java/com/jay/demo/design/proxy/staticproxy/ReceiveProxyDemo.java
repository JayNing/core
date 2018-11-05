package com.jay.demo.design.proxy.staticproxy;

/**
 * @Author JAY
 * @Date 2018/11/5 22:51
 * @Description 接收短信者demo
 **/
public class ReceiveProxyDemo {
    public static void main(String[] args) {
        MovitechProxyEntity movitechProxyEntity = new MovitechProxyEntity();
        movitechProxyEntity.sendSms("张三");
    }
}

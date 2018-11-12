package com.jay.demo.design.abstractfactory;

/**
 * @Author JAY
 * @Date 2018/11/11 16:44
 * @Description QQ邮件
 **/
public class QQEmail implements IEmail {
    @Override
    public void sendEmail() {
        System.out.println("发送QQ邮件");
    }
}

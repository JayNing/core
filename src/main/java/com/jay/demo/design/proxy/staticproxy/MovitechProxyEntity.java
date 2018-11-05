package com.jay.demo.design.proxy.staticproxy;

/**
 * @Author JAY
 * @Date 2018/11/5 22:49
 * @Description 盟拓作为华为短信服务代理商
 **/
public class MovitechProxyEntity implements SendSmsInterface{

    private HuaWeiSMSEntity huaWeiSMSEntity;

    @Override
    public void sendSms(String name) {
        System.out.println("盟拓代理商形式上发送短信。。。。，发送短信给：" + name);
        if (huaWeiSMSEntity == null){
            huaWeiSMSEntity = new HuaWeiSMSEntity();
        }
        huaWeiSMSEntity.sendSms(name);
    }
}

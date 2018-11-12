package com.jay.demo.design.abstractfactory;

/**
 * @Author JAY
 * @Date 2018/11/11 16:41
 * @Description 反射 + 抽象工厂demo
 **/
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        String smsType = "MW";
        try {
            ISMS sms = MessageFacatory.createSMS(smsType);
            sms.sendSms();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        System.out.println("--------------------");
        String emailType = "Fox";
        try {
            IEmail email = MessageFacatory.createEmail(emailType);
            email.sendEmail();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}

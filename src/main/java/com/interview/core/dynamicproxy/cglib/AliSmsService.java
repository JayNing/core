package com.interview.core.dynamicproxy.cglib;

/**
 * ClassName: AliSmsService
 * Description:
 * date: 2021/2/20 12:36
 *
 * @author ningjianjian
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}

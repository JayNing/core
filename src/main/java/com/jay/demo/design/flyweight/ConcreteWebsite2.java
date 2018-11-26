package com.jay.demo.design.flyweight;

/**
 * @Author JAY
 * @Date 2018/11/25 14:56
 * @Description 具体的网站类
 **/
public class ConcreteWebsite2 extends AbstractWebsite2 {

    private String type;

    public ConcreteWebsite2(String type){
        this.type = type;
    }
    @Override
    public void use(User user) {
        System.out.println("网站类型：" + type + ", 用户账号:" + user.getUsername());
    }
}

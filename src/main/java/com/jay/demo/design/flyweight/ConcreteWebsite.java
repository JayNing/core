package com.jay.demo.design.flyweight;

/**
 * @Author JAY
 * @Date 2018/11/25 14:56
 * @Description 具体的网站类
 **/
public class ConcreteWebsite extends AbstractWebsite {

    private String type;

    public ConcreteWebsite(String type){
        this.type = type;
    }
    @Override
    public void use() {
        System.out.println("网站类型：" + type);
    }
}

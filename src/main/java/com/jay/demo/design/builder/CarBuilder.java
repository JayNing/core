package com.jay.demo.design.builder;

/**
 * @Author JAY
 * @Date 2018/11/11 11:04
 * @Description 抽象汽车建造者类
 **/
public abstract class CarBuilder {

    public abstract void buildLunTai();
    public abstract void buildFaDongJi();
    public abstract void buildCheChuang();

    public abstract Car getCar();

}

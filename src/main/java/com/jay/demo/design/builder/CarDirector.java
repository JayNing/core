package com.jay.demo.design.builder;

/**
 * @Author JAY
 * @Date 2018/11/11 11:09
 * @Description 指挥者类, 用来指挥构建过程
 **/
public class CarDirector {

    public void Construct(CarBuilder carBuilder){
        carBuilder.buildLunTai();
        carBuilder.buildFaDongJi();
        carBuilder.buildCheChuang();
    }


}

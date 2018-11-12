package com.jay.demo.design.builder;

/**
 * @Author JAY
 * @Date 2018/11/11 11:06
 * @Description BMW汽车构造者
 **/
public class BMWCarBuilder extends CarBuilder{

    private Car car = new Car();

    @Override
    public void buildLunTai() {
        car.setLunTai("BMW的轮胎");
    }

    @Override
    public void buildFaDongJi() {
        car.setFaDongJi("BMW的发动机");
    }

    @Override
    public void buildCheChuang() {
        car.setCheChuang("BMW的车窗");
    }

    @Override
    public Car getCar() {
        return car;
    }
}

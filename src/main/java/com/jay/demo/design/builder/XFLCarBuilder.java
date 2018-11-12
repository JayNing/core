package com.jay.demo.design.builder;

/**
 * @Author JAY
 * @Date 2018/11/11 11:06
 * @Description XFL汽车构造者
 **/
public class XFLCarBuilder extends CarBuilder{

    private Car car = new Car();

    @Override
    public void buildLunTai() {
        car.setLunTai("XFL的轮胎");
    }

    @Override
    public void buildFaDongJi() {
        car.setFaDongJi("XFL的发动机");
    }

    @Override
    public void buildCheChuang() {
        car.setCheChuang("XFL的车窗");
    }

    @Override
    public Car getCar() {
        return car;
    }
}

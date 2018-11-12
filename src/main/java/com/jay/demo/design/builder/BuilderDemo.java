package com.jay.demo.design.builder;

/**
 * @Author JAY
 * @Date 2018/11/11 11:11
 * @Description 建造者模式demo
 **/
public class BuilderDemo {

    public static void main(String[] args) {
        //客户端代码，客户不需要知道具体的建造过程
        CarDirector carDirector = new CarDirector();
        //想建造一辆BMW的汽车
        BMWCarBuilder bmwCarBuilder = new BMWCarBuilder();
        carDirector.Construct(bmwCarBuilder);
        Car bmw = bmwCarBuilder.getCar();
        System.out.println(bmw);
        System.out.println("------------------------------------------");
        //想建造一辆XFL的汽车
        XFLCarBuilder xflCarBuilder = new XFLCarBuilder();
        carDirector.Construct(xflCarBuilder);
        Car xfl = xflCarBuilder.getCar();
        System.out.println(xfl);
    }

}

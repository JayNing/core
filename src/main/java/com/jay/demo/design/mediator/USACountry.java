package com.jay.demo.design.mediator;

/**
 * @Author JAY
 * @Date 2018/11/24 16:38
 * @Description 美国
 **/
public class USACountry extends Country{

    public USACountry(UnitedNationsMediator unitedNationsMediator) {
        super(unitedNationsMediator);
    }

    //声明
    public void declare(String msg){
        this.getUnitedNationsMediator().declare(msg,this);
    }

    //接收到其他国家发送的声明
    public void receive(String msg){
        System.out.println("美国接收到的消息：" + msg);
    }
}

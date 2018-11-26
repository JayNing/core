package com.jay.demo.design.mediator;

/**
 * @Author JAY
 * @Date 2018/11/24 16:38
 * @Description 中国
 **/
public class ChinaCountry extends Country{

    public ChinaCountry(UnitedNationsMediator unitedNationsMediator) {
        super(unitedNationsMediator);
    }

    //声明
    public void declare(String msg){
        this.getUnitedNationsMediator().declare(msg,this);
    }

    //接收到其他国家发送的声明
    public void receive(String msg){
        System.out.println("中国接收到的消息：" + msg);
    }
}

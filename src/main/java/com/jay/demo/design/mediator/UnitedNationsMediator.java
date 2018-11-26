package com.jay.demo.design.mediator;

/**
 * @Author JAY
 * @Date 2018/11/24 16:34
 * @Description 联合国机构抽象中介者类
 **/
public abstract class UnitedNationsMediator {

    //向国家发布声明
    public abstract void declare(String msg, Country country);

}

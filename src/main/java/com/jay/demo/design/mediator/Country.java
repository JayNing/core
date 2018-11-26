package com.jay.demo.design.mediator;

/**
 * @Author JAY
 * @Date 2018/11/24 16:36
 * @Description 国家抽象类
 **/
public abstract class Country {
    //引用中介者
    private UnitedNationsMediator unitedNationsMediator;

    public UnitedNationsMediator getUnitedNationsMediator() {
        return unitedNationsMediator;
    }

    public void setUnitedNationsMediator(UnitedNationsMediator unitedNationsMediator) {
        this.unitedNationsMediator = unitedNationsMediator;
    }

    public Country(UnitedNationsMediator unitedNationsMediator){
        this.unitedNationsMediator = unitedNationsMediator;
    }
}

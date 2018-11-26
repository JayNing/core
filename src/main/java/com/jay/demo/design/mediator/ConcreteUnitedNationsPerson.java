package com.jay.demo.design.mediator;

/**
 * @Author JAY
 * @Date 2018/11/24 16:42
 * @Description 联合国人权组织机构(具体中介者)
 *  具体中介者，要知道所有的交互对象
 **/
public class ConcreteUnitedNationsPerson extends UnitedNationsMediator{

    private USACountry usaCountry;
    private ChinaCountry chinaCountry;

    public USACountry getUsaCountry() {
        return usaCountry;
    }

    public void setUsaCountry(USACountry usaCountry) {
        this.usaCountry = usaCountry;
    }

    public ChinaCountry getChinaCountry() {
        return chinaCountry;
    }

    public void setChinaCountry(ChinaCountry chinaCountry) {
        this.chinaCountry = chinaCountry;
    }

    @Override
    public void declare(String msg, Country country) {
        if (country instanceof USACountry){
            chinaCountry.receive(msg);
        }else if (country instanceof ChinaCountry){
            usaCountry.receive(msg);
        }
    }
}

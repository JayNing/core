package com.jay.demo.design.mediator;

/**
 * @Author JAY
 * @Date 2018/11/24 16:41
 * @Description 中介者模式Demo
 **/
public class MediatorDemo {

    public static void main(String[] args) {

        ConcreteUnitedNationsPerson concreteMediator = new ConcreteUnitedNationsPerson();
        USACountry usaCountry = new USACountry(concreteMediator);
        ChinaCountry chinaCountry = new ChinaCountry(concreteMediator);
        concreteMediator.setChinaCountry(chinaCountry);
        concreteMediator.setUsaCountry(usaCountry);

        usaCountry.declare("中国实行计划生育，中国没有人权！");
        chinaCountry.declare("放你娘的XI屁，美国还歧视黑人");

    }


}

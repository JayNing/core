package com.jay.demo.design.vistor;

/**
 * @Author JAY
 * @Date 2018/11/25 16:32
 * @Description 状态行为抽象类
 **/
public abstract class Action {

    //男人的反应
    public abstract void getManConclusion(Man man);
    //女人的反应
    public abstract void getWomenConclusion(Wemon wemon);

}

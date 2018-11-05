package com.jay.demo.design.decorator;

/**
 * @Author JAY
 * @Date 2018/11/5 7:10
 * @Description 计算器对象类
 **/
public abstract class Calculator {

    public Calculator(){}

    private double a;
    private double b;

    public Calculator(double a, double b){
        this.a = a;
        this.b = b;
    }

    public abstract void getResult();
}

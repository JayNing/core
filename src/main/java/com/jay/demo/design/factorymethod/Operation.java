package com.jay.demo.design.factorymethod;

/**
 * @Author JAY
 * @Date 2018/11/6 21:25
 * @Description 运算抽象类
 **/
public abstract class Operation {

    private double numberA;

    private double numberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public abstract double getOperationResult();
}

package com.jay.demo.design.simplefactory;

/**
 * @Author JAY
 * @Date 2018/11/1 20:46
 * @Description 父级运算类
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

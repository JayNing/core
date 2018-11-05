package com.jay.demo.design.strategy;

/**
 * @Author JAY
 * @Date 2018/11/1 20:47
 * @Description 减法运算
 **/
public class OperationSub implements OperationInterface{
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA - numberB;
    }
}

package com.jay.demo.design.factorymethod;

/**
 * @Author JAY
 * @Date 2018/11/1 20:47
 * @Description 加法运算
 **/
public class OperationAdd extends Operation{
    @Override
    public double getOperationResult() {
        return this.getNumberA() + this.getNumberB();
    }
}

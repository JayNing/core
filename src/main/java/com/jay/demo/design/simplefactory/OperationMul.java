package com.jay.demo.design.simplefactory;

/**
 * @Author JAY
 * @Date 2018/11/1 20:47
 * @Description 乘法运算
 **/
public class OperationMul extends Operation{
    @Override
    public double getOperationResult() {
        return this.getNumberA() * this.getNumberB();
    }
}

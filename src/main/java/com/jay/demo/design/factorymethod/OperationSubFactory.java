package com.jay.demo.design.factorymethod;

/**
 * @Author JAY
 * @Date 2018/11/6 21:20
 * @Description 减运算工厂
 **/
public class OperationSubFactory implements OperationFactory{
    @Override
    public Operation createOperation() {
        return new OperationSub();
    }
}

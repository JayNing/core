package com.jay.demo.design.factorymethod;

/**
 * @Author JAY
 * @Date 2018/11/6 21:19
 * @Description 除运算工厂
 **/
public class OperationDivFactory implements OperationFactory {
    @Override
    public Operation createOperation() {
        return new OperationDiv();
    }
}

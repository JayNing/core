package com.jay.demo.design.decorator.calculator;

/**
 * @Author JAY
 * @Date 2018/11/1 20:47
 * @Description 乘法运算
 **/
public class OperationMul extends Operation{

    @Override
    public void getResult(){
        if (calculator != null){
            calculator.getResult();
        }
        System.out.println("额外添加执行乘操作");
    }
}

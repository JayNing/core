package com.jay.demo.design.decorator.calculator;

/**
 * @Author JAY
 * @Date 2018/11/5 7:10
 * @Description 功能类
 **/
public abstract class Operation extends Calculator{

    protected Calculator calculator;

    //添加功能
    public void decorator(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public void getResult(){
        if (calculator != null){
            calculator.getResult();
        }
    }

}

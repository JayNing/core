package com.jay.demo.design.decorator;

/**
 * @Author JAY
 * @Date 2018/11/5 7:10
 * @Description 计算器实例类
 **/
public class CalculatorCompotent extends Calculator{

    @Override
    public void getResult() {
        System.out.println("执行类实例原始的操作");
    }
}

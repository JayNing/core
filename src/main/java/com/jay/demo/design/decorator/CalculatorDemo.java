package com.jay.demo.design.decorator;

/**
 * @Author JAY
 * @Date 2018/11/1 20:45
 * @Description 计算器简单工厂demo
 **/
public class CalculatorDemo {

    public static void main(String[] args) {

        //想让这个计算器额外添加 加和减法
        CalculatorCompotent calculatorCompotent = new CalculatorCompotent();
        OperationAdd add = new OperationAdd();
        OperationSub sub = new OperationSub();
        add.decorator(calculatorCompotent);
        sub.decorator(add);
        sub.getResult();

        System.out.println("------------------------------------------------");

        //想让这个计算器额外添加有+,-,*,/操作
        CalculatorCompotent cc2 = new CalculatorCompotent();
        OperationAdd add1 = new OperationAdd();
        OperationSub sub1 = new OperationSub();
        OperationMul mul = new OperationMul();
        OperationDiv div = new OperationDiv();

        add1.decorator(cc2);
        sub1.decorator(add1);
        mul.decorator(sub1);
        div.decorator(mul);
        div.getResult();

    }

}

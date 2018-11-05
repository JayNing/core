package com.jay.demo.design.strategy;

import java.util.Scanner;

/**
 * @Author JAY
 * @Date 2018/11/1 20:45
 * @Description 计算器策略模式demo
 *
 *  策略模式与简单工厂结合的好处，可以让客户端只需要认识一个OperationContext类，不需要像简单工厂那样，需要认识OperationFactory
 *   和Operation两个类，降低耦合度
 **/
public class CalculatorDemo {

    public static void main(String[] args) {

        System.out.println("请选择运算符号：+，-，*，/");
        Scanner in = new Scanner(System.in);
        String nextLine = in.nextLine();
        System.out.println("您输入的是：" + nextLine);
        OperationContext operation = new OperationContext(nextLine);
        System.out.println("请输入numberA:");
        double nextDouble = in.nextDouble();
        double numberA = nextDouble;
        System.out.println("请输入numberB:");
        double nextDoubleB = in.nextDouble();
        double numberB = nextDoubleB;
        System.out.println("计算结果:" + operation.getResult(numberA,numberB));
    }

}

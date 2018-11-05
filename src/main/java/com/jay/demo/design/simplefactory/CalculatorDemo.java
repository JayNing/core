package com.jay.demo.design.simplefactory;

import java.util.Scanner;

/**
 * @Author JAY
 * @Date 2018/11/1 20:45
 * @Description 计算器简单工厂demo
 **/
public class CalculatorDemo {

    public static void main(String[] args) {

        System.out.println("请选择运算符号：+，-，*，/");
        Scanner in = new Scanner(System.in);
        String nextLine = in.nextLine();
        System.out.println("您输入的是：" + nextLine);
        Operation operation = OperationFactory.createOperation(nextLine);
        System.out.println("请输入numberA:");
        double nextDouble = in.nextDouble();
        double numberA = nextDouble;
        System.out.println("请输入numberB:");
        double nextDoubleB = in.nextDouble();
        double numberB = nextDoubleB;
        operation.setNumberA(numberA);
        operation.setNumberB(numberB);
        System.out.println("计算结果:" + operation.getOperationResult());
    }

}

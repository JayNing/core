package com.jay.demo.design.factorymethod;

import java.util.Scanner;

/**
 * @Author JAY
 * @Date 2018/11/1 20:45
 * @Description 计算器简单工厂demo
 **/
public class CalculatorDemo {

    public static void main(String[] args) {

        OperationFactory abstractFactory = new OperationMulFactory();
        Operation factoryOperation = abstractFactory.createOperation();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入numberA:");
        double nextDouble = in.nextDouble();
        double numberA = nextDouble;
        System.out.println("请输入numberB:");
        double nextDoubleB = in.nextDouble();
        double numberB = nextDoubleB;
        factoryOperation.setNumberA(numberA);
        factoryOperation.setNumberB(numberB);
        System.out.println("计算结果:" + factoryOperation.getOperationResult());
    }

}

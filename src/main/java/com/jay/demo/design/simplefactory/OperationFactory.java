package com.jay.demo.design.simplefactory;

/**
 * @Author JAY
 * @Date 2018/11/1 20:55
 * @Description 运算类型工厂
 **/
public class OperationFactory {

    public static Operation createOperation(String type){
        Operation operation = null;
        switch (type){
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                break;
        }
        return operation;
    }

}

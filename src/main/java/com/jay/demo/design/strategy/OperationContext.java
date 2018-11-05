package com.jay.demo.design.strategy;

/**
 * @Author JAY
 * @Date 2018/11/2 7:21
 * @Description OperationContext
 **/
public class OperationContext {

    private OperationInterface operationInterface;

    public OperationContext (String operationType){
        switch (operationType){
            case "+":
                operationInterface = new OperationAdd();
                break;
            case "-":
                operationInterface = new OperationSub();
                break;
            case "*":
                operationInterface = new OperationMul();
                break;
            case "/":
                operationInterface = new OperationDiv();
                break;
            default:
                break;
        }
    }

    public double getResult(double numberA, double numberB){
        return operationInterface.getResult(numberA,numberB);
    }

}

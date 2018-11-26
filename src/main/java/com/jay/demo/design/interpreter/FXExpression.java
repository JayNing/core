package com.jay.demo.design.interpreter;

/**
 * @Author JAY
 * @Date 2018/11/25 16:02
 * @Description 方向解释器
 **/
public class FXExpression extends Expression{

    @Override
    public void execute(String content) {
        System.out.println("方向：" + content);
    }
}

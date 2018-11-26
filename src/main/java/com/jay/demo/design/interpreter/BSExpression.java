package com.jay.demo.design.interpreter;

/**
 * @Author JAY
 * @Date 2018/11/25 16:02
 * @Description 步数解释器
 **/
public class BSExpression extends Expression{

    @Override
    public void execute(String content) {
        System.out.println("步数：" + content);
    }
}

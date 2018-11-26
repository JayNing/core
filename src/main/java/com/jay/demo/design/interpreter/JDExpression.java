package com.jay.demo.design.interpreter;

/**
 * @Author JAY
 * @Date 2018/11/25 16:02
 * @Description 角度解释器
 **/
public class JDExpression extends Expression{

    @Override
    public void execute(String content) {
        System.out.println("角度：" + content);
    }
}

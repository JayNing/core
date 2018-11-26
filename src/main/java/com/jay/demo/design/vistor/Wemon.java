package com.jay.demo.design.vistor;

/**
 * @Author JAY
 * @Date 2018/11/25 16:34
 * @Description 女人类
 **/
public class Wemon extends Person {
    @Override
    public void accept(Action action) {
        action.getWomenConclusion(this);
    }
}

package com.jay.demo.design.vistor;

/**
 * @Author JAY
 * @Date 2018/11/25 16:36
 * @Description 结婚状态类
 **/
public class Marriage extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println("当男人结婚时，有妻徒刑");
    }

    @Override
    public void getWomenConclusion(Wemon wemon) {
        System.out.println("当女人结婚时，婚姻保险");
    }
}

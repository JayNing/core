package com.jay.demo.design.vistor;

/**
 * @Author JAY
 * @Date 2018/11/25 16:36
 * @Description 当成功时
 **/
public class Success extends Action {
    @Override
    public void getManConclusion(Man man) {
        System.out.println("当男人成功时，背后多半有一个伟大的女人");
    }

    @Override
    public void getWomenConclusion(Wemon wemon) {
        System.out.println("当女人成功时，背后多半有一个不成功的男人");
    }
}

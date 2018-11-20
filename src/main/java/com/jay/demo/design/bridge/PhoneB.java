package com.jay.demo.design.bridge;

import java.util.List;

/**
 * @Author JAY
 * @Date 2018/11/20 21:40
 * @Description 手机品牌B
 **/
public class PhoneB extends AbstractPhone {

    @Override
    public void run() {
        System.out.println("手机品牌B运行。。。");
        List<AbstractSoft> softList = this.getSoftList();
        for (AbstractSoft abstractSoft : softList) {
            abstractSoft.run();
        }
    }
}

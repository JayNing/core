package com.jay.demo.spi.java.service.impl;

import com.jay.demo.spi.java.service.LoadBalance;

/**
 * desc:
 * createBy: Ningjianjian
 */
public class RandomLoadBalance implements LoadBalance {
    @Override
    public void invoke() {
        System.out.println("。。。。。。随机。。。。。。");
    }
}

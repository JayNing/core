package com.jay.demo.spi.java.service.impl;

import com.jay.demo.spi.java.service.LoadBalance;

/**
 * desc:
 * createBy: Ningjianjian
 */
public class LRULoadBalance implements LoadBalance {
    @Override
    public void invoke() {
        System.out.println("。。。。。。最近最少使用。。。。。。。");
    }
}

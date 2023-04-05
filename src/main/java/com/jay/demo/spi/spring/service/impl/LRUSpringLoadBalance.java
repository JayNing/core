package com.jay.demo.spi.spring.service.impl;

import com.jay.demo.spi.spring.service.SpringLoadBalance;

/**
 * desc:
 * createBy: Ningjianjian
 */
public class LRUSpringLoadBalance implements SpringLoadBalance {
    @Override
    public void invoke() {
        System.out.println("。。。LRU。。。");
    }
}

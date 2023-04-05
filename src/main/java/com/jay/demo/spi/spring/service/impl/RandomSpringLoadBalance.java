package com.jay.demo.spi.spring.service.impl;

import com.jay.demo.spi.spring.service.SpringLoadBalance;

/**
 * desc:
 * createBy: Ningjianjian
 */
public class RandomSpringLoadBalance implements SpringLoadBalance {
    @Override
    public void invoke() {
        System.out.println("。。。随机。。。");
    }
}

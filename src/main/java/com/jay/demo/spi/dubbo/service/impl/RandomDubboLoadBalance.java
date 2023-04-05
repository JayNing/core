package com.jay.demo.spi.dubbo.service.impl;

import com.jay.demo.spi.dubbo.service.DubboLoadBalance;

/**
 * desc:
 * createBy: Ningjianjian
 */
public class RandomDubboLoadBalance implements DubboLoadBalance {
    @Override
    public void invoke() {
        System.out.println("dubbo ... 随机 ...");
    }
}

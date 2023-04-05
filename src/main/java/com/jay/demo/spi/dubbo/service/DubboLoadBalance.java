package com.jay.demo.spi.dubbo.service;

import org.apache.dubbo.common.extension.SPI;

/**
 * desc:
 * createBy: Ningjianjian
 */
@SPI("lru")
public interface DubboLoadBalance {

    void invoke();
}

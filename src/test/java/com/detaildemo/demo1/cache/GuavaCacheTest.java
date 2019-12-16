package com.detaildemo.demo1.cache;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

public class GuavaCacheTest {

    public static void main(String[] args) throws Exception {
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(3,TimeUnit.SECONDS)
                .build();
        cache.put("key1","value1");
        int time = 1;
        while(true) {
            System.out.println("第" + time++ + "次取到key1的值为：" + cache.getIfPresent("key1"));
            Thread.sleep(1000);
        }
    }

}

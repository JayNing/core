package com.detaildemo.demo1.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class GuavaCacheTest {

    public static void main(String[] args) throws Exception {
        Cache<String,String> cache = CacheBuilder.newBuilder()
//                .maximumSize(2)
//                .expireAfterWrite(3,TimeUnit.SECONDS)
                .build();
        cache.put("key1","value1");
        cache.put("key2","value2");
        cache.put("key3","value3");
        int time = 1;
        while(time < 10) {
            System.out.println("第" + time + "次取到key" + (time % 4) + "的值为：" + cache.getIfPresent("key" + (time % 4)));
            time++;
            Thread.sleep(1000);
        }
        Cache<String,String> cache2 = CacheBuilder.newBuilder()
//                .maximumSize(2)
//                .expireAfterWrite(3,TimeUnit.SECONDS)
                .build();
        System.out.println("第" + time + "次取到key" + (time % 4) + "的值为：" + cache2.getIfPresent("key" + (time % 4)));

    }

}

package com.detaildemo.demo1;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * author JayNing
 * created by 2020/3/13 20:01
 **/
public class CaffeineCacheTest {
    public static void main(String[] args) {
        LoadingCache<String, String> build
                = CacheBuilder.newBuilder()
                .initialCapacity(1).maximumSize(100).expireAfterWrite(1, TimeUnit.MINUTES)
                .build(new CacheLoader<String, String>() {
                    //默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
                    @Override
                    public String load(String key)  {
                        return "";
                    }
                });
    }
}

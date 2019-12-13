package com.detaildemo.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadingCacheTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AtomicInteger value = new AtomicInteger();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        LoadingCache<String, String> cb = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .refreshAfterWrite(6, TimeUnit.SECONDS)
                .removalListener((RemovalListener<String, String>) notification -> {
                    System.out.println("remove key : " + notification.getKey() + ", value : " + notification.getValue() + ", cause  " + notification.getCause());
                })
                .build(new CacheLoader<String, String>() {
                    public String load(String key) { // no checked exception
                        String newValue = String.valueOf(value.getAndIncrement());
                        System.out.println("load ");
                        try {
                            TimeUnit.SECONDS.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("load end ");
                        return newValue;
                    }
                    //异步加载数据，这样数据过期后，还能查询到旧数据，同时异步在刷新新数据
                    @Override
                    public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                        // asynchronous!
                        System.out.println("refresh ");
                        ListenableFutureTask<String> task = ListenableFutureTask.create(() -> load(key));
                        executor.execute(task);
                        return task;
                    }
                });
        for (int i = 0; i < 20; i ++){
            System.out.println("value : " + cb.get("name"));
            TimeUnit.SECONDS.sleep(1);
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println("value : " + cb.get("name"));
    }

}

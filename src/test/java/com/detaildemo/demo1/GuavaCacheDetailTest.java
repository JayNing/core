package com.detaildemo.demo1;

import com.detaildemo.demo1.entity.DetailEntity;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.lang.instrument.Instrumentation;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class GuavaCacheDetailTest {

    private static volatile Instrumentation instru;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<DetailEntity> detailEntities = DetailTest.dataList(300000);
        Map<String, Map<String, Object>> stringMap1 = DetailTest.groupBy(detailEntities);

        Cache<String,Map<String, Map<String, Object>>> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
//                .expireAfterWrite(30, TimeUnit.SECONDS)
                .build();
        cache.put("modelCodeDataList",stringMap1);
        List<Long> timecost = new ArrayList<>();
        for (int i = 1 ; i <= 5 ; i++){
            System.out.println("第" + i + "次执行========================");
            System.out.println("开始时间：" + LocalTime.now());
            long begin = System.currentTimeMillis();

            long get1 = System.currentTimeMillis();
            Map<String, Map<String, Object>> stringMap = cache.get("modelCodeDataList", new Callable<Map<String, Map<String, Object>>>() {
                @Override
                public Map<String, Map<String, Object>> call() throws Exception {
                    System.out.println("需要外部加载数据。。。。");
                    List<DetailEntity> detailEntities = DetailTest.dataList(300000);
                    return DetailTest.groupBy(detailEntities);
                }
            });

            long get2 = System.currentTimeMillis();
            System.out.println("取数据耗时：" + (get2 - get1) + "ms");

            Map<String, Map<String, Object>> stringListMap = new HashMap<>();

            stringListMap = DetailTest.testSearch(stringListMap,stringMap);

            System.out.println("stringListMap.size() = " + stringListMap.size());

            long end = System.currentTimeMillis();
            System.out.println("结束时间：" + LocalTime.now());
            System.out.println("花费时间：" + (end - begin) + "ms");
            timecost.add((end - begin));
        }

        double average = timecost.stream().mapToInt(Long::intValue).average().getAsDouble();
        System.out.println("5次任务的平均耗时：" + average + "ms");
    }
}

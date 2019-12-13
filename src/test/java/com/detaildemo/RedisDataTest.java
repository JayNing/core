package com.detaildemo;

import com.detaildemo.cache.DataCache;
import com.detaildemo.entity.DetailEntity;
import com.detaildemo.util.GsonUtils;
import redis.clients.jedis.Jedis;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisDataTest {

    public static void main(String[] args) {
        List<DetailEntity> detailEntities = DetailTest.dataList(300000);
        Map<String, Map<String, Object>> dataMap = DetailTest.groupBy(detailEntities);
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        List<Long> timecost = new ArrayList<>();
        jedis.set("modelCodeDataList", GsonUtils.toJsonString(dataMap));
        for (int i = 1; i <= 5; i++){
            System.out.println("第" + i + "次执行====================================");
            System.out.println("开始时间：" + LocalTime.now());
            long begin = System.currentTimeMillis();

            long get1 = System.currentTimeMillis();
            Map<String, Map<String, Object>> stringMap = GsonUtils.toMap(jedis.get("modelCodeDataList"));
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

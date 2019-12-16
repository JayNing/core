package com.detaildemo.demo1;

import com.detaildemo.demo1.cache.DataCache;
import com.detaildemo.demo1.entity.DetailEntity;
import com.detaildemo.demo1.util.GsonUtils;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class JedisTest {
    public static void main(String[] args) {

        List<DetailEntity> detailEntities = DetailTest.dataList(300000);
        Map<String, Map<String, Object>> stringMap = DetailTest.groupBy(detailEntities);

        DataCache.set("modelCodeDataList", stringMap);

        //连接redis数据库
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("modelCodeDataList", GsonUtils.toJsonString(stringMap));


//        Map<String, Map<String, Object>> intoRedisMap = new HashMap<>();
//        //设置 key value
//        int i = 1;
//        for (Map.Entry<String, Map<String, Object>> entry : stringMap.entrySet()) {
//            intoRedisMap.put(entry.getKey(),entry.getValue());
//            if (intoRedisMap.size() % 50000 == 0){
//                jedis.set("modelCodeDataList" + i, GsonUtils.toJsonString(intoRedisMap));
//                i++;
//                intoRedisMap = new HashMap<>();
//            }
//        }

        //获取key对应的value
//        String StrVal = jedis.get("modelCodeDataList");
//        System.out.println(GsonUtils.toMap(StrVal));

    }
}

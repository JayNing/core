package com.detaildemo.demo1;


import com.detaildemo.demo1.cache.DataCache;
import com.detaildemo.demo1.entity.DetailEntity;
import com.detaildemo.demo1.entity.QueryEntity;
import com.detaildemo.demo1.util.GsonUtils;
import redis.clients.jedis.Jedis;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 模拟detail表在缓存中存储，进行条件查询操作
 */
public class DetailTest {

//    private static Executor executor = new ThreadPoolExecutor(4,4,10, TimeUnit.SECONDS,new BlockingArrayQueue<>());

    public static void main(String[] args) {

        List<DetailEntity> detailEntities = DetailTest.dataList(300000);
        Map<String, Map<String, Object>> stringMaps = DetailTest.groupBy(detailEntities);

        DataCache.set("modelCodeDataList", stringMaps);

        System.out.println("开始时间：" + LocalTime.now());
        long begin = System.currentTimeMillis();


        long get1 = System.currentTimeMillis();
        Map<String, Map<String, Object>> stringMap = DataCache.get("modelCodeDataList");
//        Map<String, Map<String, Object>> stringMap = new HashMap<>();
//        for (int i = 1; i <= 6; i++){
//            String json = jedis.get("modelCodeDataList" + i);
//            stringMap.putAll(GsonUtils.toMap(json));
//        }

//        Map<String, Map<String, Object>> stringMap = getDataFromRedis(jedis);
        long get2 = System.currentTimeMillis();
        System.out.println("取数据耗时：" + (get2 - get1) + "ms");

//        List<DetailEntity> detailEntities = DetailTest.dataList(300000);
//        Map<String, Map<String, Object>> stringMap = DetailTest.groupBy(detailEntities);

        Map<String, Map<String, Object>> stringListMap = new HashMap<>();

        stringListMap = testSearch(stringListMap,stringMap);
//        stringListMap = testSearchCondition(stringMap);

        System.out.println("stringListMap.size() = " + stringListMap.size());
//        System.out.println("stringListMap = " + JSONObject.toJSONString(stringListMap));
//        System.out.println("stringListMap = " + JSONObject.toJSONString(stringListMap));

//        List<Map<String, Object>> result2 = new ArrayList(stringListMap.values());
//        List<Map<String, Object>> pageList = result2.subList(10, 20);

        long end = System.currentTimeMillis();
        System.out.println("结束时间：" + LocalTime.now());
        System.out.println("花费时间：" + (end - begin) + "ms");

//        String s = JSONObject.toJSONString(pageList);
//        System.out.println(s);
    }

    private static Map<String, Map<String, Object>> getDataFromRedis(Jedis jediss) {
        Map<String, Map<String, Object>> stringMap = new HashMap<>();
        final CountDownLatch latch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++){
            int finalI = i;
            new Thread(() -> {
                Jedis jedis = new Jedis("127.0.0.1", 6379);
                String json = jedis.get("modelCodeDataList" + finalI);
                System.out.println(Thread.currentThread().getName() + ":" + json.length());
                stringMap.putAll(GsonUtils.toMap(json));
                System.out.println(latch.getCount());
                latch.countDown();
            },"Thread" + finalI).start();
        }
        try {
            latch.await();
            System.out.println("线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stringMap;
    }

    private static Map<String, Map<String, Object>> testSearchCondition(Map<String, Map<String, Object>> stringMap) {
        List<QueryEntity> queryConditions = new ArrayList<>();
        QueryEntity queryEntity1 = new QueryEntity("name","like","19");
        QueryEntity queryEntity2 = new QueryEntity("age",">","1000");
        QueryEntity queryEntity3 = new QueryEntity("addr","==","199000和2");
        queryConditions.add(queryEntity1);
        queryConditions.add(queryEntity2);
        queryConditions.add(queryEntity3);
        //取交集，and
        return searchByConditions(queryConditions, stringMap);
    }

    public static Map<String, Map<String, Object>> testSearch(Map<String, Map<String, Object>> stringListMap, Map<String, Map<String, Object>> stringMap) {

        final CountDownLatch latch = new CountDownLatch(4);
        AtomicReference<Map<String, Map<String, Object>>> ageListMap = new AtomicReference<>();
//        executor.execute(() -> {
//            long a = System.currentTimeMillis();
//            ageListMap.set(search("age", ">", "10",stringMap));
//            latch.countDown();
//            long b = System.currentTimeMillis();
//            System.out.println("Thread1 耗时:" + (b - a) + "ms");
//        });
        new Thread(() -> {
            long a = System.currentTimeMillis();
            ageListMap.set(search("age", ">", "10",stringMap));
            latch.countDown();
            long b = System.currentTimeMillis();
            System.out.println("Thread1 耗时:" + (b - a) + "ms");
        }).start();

        AtomicReference<Map<String, Map<String, Object>>> nameListMap = new AtomicReference<>();
//        executor.execute(() -> {
//            long a = System.currentTimeMillis();
//            nameListMap.set(search("name","like","19",stringMap));
//            latch.countDown();
//            long b = System.currentTimeMillis();
//            System.out.println("Thread2 耗时:" + (b - a) + "ms");
//        });
        new Thread(() -> {
            long a = System.currentTimeMillis();
            nameListMap.set(search("name","like","19",stringMap));
            latch.countDown();
            long b = System.currentTimeMillis();
            System.out.println("Thread2 耗时:" + (b - a) + "ms");
        }).start();

        AtomicReference<Map<String, Map<String, Object>>> addrListMap = new AtomicReference<>();
//        executor.execute(() -> {
//            long a = System.currentTimeMillis();
//            addrListMap.set(search("addr", "like", "2", stringMap));
//            latch.countDown();
//            long b = System.currentTimeMillis();
//            System.out.println("Thread3 耗时:" + (b - a) + "ms");
//        });
        new Thread(() -> {
            long a = System.currentTimeMillis();
            addrListMap.set(search("addr", "like", "2", stringMap));
            latch.countDown();
            long b = System.currentTimeMillis();
            System.out.println("Thread3 耗时:" + (b - a) + "ms");
        }).start();

        AtomicReference<Map<String, Map<String, Object>>> phoneListMap = new AtomicReference<>();
//        executor.execute(() -> {
//            long a = System.currentTimeMillis();
//            phoneListMap.set(search("phone", "==", "手机19", stringMap));
//            latch.countDown();
//            long b = System.currentTimeMillis();
//            System.out.println("Thread4 耗时:" + (b - a) + "ms");
//        });
        new Thread(() -> {
            long a = System.currentTimeMillis();
            phoneListMap.set(search("phone", "==", "手机19", stringMap));
            latch.countDown();
            long b = System.currentTimeMillis();
            System.out.println("Thread4 耗时:" + (b - a) + "ms");
        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ageListMap.size() = " + ageListMap.get().size());
        System.out.println("nameListMap.size() = " + nameListMap.get().size());
        System.out.println("addrListMap.size() = " + addrListMap.get().size());
        System.out.println("phoneListMap.size() = " + phoneListMap.get().size());
        //取并集,or
        stringListMap.putAll(ageListMap.get());
        stringListMap.putAll(nameListMap.get());
        stringListMap.putAll(addrListMap.get());
        stringListMap.putAll(phoneListMap.get());

        //取交集, and
//        Set<String> nameKeys = nameListMap.get().keySet();
//        Set<String> ageKeys = ageListMap.get().keySet();
//        Set<String> addKeys = addrListMap.get().keySet();
//        Set<String> phoneKeys = phoneListMap.get().keySet();
//        Sets.SetView<String> intersection = Sets.intersection(nameKeys, ageKeys);
//        Sets.SetView<String> intersection1 = Sets.intersection(addKeys, intersection);
//        Sets.SetView<String> intersection2 = Sets.intersection(intersection1, phoneKeys);
//
//        for (String key : intersection2) {
//            stringListMap.put(key, nameListMap.get().get(key));
//        }
        return stringListMap;
    }

    public static Map<String, Map<String, Object>> searchByConditions(List<QueryEntity> queryConditions,Map<String, Map<String, Object>> stringListMap){

        Map<String, Map<String, Object>> resultMap = new HashMap<>();
        for (Map.Entry<String, Map<String, Object>> entry: stringListMap.entrySet()){
            String dataId = entry.getKey();
            Map<String, Object> propDetail = entry.getValue();
            if (validDetail(queryConditions,propDetail)){
                resultMap.put(dataId,entry.getValue());
            }
        }
        return resultMap;
    }

    private static Boolean validDetail(List<QueryEntity> queryConditions, Map<String, Object> propDetail) {
        boolean flag = true;
        for (QueryEntity queryCondition : queryConditions) {
            //每个查询条件都满足，说明数据有用，可保留
            if (queryCondition.getQueryType().equalsIgnoreCase("like")){
                String propVal = (String) propDetail.get(queryCondition.getPropCode());
                if (!propVal.contains(queryCondition.getPropValue())){
                    flag = false;
                }
            }else if (queryCondition.getQueryType().equalsIgnoreCase("==")){
                String propVal = (String) propDetail.get(queryCondition.getPropCode());
                if (!propVal.equals(queryCondition.getPropValue())){
                    flag = false;
                }
            } else if (queryCondition.getQueryType().equalsIgnoreCase(">")){
                String propVal = (String) propDetail.get(queryCondition.getPropCode());
                if (Integer.valueOf(propVal) <= Integer.valueOf(queryCondition.getPropValue())){
                    flag = false;
                }
            }

        }
        return flag;
    }

    public static Map<String, Map<String, Object>> search(String propCode, String queryCondition, String propValue,Map<String, Map<String, Object>> stringListMap){

        Map<String, Map<String, Object>> resultMap = new HashMap<>();
        if (queryCondition.equalsIgnoreCase("like")){
            for (Map.Entry<String, Map<String, Object>> entry: stringListMap.entrySet()){
                String propVal = (String) entry.getValue().get(propCode);
                if (propVal.contains(propValue)){
                    resultMap.put(entry.getKey(),entry.getValue());
                }
            }
        }else if (queryCondition.equalsIgnoreCase("==")){
            for (Map.Entry<String, Map<String, Object>> entry: stringListMap.entrySet()){
                String propVal = (String) entry.getValue().get(propCode);
                if (propVal.equals(propValue)){
                    resultMap.put(entry.getKey(),entry.getValue());
                }
            }
        } else if (queryCondition.equalsIgnoreCase(">")){
            for (Map.Entry<String, Map<String, Object>> entry: stringListMap.entrySet()){
                int propVal = Integer.valueOf((String) entry.getValue().get(propCode));
                if (propVal > Integer.valueOf(propValue)){
                    resultMap.put(entry.getKey(),entry.getValue());
                }
            }
        }

        return resultMap;
    }

    public static  Map<String, Map<String, Object>> groupBy(List<DetailEntity> detailEntities){
        Map<String, List<DetailEntity>> collect = detailEntities.stream().collect(Collectors.groupingBy(DetailEntity::getDataId));
        Map<String, Map<String, Object>> result = new HashMap<>();
        for (Map.Entry<String, List<DetailEntity>> entry : collect.entrySet()){
            List<DetailEntity> value = entry.getValue();
            Map<String,Object> propMap = new HashMap<>();
            for (DetailEntity entity : value) {
                propMap.put(entity.getPropCode(),entity.getPropValue());
            }
            //额外加上dataId属性
            propMap.put("dataId",entry.getKey());
            result.put(entry.getKey(),propMap);
        }
        return result;
    }

    public static List<DetailEntity> dataList(int sum){
        List<DetailEntity> list = new ArrayList<>();
        for (int i = 0; i < sum; i++){
            for (int j = 0; j < 4; j++){
                DetailEntity entity = null;
                if (j == 0){
                    //添加姓名
                    entity = new DetailEntity(i+"", "name",i +"和" + j,"姓名");
                }else if (j == 1){
                    //添加年龄
                    entity = new DetailEntity(i+"", "age", String.valueOf(i + j),"年龄");
                }else if (j == 2){
                    //添加地址
                    entity = new DetailEntity(i+"", "addr", i +"和" + j,"地址");
                }else if (j == 3){
                    //添加手机
                    entity = new DetailEntity(i+"", "phone", "手机" + i,"手机");
                }
                list.add(entity);
            }
        }
        return list;
    }


}

package com.detaildemo;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import org.eclipse.jetty.util.BlockingArrayQueue;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * 模拟detail表在缓存中存储，进行条件查询操作
 */
public class DetailTest {

//    private static Executor executor = new ThreadPoolExecutor(5,5,300, TimeUnit.SECONDS,new BlockingArrayQueue<>());

    public static void main(String[] args) {
        List<DetailEntity> detailEntities = dataList(300000);
        Map<String, Map<String, Object>> stringMap = groupBy(detailEntities);

//        String s = JSONObject.toJSONString(stringMap);
//        System.out.println(s);

        long begin = System.currentTimeMillis();
        System.out.println("开始时间：" + LocalTime.now());
        Map<String, Map<String, Object>> stringListMap = new HashMap<>();



        stringListMap = testSearch(stringListMap,stringMap);
//        stringListMap = testSearchCondition(stringMap);

        System.out.println("stringListMap.size() = " + stringListMap.size());
//        System.out.println("stringListMap = " + JSONObject.toJSONString(stringListMap));

//        List<Map<String, Object>> result2 = new ArrayList(stringListMap.values());
//        List<Map<String, Object>> pageList = result2.subList(10, 20);

        long end = System.currentTimeMillis();
        System.out.println("结束时间：" + LocalTime.now());
        System.out.println("花费时间：" + (end - begin) + "ms");

//        String s = JSONObject.toJSONString(pageList);
//        System.out.println(s);
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

    private static Map<String, Map<String, Object>> testSearch(Map<String, Map<String, Object>> stringListMap, Map<String, Map<String, Object>> stringMap) {

        final CountDownLatch latch = new CountDownLatch(3);
        AtomicReference<Map<String, Map<String, Object>>> ageListMap = new AtomicReference<>();
        new Thread(() -> {
            long a = System.currentTimeMillis();
            ageListMap.set(search("age", ">", "10",stringMap));
            latch.countDown();
            long b = System.currentTimeMillis();
            System.out.println("Thread1 耗时:" + (b - a) + "ms");
        }).start();

        AtomicReference<Map<String, Map<String, Object>>> nameListMap = new AtomicReference<>();
        new Thread(() -> {
            long a = System.currentTimeMillis();
            nameListMap.set(search("name","like","19",stringMap));
            latch.countDown();
            long b = System.currentTimeMillis();
            System.out.println("Thread2 耗时:" + (b - a) + "ms");
        }).start();

        AtomicReference<Map<String, Map<String, Object>>> addrListMap = new AtomicReference<>();
        new Thread(() -> {
            long a = System.currentTimeMillis();
            addrListMap.set(search("addr", "==", "19和2", stringMap));
            latch.countDown();
            long b = System.currentTimeMillis();
            System.out.println("Thread3 耗时:" + (b - a) + "ms");
        }).start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ageListMap.size() = " + ageListMap.get().size());
        System.out.println("nameListMap.size() = " + nameListMap.get().size());
        System.out.println("addrListMap.size() = " + addrListMap.get().size());
        //取并集,or
//        stringListMap.putAll(ageListMap.get());
//        stringListMap.putAll(nameListMap.get());
//        stringListMap.putAll(addrListMap.get());

        //取交集, and
        Set<String> nameKeys = nameListMap.get().keySet();
        Set<String> ageKeys = ageListMap.get().keySet();
        Set<String> addKeys = addrListMap.get().keySet();
        Sets.SetView<String> intersection = Sets.intersection(nameKeys, ageKeys);
        Sets.SetView<String> intersection1 = Sets.intersection(addKeys, intersection);
        for (String key : intersection1) {
            stringListMap.put(key, nameListMap.get().get(key));
        }
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
            for (int j = 0; j < 3; j++){
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
                }
                list.add(entity);
            }
        }
        return list;
    }


}

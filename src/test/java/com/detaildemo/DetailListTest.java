package com.detaildemo;


import com.alibaba.fastjson.JSONObject;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * 模拟detail表在缓存中存储，进行条件查询操作
 */
public class DetailListTest {

    public static void main(String[] args) {
        List<DetailEntity> detailEntities = dataList(300000);
        List<Map<String, Object>> stringList = groupBy(detailEntities);
        System.out.println("stringList.size() = " + stringList.size());
//        String s = JSONObject.toJSONString(stringList);
//        System.out.println(s);

        long begin = System.currentTimeMillis();
        System.out.println("开始时间：" + LocalTime.now());
        //不使用多线程方案
//        Map<String, Map<String, Object>> rs = testSearchCondition(stringList);

        //使用多线程方案
        final CountDownLatch latch = new CountDownLatch(4);


        List<Map<String, Object>> subList1 = stringList.subList(0, stringList.size() / 4);
        System.out.println("subList1.size() = " + subList1.size());
        List<Map<String, Object>> subList2 = stringList.subList(stringList.size() / 4, stringList.size() / 4 * 2);
        System.out.println("subList2.size() = " + subList2.size());
        List<Map<String, Object>> subList3 = stringList.subList(stringList.size() / 4 * 2, stringList.size() / 4 * 3);
        System.out.println("subList3.size() = " + subList3.size());
        List<Map<String, Object>> subList4 = stringList.subList(stringList.size() / 4 * 3, stringList.size());
        System.out.println("subList4.size() = " + subList4.size());

        Map<String, Map<String, Object>> rs = new HashMap<>();
        new Thread(() -> {
            Map<String, Map<String, Object>> stringMapMap = testSearchCondition(subList1);
            System.out.println("sub1.size() = " + stringMapMap.size());
            rs.putAll(stringMapMap);
            latch.countDown();
        },"Thread1").start();

        new Thread(() -> {
            Map<String, Map<String, Object>> stringMapMap = testSearchCondition(subList2);
            System.out.println("sub2.size() = " + stringMapMap.size());
            rs.putAll(stringMapMap);
            latch.countDown();
        },"Thread2").start();

        new Thread(() -> {
            Map<String, Map<String, Object>> stringMapMap = testSearchCondition(subList3);
            System.out.println("sub3.size() = " + stringMapMap.size());
            rs.putAll(stringMapMap);
            latch.countDown();
        },"Thread3").start();

        new Thread(() -> {
            Map<String, Map<String, Object>> stringMapMap = testSearchCondition(subList4);
            System.out.println("sub4.size() = " + stringMapMap.size());
            rs.putAll(stringMapMap);
            latch.countDown();
        },"Thread4").start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("stringMapMap.size() = " + rs.size());

        long end = System.currentTimeMillis();
        System.out.println("结束时间：" + LocalTime.now());
        System.out.println("花费时间：" + (end - begin) + "ms");

       List<Map<String, Object>> result2 = new ArrayList(rs.values());
//        List<Map<String, Object>> pageList = result2.subList(10, 20);


//        String s = JSONObject.toJSONString(result2);
//        System.out.println(s);
    }

    private static Map<String, Map<String, Object>> testSearchCondition(List<Map<String, Object>> stringList) {
        List<QueryEntity> queryConditions = new ArrayList<>();
        QueryEntity queryEntity1 = new QueryEntity("name","like","9");
        QueryEntity queryEntity2 = new QueryEntity("age",">","10");
        QueryEntity queryEntity3 = new QueryEntity("addr","==","19和2");
        queryConditions.add(queryEntity1);
        queryConditions.add(queryEntity2);
        queryConditions.add(queryEntity3);
        //取交集，and
        return searchByConditions(queryConditions, stringList);
    }

    private static Map<String, Map<String, Object>> testSearch(Map<String, Map<String, Object>> stringListMap, Map<String, Map<String, Object>> stringMap) {

        Map<String, Map<String, Object>> ageListMap = search("age", ">", "100000",stringMap);
        Map<String, Map<String, Object>> nameListMap = search("name","like","19000",stringMap);
        Map<String, Map<String, Object>> addrListMap = search("addr","==","19990和2",stringMap);
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ageListMap.size() = " + ageListMap.size());
        System.out.println("nameListMap.size() = " + nameListMap.size());
        System.out.println("addrListMap.size() = " + addrListMap.size());
        //取并集,or
        stringListMap.putAll(ageListMap);
        stringListMap.putAll(nameListMap);
        stringListMap.putAll(addrListMap);

        //取交集, and
//        Set<String> nameKeys = nameListMap.keySet();
//        Set<String> ageKeys = ageListMap.keySet();
//        Set<String> addKeys = addrListMap.keySet();
//        Sets.SetView<String> intersection = Sets.intersection(nameKeys, ageKeys);
//        Sets.SetView<String> intersection1 = Sets.intersection(addKeys, intersection);
//        for (String key : intersection1) {
//            stringListMap.put(key, nameListMap.get(key));
//        }
        return stringListMap;
    }

    public static Map<String, Map<String, Object>> searchByConditions(List<QueryEntity> queryConditions,List<Map<String, Object>> stringList){
        Map<String, Map<String, Object>> resultMap = new HashMap<>();
        for (Map<String, Object> objectMap : stringList) {
            String dataId = (String) objectMap.get("dataId");
            if (validDetail(queryConditions,objectMap)){
                resultMap.put(dataId,objectMap);
            }
        }

        return resultMap;
    }

    private static Boolean validDetail(List<QueryEntity> queryConditions, Map<String, Object> propDetail) {
        boolean flag = true;
        for (QueryEntity queryCondition : queryConditions) {
            if (queryConditions.size() == 1){
                //单条件查询
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
            } else {
                //多条件查询
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

    public static  List<Map<String, Object>> groupBy(List<DetailEntity> detailEntities){
        Map<String, List<DetailEntity>> collect = detailEntities.stream().collect(Collectors.groupingBy(DetailEntity::getDataId));
        List<Map<String, Object>> result = new ArrayList<>();
        for (Map.Entry<String, List<DetailEntity>> entry : collect.entrySet()){
            List<DetailEntity> value = entry.getValue();
            Map<String,Object> propMap = new HashMap<>();
            for (DetailEntity entity : value) {
                propMap.put(entity.getPropCode(),entity.getPropValue());
            }
            //额外加上dataId属性
            propMap.put("dataId",entry.getKey());
            result.add(propMap);
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

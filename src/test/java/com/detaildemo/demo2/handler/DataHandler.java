package com.detaildemo.demo2.handler;

import com.detaildemo.demo1.entity.DetailEntity;
import com.detaildemo.demo1.util.GsonUtils;
import com.detaildemo.demo2.entity.DataDetailEntity;
import com.zx.util.CollectionUtils;
import com.zx.util.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

public class DataHandler {

    public static void main(String[] args) {
        List<DataDetailEntity> dataDetailEntities = generateDataList(300000);
        System.out.println("dataDetailEntities.size() : " + dataDetailEntities.size());

//        System.out.println(GsonUtils.toJsonString(dataDetailEntities));
        List<Long> sum = new ArrayList<>();
        for (int i = 1; i <= 20; i++){
            long begin = System.currentTimeMillis();
            Map<String, Map<String, Object>> stringMapMap = groupBy(dataDetailEntities,"JP");
            long end = System.currentTimeMillis();
            sum.add((end - begin));
            System.out.println("解析30W数据耗时：" + (end - begin) + "ms");
//            System.out.println(GsonUtils.toJsonString(stringMapMap));
        }
        sum.sort(Comparator.comparing(Long::intValue));
        System.out.println(GsonUtils.toJsonString(sum));
        List<Long> longs = sum.subList(1, sum.size() - 1);
        System.out.println(GsonUtils.toJsonString(longs));
        double avg = longs.stream().mapToInt(Long::intValue).average().getAsDouble();
        System.out.println("执行20次解析任务，平均耗时:" + avg + "ms");

    }

    public static  Map<String, Map<String, Object>> groupBy(List<DataDetailEntity> dataDetailEntities,String language){
        Map<String, Map<String, Object>> result = new HashMap<>();

        for (DataDetailEntity dataDetailEntity : dataDetailEntities) {
            String dataId = dataDetailEntity.getDataId();
            Map<String, Object> objectMap = result.get(dataId);
            if (objectMap == null || objectMap.size() == 0){
                objectMap = new HashMap<>();
            }
            String propCode = dataDetailEntity.getPropCode();
            if (StringUtil.isEmpty(dataDetailEntity.getLanguage()) || language.equals(dataDetailEntity.getLanguage())){
                objectMap.put(propCode, dataDetailEntity.getPropValue());
            } else {
                Object o = objectMap.get(propCode);
                if (o == null){
                    objectMap.put(propCode,"");
                }
            }
            objectMap.put("dataId",dataId);
            result.put(dataId,objectMap);
        }


//        for (Map.Entry<String, List<DataDetailEntity>> entry : collect.entrySet()){
//            Map<String,Object> propMap = new HashMap<>();
//            List<DataDetailEntity> value = entry.getValue();
//            for (DataDetailEntity detailEntity : value) {
//                if (StringUtil.isEmpty(detailEntity.getLanguage()) || language.equals(detailEntity.getLanguage())){
//                    propMap.put(detailEntity.getPropCode(),detailEntity.getPropValue());
//                } else {
//                    Object o = propMap.get(detailEntity.getPropCode());
//                    if (o == null){
//                        propMap.put(detailEntity.getPropCode(),"");
//                    }
//                }
//            }
//            //额外加上dataId属性
//            propMap.put("dataId",entry.getKey());
//            result.put(entry.getKey(),propMap);
//        }
        return result;
    }

    public static List<DataDetailEntity> generateDataList(int sum){
        List<DataDetailEntity> list = new ArrayList<>();
        for (int i = 0; i < sum; i++){
            for (int j = 0; j < 4; j++){
                DataDetailEntity entity = null;
                if (j == 0){
                    //添加姓名
                    entity = new DataDetailEntity(i+"", "name",i +"和" + j,"姓名","CN");
                    DataDetailEntity entityJp = new DataDetailEntity(i+"", "name","JP_" + i +"和" + j,
                            "姓名","JP");
                    list.add(entityJp);
                }else if (j == 1){
                    //添加年龄
                    entity = new DataDetailEntity(i+"", "age", String.valueOf(i + j),"年龄");
                }else if (j == 2){
                    //添加地址
                    entity = new DataDetailEntity(i+"", "addr", i +"和" + j,"地址","CN");
                    DataDetailEntity entityEn = new DataDetailEntity(i+"", "addr","EN_" + i +"和" + j,
                            "地址","EN");
                    list.add(entityEn);
                }else if (j == 3){
                    //添加手机
                    entity = new DataDetailEntity(i+"", "phone", "CN_手机_" + i,"手机","CN");
                    DataDetailEntity entityEn = new DataDetailEntity(i+"", "phone","EN_手机_" + i,
                            "手机","EN");
                    list.add(entityEn);
                    DataDetailEntity entityJp = new DataDetailEntity(i+"", "phone","JP_手机_" + i,
                            "手机","JP");
                    list.add(entityJp);
                }
                list.add(entity);
            }
        }
        return list;
    }

}

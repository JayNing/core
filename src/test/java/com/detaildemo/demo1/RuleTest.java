package com.detaildemo.demo1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.detaildemo.demo1.entity.DetailEntity;
import com.detaildemo.demo1.drools.DroolsExecutor;
import com.detaildemo.demo1.drools.RuleType;
import com.detaildemo.demo1.drools.fact.FactData;
import com.detaildemo.demo1.drools.fact.FactModel;
import com.detaildemo.demo1.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RuleTest {
    private static final String VALUE = "value";
    private static final String[] INTERNAL_PROPERTY = {"sn", "dataStatus", "parentSn", "categorySn", "ownerUser", "ownerOrg", "createdBy", "createdDate", "updatedBy", "updatedDate", "modelVersion", "dataVersion", "parentLabel", "categoryLabel"};
    private static final String PROPERTY_CODE = "propertyCode";

    public static void main(String[] args) {
        int sum = 300000;
        List<DetailEntity> detailEntities = DetailListTest.dataList(sum);
        List<Map<String, Object>> dataEntities = DetailListTest.groupBy(detailEntities);
        System.out.println("dataEntities.size => " + dataEntities.size());
        System.out.println("==========================");
        String conditionConfig = "[{\"propertyCode\":\"\",\"name\":\"(\",\"value\":\"(\"},{\"propertyCode\":\"name\",\"parentCode\":\"\",\"name\":\"姓名\",\"value\":\"$(\\\"name\\\")\",\"modelCode\":\"p0012\"},{\"propertyCode\":\"\",\"name\":\"like\",\"value\":\"like\"},{\"propertyCode\":\"\",\"name\":\"2\",\"value\":\"\\\"2\\\"\"},{\"propertyCode\":\"\",\"name\":\")\",\"value\":\")\"},{\"propertyCode\":\"\",\"name\":\"&&\",\"value\":\"&&\"},{\"propertyCode\":\"\",\"name\":\"(\",\"value\":\"(\"},{\"propertyCode\":\"age\",\"parentCode\":\"\",\"name\":\"年龄\",\"value\":\"$(\\\"age\\\")\",\"modelCode\":\"p0012\"},{\"propertyCode\":\"\",\"name\":\"==\",\"value\":\"==\"},{\"propertyCode\":\"\",\"name\":\"27\",\"value\":\"\\\"27\\\"\"},{\"propertyCode\":\"\",\"name\":\")\",\"value\":\")\"}]\n";
        long begin = System.currentTimeMillis();
        List<Map<String, Object>> dataList = filterData(conditionConfig, dataEntities);
        long end = System.currentTimeMillis();
        System.out.println("dataList.size => " + dataList.size());
        System.out.println(sum + "数据量，筛选耗时 : " + (end - begin) + "ms");
//        System.out.println("dataList => ");
//        System.out.println(JSONObject.toJSONString(dataList));


        //验证表达式规则
//        String json = "[{\"propertyCode\":\"\",\"name\":\"(\",\"value\":\"(\"},{\"propertyCode\":\"phase\",\"parentCode\":\"\",\"name\":\"阶段\",\"value\":\"$(\\\"phase\\\")\",\"modelCode\":\"p0012\"},{\"propertyCode\":\"\",\"name\":\"==\",\"value\":\"==\"},{\"propertyCode\":\"\",\"name\":\"001\",\"value\":\"\\\"001\\\"\"},{\"propertyCode\":\"\",\"name\":\")\",\"value\":\")\"},{\"propertyCode\":\"\",\"name\":\"&&\",\"value\":\"&&\"},{\"propertyCode\":\"\",\"name\":\"(\",\"value\":\"(\"},{\"propertyCode\":\"buildterraarea1\",\"parentCode\":\"\",\"name\":\"建设用地面积_分期\",\"value\":\"$(\\\"buildterraarea1\\\")\",\"modelCode\":\"p0012\"},{\"propertyCode\":\"\",\"name\":\"==\",\"value\":\"==\"},{\"propertyCode\":\"\",\"name\":\"001\",\"value\":\"\\\"001\\\"\"},{\"propertyCode\":\"\",\"name\":\")\",\"value\":\")\"}]\n";
//        String json = "[{\"propertyCode\":\"phase\",\"parentCode\":\"\",\"name\":\"姓名\",\"value\":\"$(\\\"name\\\")\",\"modelCode\":\"p0012\"},{\"propertyCode\":\"\",\"name\":\"==\",\"value\":\"==\"},{\"propertyCode\":\"\",\"name\":\"24和0\",\"value\":\"\\\"24和0\\\"\"}]\n";
//        validExpression(json);

//        String conditionConfig = "[{\"propertyCode\":\"\",\"name\":\"(\",\"value\":\"(\"},{\"propertyCode\":\"name\",\"parentCode\":\"\",\"name\":\"姓名\",\"value\":\"$(\\\"name\\\")\",\"modelCode\":\"p0012\"},{\"propertyCode\":\"\",\"name\":\"like\",\"value\":\"like\"},{\"propertyCode\":\"\",\"name\":\"2\",\"value\":\"\\\"2\\\"\"},{\"propertyCode\":\"\",\"name\":\")\",\"value\":\")\"},{\"propertyCode\":\"\",\"name\":\"||\",\"value\":\"||\"},{\"propertyCode\":\"\",\"name\":\"(\",\"value\":\"(\"},{\"propertyCode\":\"age\",\"parentCode\":\"\",\"name\":\"年龄\",\"value\":\"$(\\\"age\\\")\",\"modelCode\":\"p0012\"},{\"propertyCode\":\"\",\"name\":\">\",\"value\":\">\"},{\"propertyCode\":\"\",\"name\":\"5\",\"value\":\"\\\"5\\\"\"},{\"propertyCode\":\"\",\"name\":\")\",\"value\":\")\"}]\n";
//        validExpression(conditionConfig);


        //筛选过滤数据
//        String conditionConfig = "[{\"propertyCode\":\"age\",\"parentCode\":\"\",\"name\":\"年龄\",\"value\":\"$(\\\"age\\\")\",\"modelCode\":\"p0012\"},{\"propertyCode\":\"\",\"name\":\">\",\"value\":\">\"},{\"propertyCode\":\"\",\"name\":\"25\",\"value\":\"\\\"25\\\"\"}]\n";
//        String conditionConfig = "[{\"propertyCode\":\"name\",\"parentCode\":\"\",\"name\":\"姓名\",\"value\":\"$(\\\"name\\\")\",\"modelCode\":\"p0012\"},{\"propertyCode\":\"\",\"name\":\"like\",\"value\":\"like\"},{\"propertyCode\":\"\",\"name\":\"2\",\"value\":\"\\\"2\\\"\"}]\n";

    }

    private static List<Map<String, Object>> filterData(String conditionConfig, List<Map<String, Object>> dataEntities) {

        List<Map<String, Object>> resultList = new ArrayList<>();

        JSONArray array = JSON.parseArray(conditionConfig);
        // 规则集合
        List<String> rules = array.stream()
                .map(param -> ((JSONObject) param).getString(VALUE).trim())
                .collect(Collectors.toList());
        // 规则执行器
        DroolsExecutor executor = DroolsExecutor.build(RuleType.VALIDATION, rules);
        // 属性编码集合
        List<String> propertyCodes = array.stream()
                .map(param -> ((JSONObject) param).getString(PROPERTY_CODE).trim())
                .filter(code -> org.apache.commons.lang3.StringUtils.isNotBlank(code))
                .collect(Collectors.toList());
        dataEntities.forEach(data -> {
            FactData factData = new FactData();
            propertyCodes.stream().forEach(code -> {
                if (!Arrays.asList(INTERNAL_PROPERTY).contains(code)) {
                    // 内置属性
                    factData.set(code, (String) data.get(code));
                } else {
                    factData.set(code, data.get(code).toString());
                }
            });
            if (FactModel.MATCHED.equals(executor.execute(factData))) {
                // 规则执行结果为真
                resultList.add(data);
            }
        });
        return resultList;
    }

    public static boolean validExpression(String json){
        boolean result = false;
        List<Map<String, String>> conditionConfig = StringUtils.convertToList(json);
        System.out.println(JSONObject.toJSONString(conditionConfig));

        List<String> rules = conditionConfig.stream().map(param -> param.get(VALUE).toString().trim()).collect(Collectors.toList());
        System.out.println("rules: ");
        System.out.println(rules);
        //测试校验表达式
        if (!DroolsExecutor.verify(RuleType.VALIDATION, rules)) {
            System.out.println("表达式格式不正确");
        } else {
            System.out.println("表达式格式正确了。。。。。");
            result = true;
        }
        return result;
    }
}

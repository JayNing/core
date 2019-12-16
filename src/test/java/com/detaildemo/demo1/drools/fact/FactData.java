package com.detaildemo.demo1.drools.fact;

import java.util.HashMap;
import java.util.Map;

/**
 * 待校验数据
 *
 * @author hawods
 * @version 2018-08-30
 */
public class FactData {
    private Map<String, FactValue> dataMap = new HashMap<>();

    /**
     * 根据属性编码获取数据详情
     *
     * @param key
     * @return
     */
    public FactValue get(String key) {
        FactValue detail = dataMap.get(key);
        if (detail == null) {
            detail = new FactValue(null);
        }

        return detail;
    }

    /**
     * 设置属性数据详情
     *
     * @param key
     * @return
     */
    public void set(String key, String value) {
        dataMap.put(key, new FactValue(value));
    }

    /**
     * 将字符串转换成FactValue，在DRL脚本中使用
     *
     * @param value
     * @return
     */
    public FactValue toValue(String value) {
        return new FactValue(value);
    }
}

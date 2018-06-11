package com.zx.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author ning
 * //TODO json工具类----springboot版本使用
 */
public class JsonBootUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonBootUtil.class);

    private JsonBootUtil() {
    }

    public static void main(String[] args) {


    }

    //将json转成对象
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return JSON.parseObject(json,clazz);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("JsonUtil fromJson Type:" + clazz.getName() + ", Json:" + json, e);
            return null;
        }
    }

    //将json转成对象集合
    public static <T> List<T> fromListJson(String json, Class<T> clazz) {
        try {
            return JSON.parseArray(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("JsonUtil fromJson Type:List<" + clazz.getName() + ">, Json:" + json, e);
            return null;
        }
    }

    //将对象转成json
    public static String toJsonFromObj(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    //将对象集合转成json
    public static <T> String toJsonFromArry(List<T> list) {
        String pojoJson = JSONArray.toJSONString(list);
        return pojoJson;
    }
}

package com.detaildemo.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Gson工具类
 *
 * @author Tino
 */
public class GsonUtils {

    /**
     * 将object对象转成json字符串
     *
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(object);
        return jsonString;
    }
    /**
     * json字符串转成泛型bean并指定时间格式转换
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> T toBeanConvertDate(String jsonString, Class<T> cls, String pattern) {
        Gson gson = new Gson();
        if (StringUtils.isNotEmpty(pattern)){
            gson = new GsonBuilder()
                    .setDateFormat(pattern)
                    .create();
        }
        T t = gson.fromJson(jsonString, cls);
        return t;
    }

    /**
     * json字符串转成泛型bean
     *
     * @param jsonString
     * @param cls
     * @return
     */
    public static <T> T toBean(String jsonString, Class<T> cls) {
        Gson gson = new Gson();
        T t = gson.fromJson(jsonString, cls);
        return t;
    }

    /**
     * json字符串转成list
     * 解决泛型问题
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> List<T> toList(String json, Class<T> cls) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, cls));
        }
        return list;
    }


    /**
     * json字符串转成list中有map的
     *
     * @param jsonString
     * @return
     */
    public static <T> List<Map<String, T>> toListMaps(String jsonString) {
        Gson gson = new Gson();
        List<Map<String, T>> list = gson.fromJson(jsonString,
                new TypeToken<List<Map<String, T>>>() {
                }.getType());

        return list;
    }


    /**
     * json字符串转成map的
     *
     * @param jsonString
     * @return
     */
    public static <T> Map<String, T> toMap(String jsonString) {
        Gson gson = new Gson();
        Map<String, T> map = gson.fromJson(jsonString, new TypeToken<Map<String, T>>() {
        }.getType());
        return map;
    }

}

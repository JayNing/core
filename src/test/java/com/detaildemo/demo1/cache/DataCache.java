package com.detaildemo.demo1.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataCache {
    private static Map<String, Map<String, Map<String, Object>>> localCacheStore = new ConcurrentHashMap<>();

    public static void set(String key, Map<String, Map<String, Object>> data){
        localCacheStore.put(key,data);
    }

    public static Map<String, Map<String, Object>> get(String key){
        return localCacheStore.get(key);
    }

}

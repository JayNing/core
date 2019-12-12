package com.detaildemo.cache;

import java.util.HashMap;
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

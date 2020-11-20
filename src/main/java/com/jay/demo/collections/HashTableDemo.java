package com.jay.demo.collections;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * author JayNing
 * created by 2020/7/27 10:54
 **/
public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable hashtable = new Hashtable();
        hashtable.put(null,"test");
        System.out.println(hashtable);

        HashMap hashMap = new HashMap();
        hashMap.put(null,null);
        System.out.println(hashMap.size());
    }
}

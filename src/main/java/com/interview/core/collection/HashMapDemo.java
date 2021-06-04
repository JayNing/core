package com.interview.core.collection;

import java.util.HashMap;

/**
 * ClassName: HashMapDemo
 * Description:
 * date: 2021/2/21 9:13
 *
 * @author ningjianjian
 */
public class HashMapDemo {

    public static void main(String[] args) {
        int n = 34674578;
        int length = 14;
        System.out.println(n % length);
        System.out.println(n & (length - 1));

        HashMap<String, Integer> map = new HashMap<>(3);
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        System.out.println(map.size());
        map.put("4",4);
        System.out.println(map.size());
    }

}

package com.main;

import com.detaildemo.demo1.util.GsonUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: MainTest
 * Description:
 * date: 2020/11/17 11:34
 *
 * @author ningjianjian
 */
public class MainTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(3);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list.size());
        list.add(1);
        System.out.println(list.size());
    }

    @Test
    public void test2(){
        Set<String> set = new HashSet<>();
        set.add("123");
        set.add("1c3");
        set.add("1b");

        Set<String> set2 = new HashSet<>();
        set2.add("1234");
        set2.add("1c3");
        set2.add("1b4");

        Set<String> set3 = set;

        set.retainAll(set2);
        System.out.println(GsonUtils.toJsonString(set));
        System.out.println(GsonUtils.toJsonString(set2));
        System.out.println(GsonUtils.toJsonString(set3));
        set2.removeAll(set3);
        System.out.println(GsonUtils.toJsonString(set2));
    }

    @Test
    public void test(){
        Set<String> set = new HashSet<>();
        set.add("123");
        set.add("1c3");
        set.add("1b");
        String collect = set.stream().collect(Collectors.joining(","));
        System.out.println(collect);
        List<String> strings = Arrays.asList(collect.split(","));
        System.out.println(set.containsAll(strings));
    }
}

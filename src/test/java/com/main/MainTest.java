package com.main;

import java.util.ArrayList;
import java.util.List;

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
}

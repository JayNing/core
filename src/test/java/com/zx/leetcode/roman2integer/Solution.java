package com.zx.leetcode.roman2integer;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JAY
 * @Date 2019/6/16 14:25
 * @Description 罗马数字转int
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }

    public static int romanToInt(String s) {
        if (s == null){
            return 0;
        }
        Map<String, Integer> romanNumAll = new HashMap<>(7);
        romanNumAll.put("I",1);
        romanNumAll.put("V",5);
        romanNumAll.put("X",10);
        romanNumAll.put("L",50);
        romanNumAll.put("C",100);
        romanNumAll.put("D",500);
        romanNumAll.put("M",1000);

        Map<String, Integer> romanNum = new HashMap<>(6);
        romanNum.put("IV",4);
        romanNum.put("IX",9);
        romanNum.put("XL",40);
        romanNum.put("XC",90);
        romanNum.put("CD",400);
        romanNum.put("CM",900);
        int sum = 0;

        for (Map.Entry<String , Integer> entry : romanNum.entrySet()){
            if (s.contains(entry.getKey())){
                sum = sum + entry.getValue();
                s = s.replace(entry.getKey(),"_");
            }
        }
        String[] split = s.split("_");
        if (split != null && split.length > 0){
            for (String s1 : split) {
                char[] chars = s1.toCharArray();
                for (char aChar : chars) {
                    sum = sum + romanNumAll.get(String.valueOf(aChar));
                }
            }
        }
        if (sum > 3999){
            return 3999;
        }
        return sum;
    }
}

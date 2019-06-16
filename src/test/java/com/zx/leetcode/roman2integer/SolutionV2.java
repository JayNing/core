package com.zx.leetcode.roman2integer;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author JAY
 * @Date 2019/6/16 14:25
 * @Description 罗马数字转int
 **/
public class SolutionV2 {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        if (null == s){
            return 0;
        }
        int sum = 0;

        TreeMap<String, Integer> romanNumAll = new TreeMap<String, Integer>();
        romanNumAll.put("I",1);
        romanNumAll.put("V",5);
        romanNumAll.put("X",10);
        romanNumAll.put("L",50);
        romanNumAll.put("C",100);
        romanNumAll.put("D",500);
        romanNumAll.put("M",1000);

        Map<String, Integer> romanNumSort = new HashMap<>(7);
        romanNumSort.put("I",1);
        romanNumSort.put("V",2);
        romanNumSort.put("X",3);
        romanNumSort.put("L",4);
        romanNumSort.put("C",5);
        romanNumSort.put("D",6);
        romanNumSort.put("M",7);

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++){
            String charI = String.valueOf(chars[i]);
            if (i + 1 >= chars.length){
                sum = sum + romanNumAll.get(charI);
                break;
            }
            String charI1 = String.valueOf(chars[i + 1]);
            if (romanNumSort.get(charI) >= romanNumSort.get(charI1)){
                sum = sum + romanNumAll.get(charI);
            } else {
              sum = sum + (romanNumAll.get(charI1) - romanNumAll.get(charI));
              i = i + 1;
            }
        }
        if (sum > 3999){
            return 3999;
        }
        return sum;
    }
}

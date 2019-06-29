package com.zx.leetcode.longestcommonprefix;

/**
 * @Author JAY
 * @Date 2019/6/29 13:30
 * @Description 最长公共前缀
 **/
public class SolutionV2 {

    public static void main(String[] args) {
//        String[] str = {"dog","dracecar","dcar"};
//        String[] str = {"flower","flow","flight"};
        String[] str = {"flow","flow2","flow3","flight"};
//        String[] str = {"1flow","2flow","flow"};
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(s) != 0){
                s = s.substring(0,s.length() - 1);
                if (s.isEmpty()){
                    return "";
                }
            }
        }
        return s;
    }

}

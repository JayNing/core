package com.zx.leetcode.longestcommonprefix;

/**
 * @Author JAY
 * @Date 2019/6/29 13:30
 * @Description 最长公共前缀
 **/
public class Solution {

    public static void main(String[] args) {
//        String[] str = {"dog","dracecar","dcar"};
//        String[] str = {"flower","flow","flight"};
//        String[] str = {"flow","flow","flow"};
        String[] str = {"1flow","2flow","flow"};
        System.out.println(longestCommonPrefix(str));
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }

        boolean begin = true;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int length = strs.length;
        String first = strs[0];

        while (begin){
            try {
                String substring = first.substring(i, i + 1);
                for (int index = 1; index < length; index++){
                    if (!substring.equals(strs[index].substring(i,i+1))){
                        begin = false;
                        break;
                    }
                }
                if (begin){
                    sb = sb.append(substring);
                }
                if (first.equals(sb.toString())){
                    //说明已经全部匹配到了，推出循环
                    begin = false;
                }
                i++;
            }catch (Exception e){
                begin = false;
            }
        }
        return sb.length() == 0 ? "" : sb.toString();
    }

}

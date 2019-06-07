package com.zx.leetcode.isPalindrome;

/**
 * @Author JAY
 * @Date 2019/6/7 12:26
 * @Description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 **/
public class Solution {

    public static void main(String[] args) {
        System.out.println(isPalindrome(2147483647));
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {

        //需要考虑数字反转之后是否超过int的界限

        if(x < 0){
            return false;
        }
        int y = x;
        String num = String.valueOf(x);
        int length = num.length();

        double convertNum = 0;

        for(int i = length - 1; i >= 0 ; i--){
            int high = (int) (x / Math.pow(10,i));
            convertNum = convertNum + high * Math.pow(10,length - i - 1);
            x = (int) (x - high * Math.pow(10,i));
        }

        if (convertNum == y){
            return true;
        }
        return false;

    }
}

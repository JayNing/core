package com.zx.leetcode.isPalindrome;

/**
 * @Author JAY
 * @Date 2019/6/7 12:26
 * @Description 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 **/
public class SolutionV2 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(2147483647));
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {

        //需要考虑数字反转之后是否超过int的界限
        //边界判断
        if (x < 0) {
            return false;
        }
        int div = 1;
        //
        while (x / div >= 10) {
            div *= 10;
        }
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }
}

package com.detaildemo.demo3;

/**
 * author JayNing
 * created by 2020/1/9 19:04
 * 一个int数组，里面有很多数字。但是只有一个数字是单独一个，其他的数字都是两个。数字没有顺序，如何找出单独的数字
 **/
public class LeecodeTest {

    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        int[] arr = new int[]{1,2,3,4,5,6,4,2,5,1,6};
        int a = 0;
        for (int i : arr) {
            String resultA = Integer.toBinaryString(a);
            String resultI = Integer.toBinaryString(i);
            System.out.println("a对应的二进制：" + resultA);
            System.out.println("i对应的二进制：" + resultI);
            a = a ^ i;
            System.out.println(a);
        }
        System.out.println("单独的数字为：" + a);
    }

    public static void test2(){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,6};
        int a = 0;
        for (int i : arr) {
            a = a ^ i;
        }
        int b = 0;
        for (int i = 1; i <= 15; i++) {
            b = b ^ i;
        }

        System.out.println("重复的数字为：" + (a ^ b));
    }

}

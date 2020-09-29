package com.algorithm.array.easy;

import com.util.GsonUtils;

import java.util.Arrays;

/**
 * ClassName: MaxNumProduct
 * Description: 三个数的最大乘积
 *
 *给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 *
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。

 * 链接：https://leetcode-cn.com/problems/maximum-product-of-three-numbers*
 *
 * @author ningjianjian
 */
public class MaxNumProduct {

    public static void main(String[] args) {
        int[] nums = {722,634,-504,-379,163,-613,-842,-578,750,951,-158,30,-238,-392,-487,-797,-157,-374,999,-5,-521,-879,
                -858,382,626,803,-347,903,-205,57,-342,186,-736,17,83,726,-960,343,-984,937,-758,-122,577,-595,-544,
                -559,903,-183,192,825,368,-674,57,-959,884,29,-681,-339,582,969,-95,-455,-275,205,-548,79,258,35,
                233,203,20,-936,878,-868,-458,-882,867,-664,-892,-687,322,844,-745,447,-909,-586,69,-88,88,445,-553,
                -666,130,-640,-918,-7,-420,-368,250,-786};
//        int[] nums = { -4, -3, -2, -1, -60, -5 ,-1};
//        int[] nums = {1,3,4,5,6,-7,3,4,5,6};
        System.out.println(maximumProductV2(nums));
    }

    public static int maximumProductV2(int[] nums) {
        Arrays.sort(nums);
        System.out.println(GsonUtils.toJsonString(nums));
        return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 3] * nums[nums.length - 1] * nums[nums.length - 2]);
    }

    public static int maximumProduct(int[] nums) {
        if(nums == null || nums.length < 3){
            return -1;
        }

       for (int i = 0; i < nums.length; i++) {
           for (int j = i+1; j < nums.length; j++) {
               if (Math.abs(nums[j]) > Math.abs(nums[i])) {
                   int tmp = nums[i];
                   nums[i] = nums[j];
                   nums[j] = tmp;
               }
           }
       }
        System.out.println(GsonUtils.toJsonString(nums));

        int product = nums[0] * nums[1] * nums[2];
        if (product < 0){
            //说明三个数中的负数个数为奇数

            //将前三位从大到小排序
            if (nums.length > 3){
                for (int i = 0; i < 3; i++) {
                    for (int j = i+1; j < 3; j++) {
                        if (nums[j] > nums[i]) {
                            int tmp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = tmp;
                        }
                    }
                }
                System.out.println(GsonUtils.toJsonString(nums));

                //将从第3位开始后面的数字，从大到小排序
                for (int i = 3; i < nums.length; i++) {
                    for (int j = i+1; j < nums.length; j++) {
                        if (nums[j] > nums[i]) {
                            int tmp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = tmp;
                        }
                    }
                }
                System.out.println(GsonUtils.toJsonString(nums));

                //前三位都是负数的情况
                if (nums[0] < 0 && nums[1] < 0 && nums[2] < 0){
                    if(nums[3] < 0){
                        //说明第三位开始，后面数字全部都是负数
                        return product;
                    }
                    //将前三位中负数最大的换成后面数字中的正数最大的
                    product = nums[1] * nums[2] * nums[3];
                    return product;
                }

                //前三位有一个负数的情况

                //2种策略，1、将前三位中，正数最小的值换成后面数字中负数最小的； 2、将前三位中负数换成后面数字中的正数最大的
                //比较上述两种策略的结果，哪个值更大
                int product1 = nums[0] * nums[2] * nums[nums.length - 1];
                int product2 = nums[0] * nums[1] * nums[3];
                if (product1 > product2){
                    return product1;
                }else {
                    return product2;
                }
            }
        }

        return product;

    }

}

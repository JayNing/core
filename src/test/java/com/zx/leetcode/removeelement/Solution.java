package com.zx.leetcode.removeelement;

import java.util.Arrays;

/**
 * @Author JAY
 * @Date 2019/6/14 17:25
 * @Description 移除元素
 **/
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int len = removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        int zeroCount = 0;
        int afterZeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]){
                zeroCount++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]){
                nums[i] = 0;
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <  nums.length; j++){
              if (nums[i] <= nums[j]){
                  int a = nums[i];
                  nums[i] = nums[j];
                  nums[j] = a;
              }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (0 == nums[i]){
                afterZeroCount++;
            }
        }

        int valCount = afterZeroCount - zeroCount;

        return nums.length - valCount;
    }
}

package com.zx.leetcode.removeelement;

/**
 * @Author JAY
 * @Date 2019/6/14 17:25
 * @Description 移除元素
 **/
public class SolutionV2 {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,2,2,2,2,2,2,2,2,0,1,2,2,3,0,4,2};
        int val = 2;
        int len = removeElement(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {

        int valCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                valCount++;
            }
        }
        int valCount2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (valCount2 >= valCount){
                break;
            }
            if (nums[i] == val){
                valCount2++;
                for (int j = nums.length - 1; j > i ; j--) {
                    if (nums[j] != val){
                        int a = nums[i];
                        nums[i] = nums[j];
                        nums[j] = a;
                    }
                }
            }
        }

        return nums.length - valCount;
    }
}

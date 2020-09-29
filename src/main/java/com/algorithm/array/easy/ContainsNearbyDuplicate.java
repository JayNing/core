package com.algorithm.array.easy;

import com.util.GsonUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ClassName: ContainsNearbyDuplicate
 * Description: 存在重复元素 II
 *
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。 
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 *
 * 容易疏忽题意：是最小的差的绝对值不超过 k
 *
 * @author ningjianjian
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,0,0,7,8,9,10,11,12,0};
        System.out.println(containsNearbyDuplicate(nums,1));
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k < 1){
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null) {
                //说明是重复数据
                if (i - index <= k){
                    return true;
                }

            }
            map.put(nums[i],i);
        }
        return false;
    }

    public static boolean containsNearbyDuplicateV2(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k < 1){
            return false;
        }

        int minInterval = 0;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
           for (int j = i + 1; j < nums.length; j++) {
               if (nums[i] == nums[j]){
                   temp = j - i;
                   if (minInterval == 0 || temp < minInterval){
                       minInterval = temp;
                   }
               }
           }
        }
        return minInterval == 0 ? false : minInterval <= k;

    }

}

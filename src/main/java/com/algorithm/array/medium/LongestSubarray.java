package com.algorithm.array.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: LongestSubarray
 * Description: 绝对差不超过限制的最长连续子数组
 *
 *  给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 示例 2：
 *
 * 输入：nums = [10,1,2,4,7,2], limit = 5
 * 输出：4
 * 解释：满足题意的最长子数组是 [2,4,7,2]，其最大绝对差 |2-7| = 5 <= 5 。
 * 示例 3：
 *
 * 输入：nums = [4,2,2,2,4,4,2,2], limit = 0
 * 输出：3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit
 *
 * @author ningjianjian
 */
public class LongestSubarray {

    public static void main(String[] args) {
       int[] nums = {8,2,4,7};
       int limit = 4;
        System.out.println(longestSubarray(nums,limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        if (nums.length == 1) {
            return 0;
        }

        int min = nums[0];
        int minIndex = 0;

        Map<Integer, Integer> counts = new HashMap<>();
        int i = 0;
        while (minIndex < nums.length - 1) {
            int chazhi = Math.abs(min - nums[i]);
            if (chazhi <= limit){
                Integer count = counts.get(minIndex);
                if (count == null){
                    count = 0;
                }
                if (i - minIndex + 1 > count){
                    count = i - minIndex + 1;
                }
                counts.put(minIndex, count);
            }

            if (nums[i] < min){
                min = nums[i];
                minIndex = i;
            }
            if (i == nums.length - 1){
                min = nums[minIndex + 1];
                minIndex = minIndex + 1;
                i = minIndex + 1;
            } else {
                i++;
            }

        }

        int maxCount = 0;
        if (counts.size() > 0){
            Set<Integer> integers = counts.keySet();
            for (Integer integer : integers) {
                if (maxCount < counts.get(integer)){
                    maxCount = counts.get(integer);
                }
            }
        }

        return maxCount;
    }

}

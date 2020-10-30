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
       int[] nums = {8};
       int limit = 10;
       // longestSubarrayV2运行超时
        System.out.println(longestSubarrayV2(nums,limit));
    }

    public static int longestSubarrayV3(int[] nums, int limit) {
        int min;
        int max;
        int indexMin=0;//记录窗口中最大值的位置
        int indexMax=0;;//记录窗口中最小值的位置
        int i=0;
        int number=1;//初始窗口大小为一
        while(i<nums.length-1){
            int j=i+1;
            int start=i;
            //符合条件进入循环
            if(Math.abs(nums[j]-nums[i])<=limit) {
                //符合条件的话就更新位置信息 ！！！！！！！！！！！ 重点在于更新位置信息，这是节约时间最关键的一步
                if(nums[j]>nums[i]){
                    indexMax=j;
                    indexMin=i;
                }else {
                    indexMax=i;
                    indexMin=j;
                }
                max = Math.max(nums[j], nums[i]);
                min = Math.min(nums[j], nums[i]);
                while (Math.abs(max - min) <= limit) {
                    j++;
                    if (j >= nums.length) break;
                    //一定要写等于，不然可能出现一大堆相同的数字，导致超出时间，加个等于，就会选到最后一个符合条件的位置
                    if(nums[j]>=max) {
                        if(nums[j]-min>limit)
                            i=indexMin+1;
                        else
                            indexMax = j;
                    }
                    if(nums[j]<=min) {
                        if(max-nums[j]>limit)
                            i=indexMax+1;
                        else
                            indexMin=j;
                    }
                    max = Math.max(nums[j], max);
                    min = Math.min(nums[j], min);
                }
                //出来记录窗口的大小
                number = Math.max(number, j - start);
                if (j >= nums.length) break;

            }else//不符合的直接加一
                i++;


        }
        return number;

    }

    public static int longestSubarrayV2(int[] nums, int limit) {
        if (nums.length == 1) {
            return 1;
        }

        int left = 1;
        int right = nums.length; // 7
        int ans = 0;
        while (left <= right){
            //mid为区间组长度
            int mid = (left + right) / 2; //4
            if (checkMid(mid, nums, limit)){
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private static boolean checkMid(int mid, int[] nums, int limit) {
        int i = 0;
        int count = 0;
        while (i + mid <= nums.length){
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < i + mid; j++){
                if (nums[j] < min){
                    min = nums[j];
                }
                if (nums[j] > max){
                    max = nums[j];
                }
            }
            int chazhi = Math.abs(max - min);
            if (chazhi <= limit){
                count++;
                break;
            }
            i++;
        }

        return count > 0;

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

package com.algorithm.array.easy;

import com.util.GsonUtils;

import java.util.Arrays;
import java.util.Stack;

/**
 * ClassName: MergeArray
 * Description:  合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 *
 * @author ningjianjian
 */
public class MergeArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,0,0,0};
        int m = 5;
        int[] nums2 = {2,5,6};
        int n = 3;
        mergeV2(nums1,m,nums2,n);

    }

    public static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        System.arraycopy(nums1, 0, nums, 0, m);

        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < m && p2 < n){
            if (nums[p1] <= nums2[p2]){
                nums1[i] = nums[p1];
                p1++;
            } else {
                nums1[i] = nums2[p2];
                p2++;
            }
            i++;
        }

        if (p1 >= m &&  p2 < n){
            //判断nums2是否还有剩余
            System.arraycopy(nums2, p2, nums1, i, n - p2);
        }

        if (p2 >= n &&  p1 < m){
            //判断nums是否还有剩余
            System.arraycopy(nums, p1, nums1, i, m - p1);
        }

        System.out.println(GsonUtils.toJsonString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //System.arraycopy, 将源数组num2从下标0位开始，copy到目标数组num1对应的下标m处，copy长度为源数组中的从srcPos下标开始前n个元素
        System.arraycopy(nums2, 0, nums1, m, n);
        System.out.println(GsonUtils.toJsonString(nums1));
        System.out.println("========== Sorted ============");
        Arrays.sort(nums1);
        System.out.println(GsonUtils.toJsonString(nums1));
    }
}

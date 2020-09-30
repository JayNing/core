package com.algorithm.array.medium;

/**
 * ClassName: SplitArray
 * Description: 分割数组的最大值
 *
 * 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * 示例:
 *
 * 输入:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * 输出:
 * 18
 *
 * 解释:
 * 一共有四种方法将nums分割为2个子数组。
 * 其中最好的方式是将其分为[7,2,5] 和 [10,8]，
 * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/split-array-largest-sum
 *
 * @author ningjianjian
 */
public class SplitArray {

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(splitArray(nums,m));
    }

    public static int splitArray(int[] nums, int m) {

        int max = 0, total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            total += nums[i];
        }

        int left = max;
        int right = total;

        while (left <= right){
            int mid = (left + right) / 2;
            if (checkMid(mid, nums, m)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    /**
     * 贪心地模拟分割的过程，从前到后遍历数组，用 sum 表示当前分割子数组的和，
     * cnt 表示已经分割出的子数组的数量（包括当前子数组），那么每当 sum 加上当前值超过了 xx，
     * 我们就把当前取的值作为新的一段分割子数组的开头【注意：当前值是下一个数组段的开头】，
     * 并将 cnt 加 1。遍历结束后验证是否 cnt 不超过 mm。
     * @param mid
     * @param nums
     * @param m
     * @return
     */
    private static boolean checkMid(int mid, int[] nums, int m) {
        int count = 0;
        int i = 0;
        int sum = 0;
        while (i < nums.length){
            if (sum + nums[i] > mid){
                count++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            i++;
        }

        return count >= m;
    }
}

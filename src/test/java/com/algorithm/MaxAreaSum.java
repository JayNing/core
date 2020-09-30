package com.algorithm;

import com.detaildemo.demo1.util.GsonUtils;

import java.util.Stack;

/***
 * 区间最大和，
 * 给定任意整数数组，取中间任意区间组成的新数组，取新数组的最小值与新数组数据之和相乘，得到的最大值是多少
 */

public class MaxAreaSum {

    public static void main(String[] args) {
        int[] numbers = {4,3,6,7,2};
        System.out.println(getMax(numbers));

    }

    public static int getMax(int[] numbers){
        if (numbers == null || numbers.length == 0){
            return 0;
        }

        //求前缀和数组
        int[] sum = new int[numbers.length + 1];
        for (int i = 1; i <= numbers.length; i++){
            sum[i] = sum[i - 1] + numbers[i - 1];
        }
        System.out.println(GsonUtils.toJsonString(sum));
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++){
            while (!stack.isEmpty() && numbers[i] < numbers[stack.peek()]){
                int index = stack.pop();
                int left = i;
                int right = i;
                if (stack.isEmpty()){
                    left = 0;
                } else {
                  left = index;
                }
                int i1 = numbers[index] * (sum[right] - sum[left]);
                max = Math.max(max, i1);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int index = stack.pop();
            int left = numbers.length;
            int right = numbers.length;
            if (stack.isEmpty()){
                left = 0;
            } else {
                left = index;
            }
            max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
        }

        return max;
    }

}

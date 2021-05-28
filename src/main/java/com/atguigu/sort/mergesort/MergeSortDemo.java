package com.atguigu.sort.mergesort;

import java.util.Arrays;

/**
 * @author ningjianjian
 * @Date 2021/5/28 10:25 上午
 * @Description 归并排序
 * <p>
 * 归并排序采用 分治策略（分治法将问题分成一些小的问题，然后递归求解；而治的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之）
 */
public class MergeSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{8, 4, 5, 7, 1, 3, 6, 2};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        int[] temp = new int[arr.length];

        mergeSortSeparate(arr, 0, arr.length - 1, temp);

        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 分开的方法
     * @param arr 要排序的原始数组
     * @param left 子序列的左侧下标
     * @param right 子序列的右侧下标
     * @param temp 做中转的数组
     */
    public static void mergeSortSeparate(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;

            //向左递归进行分解
            mergeSortSeparate(arr, left, mid, temp);

            //向右递归进行分解
            mergeSortSeparate(arr, mid + 1, right, temp);
            //合并
            mergeSortMerge(arr, left, mid, right, temp);
        }

    }


    /**
     * 合并的方法
     *
     * @param arr   排序的原始数组
     * @param left  左侧有序序列的初始索引
     * @param mid   中间索引
     * @param right 最右边的索引
     * @param temp  做中转的数组
     *
     * 合并相邻有序子序列思路：
     *    1、先把左右两边有序序列的数据按照规则填充到tmp中，直到有一边的有序序列处理完毕为止
     *    2、把有剩余数据的一侧数据，填充到tmp中
     *    3、将临时数组temp中的数据copy到arr中，注意：并不是每次都拷贝所有，每次拷贝的是从入参中left下标到right下标的区间数据
     */
    public static void mergeSortMerge(int[] arr, int left, int mid, int right, int[] temp) {
//        System.out.println("left = " + left + ",right = " + right);
//        System.out.println(Arrays.toString(arr));
        //temp的当前位置下标
        int t = 0;
        //初始化l， 左侧有序序列的初始索引
        int l = left;
        //初始化r， 右侧有序序列的初始索引
        int r = mid + 1;

        /**
         * 一、先把左右两边有序序列的数据按照规则填充到tmp中，直到有一边的有序序列处理完毕为止
         */

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                t++;
                l++;
            } else {
                temp[t] = arr[r];
                t++;
                r++;
            }
        }
        /**
         * 二、把有剩余数据的一侧数据，填充到tmp中
         */
        while (l <= mid) {
            //说明左侧有剩余
            temp[t] = arr[l];
            t++;
            l++;
        }
        while (r <= right) {
            //说明右侧有剩余
            temp[t] = arr[r];
            t++;
            r++;
        }
        /**
         * 三、将临时数组temp中的数据copy到arr中
         *  注意：并不是每次都拷贝所有，每次拷贝的是从入参中left下标到right下标的区间数据
         */
        t = 0; //从temp的0下标开始拷贝
        for (int i = left; i <= right; i++) {
            arr[i] = temp[t];
            t++;
        }
    }


}

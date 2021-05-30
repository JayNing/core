package com.atguigu.search.binarysearch;

/**
 * @author ningjianjian
 * @Date 2021/5/29 10:42 上午
 * @Description 二分查找法
 * <p>
 * 二分查找法有一个前提： 数组元素必须是有序的
 */
public class BinarySearchDemo {

    public static void main(String[] args) {
        int[] arr = {0,3,4,12,15,17,45,46,48,87};
        int index = binarySearch(arr, 0, arr.length - 1, 48);
        System.out.println("找到的下标值：" + index);
    }

    /**
     * 二分法，递归查找元素
     * 思路：
     * 1、获取中间下标mid = (left + right) / 2
     * 2、如果 arr[mid] > findVal， 则向左递归查找
     * 3、如果 arr[mid] < findVal， 则向右递归查找
     * 4、如果 arr[mid] == findVal， 说明找到，返回，退出递归
     * 5、如果 数组遍历完毕, left > right，仍没有找到元素，也返回，退出递归
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            //说明数组遍历完了，仍没有找到
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] > findVal) {
            //向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else if (arr[mid] < findVal) {
            //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            //说明找到了，退出递归
            return mid;
        }
    }

}

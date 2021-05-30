package com.atguigu.search.insertvaluesearch;

/**
 * @author ningjianjian
 * @Date 2021/5/29 11:03 上午
 * @Description 插值查找
 *
 * 前提条件：数组元素必须是有序的
 * 类似于二分查找，只是获取mid的规则变化了。
 * 二分法中，mid = (left + right) / 2，
 * 插值法中，mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left])
 *
 * 插值查找注意事项：
 *  1）对于数据量较大，关键字分步比较均匀的查找表来说，采用插值查找，速度比较快
 *  2）关键字分布不均匀[数值跳跃性很大]的情况下，该方法不一定比折半查找要好
 *
 */
public class InsertValueSearchDemo {

    public static void main(String[] args) {
        int maxLength = 100;
        int[] arr = new int[maxLength];
        for (int i = 0; i < maxLength; i++){
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 86);
        System.out.println("找到的下标值：" + index);
    }

    /**
     * 插值法，递归查找元素
     * 思路：
     * 1、获取中间下标mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left])
     * 2、如果 arr[mid] > findVal， 则向左递归查找
     * 3、如果 arr[mid] < findVal， 则向右递归查找
     * 4、如果 arr[mid] == findVal， 说明找到，返回，退出递归
     * 5、如果 数组遍历完毕, left > right || findVal < arr[0] || findVal > arr[arr.length - 1]，仍没有找到元素，也返回，退出递归
     *      注意： findVal < arr[0] || findVal > arr[arr.length - 1]必须需要，否则我们找到的mid可能越界
     *
     * @param arr
     * @param left
     * @param right
     * @param findVal
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("标志查询被触发~~~");
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            //说明数组遍历完了，仍没有找到
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        if (arr[mid] > findVal) {
            //向左递归
            return insertValueSearch(arr, left, mid - 1, findVal);
        } else if (arr[mid] < findVal) {
            //向右递归
            return insertValueSearch(arr, mid + 1, right, findVal);
        } else {
            //说明找到了，退出递归
            return mid;
        }
    }



}

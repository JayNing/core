package com.atguigu.sort.selection;

import java.util.Arrays;

/**
 * @author ningjianjian
 * @Date 2021/5/24 8:45 下午
 * @Description 选择排序Demo
 */
public class SelectSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,-6};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        selectSortUpgrade(arr);
//        System.out.println("排序后：");
//        System.out.println(Arrays.toString(arr));
    }

    public static void selectSortUpgrade(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (min > arr[j]){
                    min = arr[j]; //重置min
                    minIndex = j; //重置minIndex
                }
            }
            //将最小值，放在arr[0]，即交换
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.println("第" + (i + 1) + "轮后~~~~");
            System.out.println(Arrays.toString(arr));
        }
    }

        /**
         *    //选择排序一共有数组大小-1轮排序
         *    找到每一轮的小循环
         * @param arr
         */
    public static void selectSort(int[] arr){

        //假定最小数为arr[0]
        int min = arr[0];
        //假定最小数索引为0
        int minIndex = 0;

        //第一轮
        for (int j = 0 + 1 + 0; j < arr.length; j++){
            if (min > arr[j]){
                min = arr[j]; //重置min
                minIndex = j; //重置minIndex
            }
        }
        //将最小值，放在arr[0]，即交换
        if (minIndex != 0){
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第1轮后~~~~");
        System.out.println(Arrays.toString(arr));


        min = arr[1];
        minIndex = 1;
        //第二轮
        for (int j = 0 + 1 + 1; j < arr.length; j++){
            if (min > arr[j]){
                min = arr[j]; //重置min
                minIndex = j; //重置minIndex
            }
        }
        //将最小值，放在arr[1]，即交换
        if (minIndex != 1) {
            arr[minIndex] = arr[1];
            arr[1] = min;
        }
        System.out.println("第2轮后~~~~");
        System.out.println(Arrays.toString(arr));

        min = arr[2];
        minIndex = 2;
        //第三轮
        for (int j = 0 + 1 + 2; j < arr.length; j++){
            if (min > arr[j]){
                min = arr[j]; //重置min
                minIndex = j; //重置minIndex
            }
        }
        //将最小值，放在arr[2]，即交换
        if (minIndex != 2) {
            arr[minIndex] = arr[2];
            arr[2] = min;
        }
        System.out.println("第3轮后~~~~");
        System.out.println(Arrays.toString(arr));

    }

}

package com.atguigu.sort.shellsort;

import java.util.Arrays;

/**
 * @author ningjianjian
 * @Date 2021/5/26 5:38 下午
 * @Description 希尔排序demo
 *
 * 希尔排序目的为了加快速度改进了插入排序，交换不相邻的元素对数组的局部进行排序，并最终用插入排序将局部有序的数组排序
 */
public class ShellSortDemo {

    public static void main(String[] args) {
//        int[] arr = new int[]{14,13,5,6,2,4,3,2,1,3,-8,0,-9,4,5};
//        int[] arr = new int[]{14,13,5,6,2,24,-1,43,-5,23};
        int[] arr = new int[]{8,9,1,7,2,3,5,4,6,0};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));

        shellSortMove(arr); //位移法
//        shellSortChange(arr); //换位法
//        shellSort(arr);

        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 位移法————希尔排序
     * @param arr
     */
    private static void shellSortMove(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++){
                int j = i;
                int tmp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && tmp < arr[j - gap]){
                        //后移
                        arr[j] = arr[j - gap];
                        j-=gap;
                    }
                    //当while退出后，就给tmp找到了插入的位置
                    arr[j] = tmp;
                }
            }
        }
    }

    /**
     * 合并分步步骤，《交换法》，希尔排序，速度慢
     * @param arr
     */
    private static void shellSortChange(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++){
                //遍历各组中的所有的元素（共5组，每组有2个元素），j-=5，因为步长是5
                for (int j = i-gap; j >= 0; j -= gap){
                    if (arr[j] > arr[j+gap]) {
                        //如果当前元素大于加上步长后的那个元素，说明交换
                        int tmp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j+gap] = tmp;
                    }
                }
            }
        }
    }

    /**
     * 分步推导排序---《交换法》——————【从小到大】
     * @param arr
     */
    private static void shellSort(int[] arr) {
        int tmp = 0;
        //第一轮
        //第一轮增量5[10个元素]

        //因为第1轮排序，是将10个元素分成5组
        for (int i = 5; i < arr.length; i++){
            //遍历各组中的所有的元素（共5组，每组有2个元素），j-=5，因为步长是5
            for (int j = i-5; j >= 0; j -= 5){
                if (arr[j] > arr[j+5]) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    tmp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j+5] = tmp;
                }
            }
        }

        System.out.println("第一轮排序后：");
        System.out.println(Arrays.toString(arr));

        //第二轮
        //第二轮增量

        for (int i = 2; i < arr.length; i++){
            //遍历各组中的所有的元素（共2组，每组有5个元素），j-=2，因为步长是2
            for (int j = i-2; j >= 0; j-=2){
                if (arr[j] > arr[j+2]) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    tmp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j+2] = tmp;
                }
            }
        }

        System.out.println("第二轮排序后：");
        System.out.println(Arrays.toString(arr));

        //第三轮
        //第三轮增量

        for (int i = 1; i < arr.length; i++){
            //遍历各组中的所有的元素（共1组，每组有10个元素），j-=1，因为步长是1
            for (int j = i-1; j >= 0; j-=1){
                if (arr[j] > arr[j+1]) {
                    //如果当前元素大于加上步长后的那个元素，说明交换
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = tmp;
                }
            }
        }

        System.out.println("第三轮排序后：");
        System.out.println(Arrays.toString(arr));
    }

}

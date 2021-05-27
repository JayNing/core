package com.atguigu.sort.bubblesort;

import java.util.Arrays;

/**
 * @author ningjianjian
 * @Date 2021/5/24 8:36 下午
 * @Description 冒泡排序demo
 */
public class BubbleSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,3,7,1,3,-6,9};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){

        int tmp;
        boolean isChange = false;
        for (int i = 0; i < arr.length - 1; i++){
            for (int j = 0; j < arr.length - 1; j++){
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                    isChange = true;
                }
            }
            if (!isChange) {
                break;
            } else {
                isChange = false;
            }
        }
    }

}

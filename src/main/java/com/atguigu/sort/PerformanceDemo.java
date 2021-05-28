package com.atguigu.sort;

import com.atguigu.sort.bubblesort.BubbleSortDemo;
import com.atguigu.sort.insertsort.InsertSortDemo;
import com.atguigu.sort.mergesort.MergeSortDemo;
import com.atguigu.sort.quicksort.QuickSortDemo;
import com.atguigu.sort.radixsort.RadixSortDemo;
import com.atguigu.sort.selection.SelectSortDemo;
import com.atguigu.sort.shellsort.ShellSortDemo;

import java.time.LocalDateTime;

/**
 * @author ningjianjian
 * @Date 2021/5/28 4:41 下午
 * @Description 各个排序方法的性能测试
 */
public class PerformanceDemo {

    public static void main(String[] args) {

//        int maxLength = 8;
        int maxLength = 8000000;
        int[] arr = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        System.out.println("排序前的时间：" + LocalDateTime.now());
//        BubbleSortDemo.bubbleSort(arr); //8W数据量，18s
//        InsertSortDemo.insertSort2(arr); //8W数据量，1s；80W数据量，1min30s
//        MergeSortDemo.mergeSortSeparate(arr, 0, arr.length - 1, new int[arr.length]); //800W数据量，1-2s
//        QuickSortDemo.quickSort(arr,0,arr.length - 1); //800W数据量，1-2s
//        RadixSortDemo.radixSort2(arr);  //800W数据量，1s
//        SelectSortDemo.selectSortUpgrade(arr);//8W数据量，3-4s
        ShellSortDemo.shellSortMove(arr);////800W数据量，2-3s
        System.out.println("排序后的时间：" + LocalDateTime.now());
    }

}

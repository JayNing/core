package com.atguigu.sort.quicksort;

import java.util.Arrays;

/**
 * @author ningjianjian
 * @Date 2021/5/27 4:14 下午
 * @Description 快速排序
 * <p>
 * 基本思想：
 * 通过一趟排序，将要排序的数据分割成独立的两部分。其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序。
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列
 */
public class QuickSortDemo {

    public static void main(String[] args) {
//        int[] arr = new int[]{8, 9, 1, 7, 2};
        int[] arr = new int[]{8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));

        //第一次排序，起点下标为0，终点下标为数组长度-1，即最后一个元素下标
        quickSort(arr, 0, arr.length - 1);

        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * @param arr   数组
     * @param left  左侧排序起点下标
     * @param right 右侧排序终点下标
     *              <p>
     *              假设每次以排序区间的中间下标位置的数为分割点
     *              将数据从小到大排序，则分割点左侧的数要小于分割点右侧的数
     */
    private static void quickSort(int[] arr, int left, int right) {

        int l = left;
        int r = right;

        int medianIndex = (left + right) / 2;
        //中轴值
        int medianValue = arr[medianIndex];
        int tmp = 0;

        while (l < r) {
            //遍历左侧区间，查找左侧数据大于中间值的数据
            while (arr[l] < medianValue) {
                l+=1;
            }
            //退出循环，说明左侧找到了比中间值大的数据

            //遍历右侧区间，查找左侧数据小于中间值的数据
            while (arr[r] > medianValue) {
                r-=1;
            }
            //退出循环，说明右侧找到了比中间值小的数据
            //将l和r的数据替换
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;

            //如果l>=r，说明medianValue的左右两边的值，已经按照左边全是小于等于medianValue，右边全是大于等于medianValue
            // 已经排序好了，退出当前这一层的排序
            if (l >= r){
                break;
            }

            //如果交换完后，发现这个arr[l]==medianValue，值相等，进行r--，前移
            // 【因为此时左侧已经到达最边上的点，没有数据需要移到遍历了，只有右侧还有数据需要遍历检查，循环继续】
            if (arr[l] == medianValue) {
                r-=1;
            }
            //如果交换完后，发现这个arr[r]==medianValue，值相等，进行l++，后移
            // 【因为此时右侧已经到达最边上的点，没有数据需要移到遍历了，只有左侧还有数据需要遍历检查，循环继续】
            if (arr[r] == medianValue) {
                l+=1;
            }
        }

        //如果l==r,必须l++,r--，否则会出现栈溢出
        if (l == r) {
            l+=1;
            r-=1;
        }

        //继续对两侧子数组进行排序
        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

}

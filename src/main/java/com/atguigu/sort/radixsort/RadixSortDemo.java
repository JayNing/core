package com.atguigu.sort.radixsort;

import java.util.Arrays;

/**
 * @author ningjianjian
 * @Date 2021/5/28 3:14 下午
 * @Description 基数排序（桶排序）
 *
 * 基数排序的基本思想：
 *    将所有待排序数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行依次排序。
 *    这样从最低位排序一直到最高位排序完成以后，数列就变成了一个有序序列。
 *
 *    注：
 *      1）基数排序法是稳定性排序法，相同数值的数字，排序后，前后顺序与排序前一致
 *      2）暂时不考虑负数（-）使用基数排序
 *      3）需要使用额外数组进行排序算法，用空间换时间
 */
public class RadixSortDemo {

    public static void main(String[] args) {
//        int[] arr = {53,3,542,748,14,214};
        int[] arr = {53,-3,542,-748,14,-214,34,21,-13,13};
//        int[] arr = {801, 745, 1290, 0, 762, 534, 782, 769, 735, 761};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));

//        radixSort(arr);
//        radixSort2(arr);
        radixSort3(arr);

        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 支持的包含负整数的基数排序
     * @param arr
     *
     * 思路：获取数组最小值（负整数），让数组所有元素减去最小值，之后，得到数组元素均>=0的数组；
     *      使用新数组进行正常的（全是正整数）基数排序，将排序后的数组的每个元素加上原始数组中的最小值，即可还原为原始数组的数据。
     *      最后，得到的数组即为原始数组经过基数排序后的数组
     *
     */
    public static void radixSort3(int[] arr){
        //获取最小值
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min){
                min = arr[i];
            }
        }

        //数组每个元素减去最小值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - min;
        }
        System.out.println("减去最小值后~~~");
        System.out.println(Arrays.toString(arr));
        //对转换后的数组进行基数排序
        radixSort2(arr);
        //数据每个元素加上最小值，还原数组
        for (int i = 0; i < arr.length; i++){
            arr[i] = arr[i] + min;
        }

    }

    /**
     * 合并推导基数排序算法
     * @param arr
     */
    public static void radixSort2(int[] arr){
        //获取总共需要排序的次数【为最大值的位数数量】
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = String.valueOf(max).length();

        //定义临时二维数组，作为桶，存储每次的排序变量
        //桶的特点： 0 1 2 3 4 5 6 7 8 9， 十个阿拉伯数字，用来给数组元素分类
        int[][] buckets = new int[10][arr.length - 1];
        //需要再定义一个一维数组，记录每个桶已经存储的数据量
        //下标对应桶的编号，值为对应桶内的元素个数
        int[] bucketIndex = new int[10];
        int t = 0;
        //循环排序
        for (int n = 0, m = 1; n < maxLength; n++, m*=10) {
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i] / m % 10; // 如： 12 % 10 = 2
                buckets[num][bucketIndex[num]] = arr[i];
                bucketIndex[num] += 1;
            }
            //将排序后的结果，拷贝到arr中
            t = 0;
            for (int i = 0; i < 10; i++) {
                if (bucketIndex[i] > 0){
                    //说明有数据
                    for (int j = 0; j < bucketIndex[i]; j++){
                        arr[t] = buckets[i][j];
                        t += 1;
                    }
                }
            }

            //需要将bucketIndex置空，为新一轮排序做准备
            bucketIndex = new int[10];

//            System.out.println("第" + (n + 1) + "轮排序后~~~");
//            System.out.println(Arrays.toString(arr));
        }

    }

    /**
     * 分步推导基数排序的算法操作
     * @param arr
     */
    public static void radixSort(int[] arr){
        //定义临时二维数组，作为桶，存储每次的排序变量
        //桶的特点： 0 1 2 3 4 5 6 7 8 9， 十个阿拉伯数字，用来给数组元素分类
        int[][] buckets = new int[10][arr.length - 1];
        //需要再定义一个一维数组，记录每个桶已经存储的数据量
        //下标对应桶的编号，值为对应桶内的元素个数
        int[] bucketIndex = new int[10];

        //第1轮，先比较个位数
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] % 10; // 如： 12 % 10 = 2
            buckets[num][bucketIndex[num]] = arr[i];
            bucketIndex[num] += 1;
        }
        //将排序后的结果，拷贝到arr中
        int t = 0;
        for (int i = 0; i < 10; i++) {
            if (bucketIndex[i] > 0){
                //说明有数据
                for (int j = 0; j < bucketIndex[i]; j++){
                    arr[t] = buckets[i][j];
                    t += 1;
                }
            }
        }

        System.out.println("第1轮排序后~~~");
        System.out.println(Arrays.toString(arr));

        //需要将bucketIndex置空，为新一轮排序做准备
        bucketIndex = new int[10];

        //第2轮，比较十位数
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] / 10 % 10; // 如： 123 / 10 % 10 = 2
            buckets[num][bucketIndex[num]] = arr[i];
            bucketIndex[num] += 1;
        }
        //将排序后的结果，拷贝到arr中
        t = 0;
        for (int i = 0; i < 10; i++) {
            if (bucketIndex[i] > 0){
                //说明有数据
                for (int j = 0; j < bucketIndex[i]; j++){
                    arr[t] = buckets[i][j];
                    t += 1;
                }
            }
        }

        System.out.println("第2轮排序后~~~");
        System.out.println(Arrays.toString(arr));

        //需要将bucketIndex置空，为新一轮排序做准备
        bucketIndex = new int[10];

        //第3轮，比较百位数
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] / 100 % 10; // 如： 1234 / 100 % 10 = 2
            buckets[num][bucketIndex[num]] = arr[i];
            bucketIndex[num] += 1;
        }
        //将排序后的结果，拷贝到arr中
        t = 0;
        for (int i = 0; i < 10; i++) {
            if (bucketIndex[i] > 0){
                //说明有数据
                for (int j = 0; j < bucketIndex[i]; j++){
                    arr[t] = buckets[i][j];
                    t += 1;
                }
            }
        }

        System.out.println("第3轮排序后~~~");
        System.out.println(Arrays.toString(arr));
    }

}

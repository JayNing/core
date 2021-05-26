package com.atguigu.sort.insertsort;

import java.util.Arrays;

/**
 * @author ningjianjian
 * @Date 2021/5/26 4:52 下午
 * @Description 插入排序demo
 * 插入排序法思想：
 *  把n个待排序的元素看成为一个有序表和一个无需表，开始时，有序表只包含一个元素（arr[0]），无序表中包含 n-1 个元素。
 *  排序过程中，每次从无序表中取出第一个元素，把它的值依次与有序表元素的值进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。
 *  当无序表中元素为空时，则排序结束
 */
public class InsertSortDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{14,13,5,6,2,4,3,2,1,3,-8,0,-9,4,5};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(arr));

        insertSort2(arr);

        System.out.println("排序后：");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 整合步骤，进行插入排序
     * @param arr
     */
    public static void insertSort2(int[] arr) {
        int insertIndex = -1;
        //每一轮待插入的值
        int insertVal;
        for (int i = 1; i < arr.length; i++){
            insertIndex = i - 1;
            insertVal = arr[i];
            //比较判断
            while (insertIndex >= 0 && arr[insertIndex] > insertVal){
                //此时说明待插入的无序表元素，比有序表中insertIndex下标的元素小，
                // 因为是从小到大排序，所以继续往有序表前面的下标找，直到找到比待插入数据小的数据为止;
                // 同时，将insertIndex的数据移到insertIndex+1处
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            //while循环退出，说明找到了需要插入的位置
            //由上方的while条件不成立，可知arr[insertIndex] > insertVal，所以将insertValue插入到insertIndex的下一个位置
            arr[insertIndex + 1] = insertVal;
        }
    }


    /**
     * 分解步骤，进行插入排序————【从小到大排序】
     */
    public static void insertSort(int[] arr){
        //第一轮
        //此时，有序表中元素为arr[0]
        //如果需要插入，则能插入的下标值
        int insertIndex = 1 - 1;
        //第一轮待插入的值
        int insertVal = arr[1];

        //比较判断
        while (insertIndex >= 0 && arr[insertIndex] > insertVal){
            //此时说明待插入的无序表元素，比有序表中insertIndex下标的元素小，
            // 因为是从小到大排序，所以继续往有序表前面的下标找，直到找到比待插入数据小的数据为止;同时，将insertIndex的数据移到insertIndex+1处
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        //while循环退出，说明找到了需要插入的位置
        //由上方的while条件不成立，可知arr[insertIndex] > insertVal，所以将insertValue插入到insertIndex的下一个位置
        arr[insertIndex + 1] = insertVal;

        System.out.println("第1轮排序~~~~");
        System.out.println(Arrays.toString(arr));

        //第二轮
        //如果需要插入，则能插入的下标值
        insertIndex = 2 - 1;
        //待插入的值
        insertVal = arr[2];

        //比较判断
        while (insertIndex >= 0 && arr[insertIndex] > insertVal){
            //此时说明待插入的无序表元素，比有序表中insertIndex下标的元素小，
            // 因为是从小到大排序，所以继续往有序表前面的下标找，直到找到比待插入数据小的数据为止;同时，将insertIndex的数据移到insertIndex+1处
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        //while循环退出，说明找到了需要插入的位置
        //由上方的while条件不成立，可知arr[insertIndex] > insertVal，所以将insertValue插入到insertIndex的下一个位置
        arr[insertIndex + 1] = insertVal;

        System.out.println("第2轮排序~~~~");
        System.out.println(Arrays.toString(arr));

        //第三轮
        //如果需要插入，则能插入的下标值
        insertIndex = 3 - 1;
        //待插入的值
        insertVal = arr[3];

        //比较判断
        while (insertIndex >= 0 && arr[insertIndex] > insertVal){
            //此时说明待插入的无序表元素，比有序表中insertIndex下标的元素小，
            // 因为是从小到大排序，所以继续往有序表前面的下标找，直到找到比待插入数据小的数据为止;同时，将insertIndex的数据移到insertIndex+1处
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        //while循环退出，说明找到了需要插入的位置
        //由上方的while条件不成立，可知arr[insertIndex] > insertVal，所以将insertValue插入到insertIndex的下一个位置
        arr[insertIndex + 1] = insertVal;

        System.out.println("第3轮排序~~~~");
        System.out.println(Arrays.toString(arr));

    }
}

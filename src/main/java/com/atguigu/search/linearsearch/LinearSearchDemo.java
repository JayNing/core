package com.atguigu.search.linearsearch;

/**
 * @author ningjianjian
 * @Date 2021/5/29 10:39 上午
 * @Description 线性（顺序）查找，查找元素在数组中的位置下标
 */
public class LinearSearchDemo {

    public static void main(String[] args) {
        int[] arr = {1,3,4,7,-4,-3,2,9,0,-7};
        System.out.println(linearSearch(arr,-7));
    }

    /**
     * 线性查找，不考虑元素重复出现的场景
     * @param arr
     * @param findVal
     * @return
     */
    public static int linearSearch(int[] arr, int findVal){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == findVal){
                return i;
            }
        }
        return - 1;
    }
}

package com.atguigu.search.fibonaccisearch;

import java.util.Arrays;

/**
 * @author ningjianjian
 * @Date 2021/5/30 10:25 上午
 * @Description 斐波那契查找算法
 *
 * 前提：数组元素必须有序
 *
 * 什么是斐波那契查找
 *       斐波那契数列，又称黄金分割数列，指的是这样一个数列：1、1、2、3、5、8、13、21、····，
 *       在数学上，斐波那契被递归方法如下定义：F(1)=1，F(2)=1，F(n)=f(n-1)+F(n-2) （n>=2）。
 *       该数列越往后相邻的两个数的比值越趋向于黄金比例值（0.618）。
 *
 *      斐波那契查找就是在二分查找的基础上根据斐波那契数列进行分割的。
 *      1、在斐波那契数列找一个等于略大于查找表中元素个数的数F[n]，
 *      2、将原查找表扩展为长度为F[n](如果要补充元素，则补充重复最后一个元素，直到满足F[n]个元素)，
 *      3、完成后进行斐波那契分割，即F[n]个元素分割为前半部分F[n-1]个元素，后半部分F[n-2]个元素，找出要查找的元素在那一部分并递归，直到找到。
 * 斐波那契查找的时间复杂度还是O(log 2 n )，但是 与折半查找相比，斐波那契查找的优点是它只涉及加法和减法运算，
 * 而不用除法，而除法比加减法要占用更多的时间，因此，斐波那契查找的运行时间理论上比折半查找小，但是还是得视具体情况而定。
 * 对于斐波那契数列：1、1、2、3、5、8、13、21、34、55、89……（也可以从0开始），前后两个数字的比值随着数列的增加，越来越接近黄金比值0.618。
 * 事例说明：
 *      比如这里的89，把它想象成整个有序表的元素个数，而89是由前面的两个斐波那契数34和55相加之后的和，
 *      也就是说把元素个数为89的有序表分成由前55个数据元素组成的前半段和由后34个数据元素组成的后半段，
 *      那么前半段元素个数和整个有序表长度的比值就接近黄金比值0.618，假如要查找的元素在前半段，
 *      那么继续按照斐波那契数列来看，55 = 34 + 21，所以继续把前半段分成前34个数据元素的前半段和后21个元素的后半段，
 *      继续查找，如此反复，直到查找成功或失败，这样就把斐波那契数列应用到查找算法中了。
 *
 */

public class FibonacciSearchDemo {


    public static void main(String[] args) {
        int maxLength = 100;
        int[] arr = new int[maxLength];
        for (int i = 0; i < maxLength; i++){
            arr[i] = i + 1;
        }
        int index = fibSearch(arr,  101);
        System.out.println("找到的下标值：" + index);
    }

    /**
     *
     *  非递归方式进行斐波那契查找算法
     *
     * @param arr 要查找的数组
     * @param value 要查找的值
     * @return
     */
    public static int fibSearch(int[] arr, int value){
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;//存放mid的值
        //找到当前数组arr，能够凑齐满足斐波那契的最小数值
        int[] fibArray = fib();
        int k = 0; //设置查找到的斐波那契数列下标
        //查找一个等于略大于查找表中元素个数的数fibArray[k]
        while (fibArray[k] < right){
            k++;
        }
        //拷贝arr到tmp，如果fibArray[k] > maxArrLength, 后面元素会自动填充上0
        int[] tmp = Arrays.copyOf(arr, fibArray[k]);
        //如果fibArray[k] > maxArrLength, 需要将后面元素填充上arr数组最后一个元素
        if (fibArray[k] >= arr.length){
            for (int i = right + 1; i < tmp.length; i++){
                tmp[i] = arr[right];
            }
        }
        //经过上述步骤，即可找到了进行斐波那契计算的数组tmp
        while (left <= right){

            mid = left + fibArray[k - 1] - 1;
            if (tmp[mid] > value){
                //向前半部分查找（向左查找）
                right = mid - 1;
                /**
                 * 为什么k--？
                 * 说明：
                 * 1、全部元素 = 前面的元素 + 后面的元素
                 * 2、f[k] = f[k-1] + f[k-2]，
                 *   因为前面有f[k-1]个元素，所以可以继续拆分 f[k-1] = f[k-2] + f[k-3]
                 *   即 在f[k-1]的前面继续查找k--，即下次循环mid=left + f[k-1-1] -1
                 */

                k--;
            } else if (tmp[mid] < value){
                //向后半部分查找（向右查找）
                left = mid + 1;
                /**
                 * 为什么k-=2？
                 * 说明：
                 * 1、全部元素 = 前面的元素 + 后面的元素
                 * 2、f[k] = f[k-1] + f[k-2]，
                 *   因为后面有f[k-2]个元素，所以可以继续拆分 f[k-2] = f[k-3] + f[k-4]
                 *   即 在f[k-2]的后面继续查找k--，即下次循环mid=left + f[k-1-2] -1
                 */
                k -= 2;
            } else {
                //找到了
                if (mid <= right){
                    return mid;
                } else {
                    return right;
                }
            }
        }

        return -1;
    }

    /**
     * 获取一个斐波那契数列
     * @return
     */
    public static int[] fib(){
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 20; i++){
            arr[i] = arr[i - 1] + arr[i-2];
        }
        return arr;
    }

}

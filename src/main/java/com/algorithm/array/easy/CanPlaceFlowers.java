package com.algorithm.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: CanPlaceFlowers
 * Description: 种花问题
 *
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * 示例 2:
 *
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 *
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 *
 * @author ningjianjian
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
//        int[] flowerbed = {1,0,0,0,0,1,0,0,0,1,0,0};
        int[] flowerbed = {1,0,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowersV2(flowerbed,n));
    }


    public static boolean canPlaceFlowersV2(int[] flowerbed, int n) {
        //分析思路： 只要满足0的左右两侧都是0；边界上，一侧为0即可
        int i = 0, count = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == (flowerbed.length-1) || flowerbed[i+1] == 0)){
                flowerbed[i] = 1;
                count++;
            }
            i++;
        }
        return count >= n;
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        //分析特征：
        //1、0 0 0 种1支， 0 0 0 0 0 种2支， 0 0 0 0 0 0 0 种3支， 。。。 ， 2*i+1 个0， 种i支
        //2、0 0 0 0种1支， 0 0 0 0 0 0 种2支，。。。， 2*(i + 1) 个0，种i支
        //3、根据1进行分段，统计各个分段0的数量， 只有0 >= 3，才能种花
        //4、要考虑特殊场景，边界是多个0的场景
        //5、要考虑特殊场景，数据只有一个0的场景 [0]
        //6、要考虑特殊场景，数据全是0的场景 [0,0,0,...,0,0]

        if(n < 0 || flowerbed.length < n) {
            return false;
        }

        int sum = 0;
        int i = 0;
        int count = 0;
        int headZeros = 0;
        boolean isHava1 = false;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0){
                if (headZeros == i){
                    headZeros++;
                } else {
                    count++;
                }
            } else {
                isHava1 = true;
                if (count >= 3){
                    sum = sum + (count - 1) / 2 ;
                }
                count = 0;
            }
            i++;
        }

        if (headZeros > 0){
            if (!isHava1){
              //元素全是0
              sum = sum + (headZeros + 1) / 2 ;
            } else {
                //说明数组开头元素是0，个数为 headZeros
                if (headZeros >= 3){
                    sum = sum + headZeros / 2 ;
                } else if (headZeros == 2) {
                    sum++;
                }
            }
        }
        if (count > 1){
            //说明数组最后一个元素不是1，且最后剩余的都是0
            if (count >= 3){
                sum = sum + count / 2 ;
            } else if (count == 2) {
                sum++;
            }
        }

        if (sum >= n){
            return true;
        }
        return false;
    }
}

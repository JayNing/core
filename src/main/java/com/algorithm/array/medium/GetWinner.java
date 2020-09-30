package com.algorithm.array.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: GetWinner
 * Description: 找出数组游戏的赢家
 *
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 *
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 *
 * 返回赢得比赛的整数。
 *
 * 题目数据 保证 游戏存在赢家。
 *
 * 示例 1：
 *
 * 输入：arr = [2,1,3,5,4,6,7], k = 2
 * 输出：5
 * 解释：参照链接
 *
 * 示例 2：
 *
 * 输入：arr = [3,2,1], k = 10
 * 输出：3
 * 解释：3 将会在前 10 个回合中连续获胜。
 * 示例 3：
 *
 * 输入：arr = [1,9,8,2,3,7,6,4,5], k = 7
 * 输出：9
 * 示例 4：
 *
 * 输入：arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
 * 输出：99
 *  
 *
 * 提示：
 *
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * arr 所含的整数 各不相同 。
 * 1 <= k <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-winner-of-an-array-game
 *
 *
 * @author ningjianjian
 */
public class GetWinner {

    public static void main(String[] args) {
        int[] arr = {1,11,22,33,44,55,66,77,88,99};
        int k = 1000000000;
        System.out.println(getWinnerV2(arr,k));
    }

    public static int getWinnerV2(int[] arr, int k) {
        int win=arr[0],count=0;/*win:胜利者,count:获胜场次*/
        for(int i=1;i<arr.length&&count<k;i++){/*到达获胜场次跳出循环*/
            if(arr[i]<win){/*arr[i]比win小*的情况*/
                count++;
            }else{/*如果win输掉了产生新的胜利者，count置为1*/
                win=arr[i];
                count=1;
            }
        }
        return win;/*返回win*/
    }

    public static int getWinner(int[] arr, int k) {

        int headIndex = 0;
        int index = 1;

        int headCount = 0;
        while (index < arr.length) {
            if (headCount >= k){
                return arr[headIndex];
            }
            if (arr[headIndex] < arr[index]){
                headCount = 0;
                headIndex = index;
            }
            headCount++;
            index++;
        }

        //当一次遍历循环结束时，仍没有满足headCount >= k，则说明需要再次循环。而第一次循环已经找到了max，所以，后面无论怎么循环，max肯定不会变了。所以只要一次循环即可
        return arr[headIndex];
    }
}

package com.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ningjianjian
 * @Date 2021/6/7 3:09 下午
 * @Description 无重复字符的最长子串
 *
 *  给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 */
public class NoRepeatString {

    @Deprecated
    public static void main(String[] args) {
//        String str = "abc def gh";
        String str = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str));
    }


    /**
     *
     * 思路：
     *      1、以每个字符作为一次起点，进行往后遍历，找到每个字符对应的最大不重复子串
     *      2、判断暂时记录到的最大子串长度是否大于等于剩余未担任起点的字符的数量，如果是，则不用再遍历了。
     *         因为就算剩余的全部不重复，数量也不用更新
     * 注意：此方式效率非常差
     *
     * @param s
     * @return
     */
    @Deprecated
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = 0; i < chars.length; i++){
            if (length >= (chars.length - i)){
                break;
            }
            Set<Character> charSet = new HashSet<>();
            charSet.add(chars[i]);
            for (int j = i + 1; j < chars.length; j++){
                char aChar = chars[j];
                //说明已经存在了，重复
                if (charSet.contains(aChar)){
                    //比较并记录最大长度
                    int size = charSet.size();
                    if (size > length){
                        length = size;
                    }
                    break;
                }
                charSet.add(aChar);
            }
            if (charSet.size() > length){
                length = charSet.size();
            }
        }

        return length;
    }
}

class NoRepeatStringV2 {

    public static void main(String[] args) {
//        String str = "abcdef gh";
        String str = "dvdf";
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * 前提知识：标准ASCII码字符集总共的编码有128个，包括32个通用控制符，10个十进制数码，52个英文大小写字母和34个专用符号
     * @param s
     * @return
     *
     * 思路：
     *  1、定义一个128长度的数组arr，用于存储字符
     *  2、字符的int数字即对应数组arr的下标，字符在字符串s中的下标，对应的是数组arr的值
     *  3、初始化一个start作为窗口起点，每次遍历，通过i - start + 1，来获取子串不重复长度
     *  4、如果遇到重复字符，重新修改start窗口起点；需要从重复字符的上一个下标的后一个位置开始统计
     *      例如：dvdf， d重复后，从第一个d的后一个位置下标开始重新统计。即v的下标从1开始统计
     *  5、每次检查更新length = (i - start + 1)，找到最大值，即为最大子串长度
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < last.length; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        // 窗口开始位置
        int start = 0;
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            //当last[index]不存在时，值为-1
            int charPreIndex = last[index];
            if (charPreIndex + 1 > start){
                //说明值重复了，窗口后移一位，重新从上一次下标的下一位开始统计。
                //例如：dvdf， d重复后，重新从v开始统计
                start = charPreIndex + 1;
            }
            //每次遍历的间隔
            int len = i - start + 1;
            if (len > res){
                res = len;
            }

            //省略版写法
//            start = Math.max(start, last[index] + 1);
//            res = Math.max(res, i - start + 1);

            // 记录本次下标
            last[index] = i;
        }

        return res;
    }

}
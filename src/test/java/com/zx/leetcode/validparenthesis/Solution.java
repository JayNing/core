package com.zx.leetcode.validparenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author JAY
 * @Date 2019/7/7 16:12
 * @Description 有效的括号
 **/
public class Solution {

    public static void main(String[] args) {
        String str = "()[ ] { }";
        System.out.println(isValid(str));
    }


    public static boolean isValid(String str) {

        if (str == null || str.length() == 0){
            return true;
        }

        Stack<String> stack = new Stack<>();

        for (int i = 0; i< str.length(); i++){
            String element = str.substring(i, i + 1).trim();
            if (!"".equals(element)){
                if (stack.empty()){
                    stack.push(element);
                } else {
                    //取出栈顶元素进行匹配
                    //查看栈中首个元素，并不移除
                    String peek = stack.peek();
                    //判断新元素是否与栈顶元素匹配对应
                    if (validMatch(element,peek)){
                        //如果匹配，移除栈顶元素
                        stack.pop();
                    }else {
                        //如果不匹配，继续将新元素压入栈顶
                        stack.push(element);
                    }
                }
            }
        }
        //最后校验栈中是否还有元素，有，说明没有完全匹配，则返回false
        if (!stack.empty()){
            return false;
        }

        return true;
    }

    private static boolean validMatch(String element, String peek) {

        if (("(".equals(peek) && ")".equals(element))
                || ("{".equals(peek) && "}".equals(element))
                || ("[".equals(peek) && "]".equals(element))){
            return true;
        }

        return false;

    }

}

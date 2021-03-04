package com.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ClassName: CheckKuoHao
 * Description:
 * date: 2021/3/4 11:27
 *
 * @author ningjianjian
 */
public class CheckKuoHao {

    public static void main(String[] args) {
//        String str = "{({[{]})}";
        String str = "1234567890";

        System.out.println(isRe(str));

    }

    private static String isRe(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack();
        for (char aChar : chars) {
            stack.push(aChar);
        }
        StringBuilder sl = new StringBuilder();
        while (!stack.isEmpty()){
            Character pop = stack.pop();
            sl = sl.append(pop);
        }
        return sl.toString();
    }

    private static boolean isValid(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack();

        for (char aChar : chars) {
            if (map.containsKey(aChar)){
                char pop = stack.isEmpty() ? '#' : stack.pop();
                if (pop != map.get(aChar)){
                    return false;
                }
            } else {
                stack.push(aChar);
            }
        }

        return stack.isEmpty();

    }


}

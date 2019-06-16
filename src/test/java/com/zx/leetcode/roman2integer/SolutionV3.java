package com.zx.leetcode.roman2integer;

/**
 * @Author JAY
 * @Date 2019/6/16 14:25
 * @Description 罗马数字转int
 **/
public class SolutionV3 {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        char[] romanArray = s.toCharArray();
        int result = 0;
        int index = 0;
        while (index < romanArray.length) {

            switch (romanArray[index++]) {
                case 'I':
                    if (index < romanArray.length && romanArray[index] == 'V') {
                        result += 4;
                        index++;
                    } else if (index < romanArray.length && romanArray[index] == 'X') {
                        result += 9;
                        index++;
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if (index < romanArray.length && romanArray[index] == 'L') {
                        result += 40;
                        index++;
                    } else if (index < romanArray.length && romanArray[index] == 'C') {
                        result += 90;
                        index++;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if (index < romanArray.length && romanArray[index] == 'D') {
                        result += 400;
                        index++;
                    } else if (index < romanArray.length && romanArray[index] == 'M') {
                        result += 900;
                        index++;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                    throw new IllegalArgumentException("The input isn't roman.");
            }
        }
        return result;
    }
}

package com.atguigu.stack;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author ningjianjian
 * @Date 2021/5/19 下午4:41
 * @Description 逆波兰表达式（后缀表达式）--- 简单版
 */
public class ReversePolishDemo {

    public static void main(String[] args) {

        //1、将中缀表达式转成后缀表达式（逆波兰表达式）
//        String expression = "1+((2+3)*4)-5";
        String expression = "1+((20+30)*4)-5";

        String[] expressionArr = convertToPolish(expression);
        System.out.println("expressionArr => " + Arrays.asList(expressionArr));

        //2、求出逆波兰表达式的结果
        //1+((2+3)*4)-5
//        String expression = "1 2 3 + 4 * + 5 -";
        //（3+4）*5-6
//        String expression = "3 4 + 5 * 6 -";
        int res = cal(expressionArr);
        System.out.println("逆波兰表达式的结果：" + res);
    }

    /**
     *
     * @param expression
     * @return 将中缀表达式转成逆波兰表达式（后缀表达式）
     * 思路：
     *  1、初始化两个栈：运算符栈S1和存储中间结果的栈S2；
     *  2、从左至右扫描中缀表达式；
     *  3、遇到操作数时，将其压入S2；
     *  4、遇到运算符时，比较其与S1栈顶运算符的优先级：
     *      1）如果S1为空，或栈顶运算符为左括号"（"，则直接将此运算符入栈；
     *      2）否则，判断优先级：
     *          a、若优先级比栈顶运算符的高，也将运算符压入S1；【注意：如果栈顶元素符号是"(","("优先级最小】
     *          b、否则，将S1栈顶的运算符弹出并压入到S2中，然后再次转到（4-1）将当前遇到的运算符与S1中新的栈顶运算符相比较；
     *  5、遇到括号时：
     *     1）如果是左括号"（"，则直接压入S1；
     *     2）如果是右括号"）"，则依次弹出S1栈顶的运算符，并压入S2，直至遇到左括号为止，此时将这一对括号丢弃
     *  6、重复步骤2至5，直到表达式的最右边
     *  7、将S1中剩余的运算符依次弹出并压入S2
     *  8、依次弹出S2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     *
     *   expression格式：如 1+((2+3)*4)-5
     */
    private static String[] convertToPolish(String expression) {
        char[] charArray = expression.toCharArray();
        StringBuilder numSb = new StringBuilder();

        Stack<String> s1 = new Stack<>();
        //因为s2只是用于存入中间结果，没有输出。可以直接使用List<String>代替
//        Stack<String> s2 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        for (int i = 0; i < charArray.length; i++){
            String value = String.valueOf(charArray[i]);
            if (value.matches("\\d+")){
                //说明是数字
                numSb.append(value);
            } else {
                //说明是字符
                //将前面的数字压入S2
                if (numSb.length() > 0){
                    s2.add(numSb.toString());
                    numSb = new StringBuilder();
                }

                while (true){
                    if (s1.isEmpty() || value.equals("(")){
                        s1.push(value);
                        break;
                    } else if (value.equals(")")) {
                        String first = s1.pop();
                        if (!first.equals("(")){
                            s2.add(first);
                        } else {
                            break;
                        }
                    } else {
                        //判断优先级
                        if (isPriority(value, s1.peek())){
                            s1.push(value);
                            break;
                        } else {
                            String first = s1.pop();
                            s2.add(first);
                        }
                    }
                }
            }
        }

        if (numSb.length() > 0){
            s2.add(numSb.toString());
        }

        while (!s1.isEmpty()){
            s2.add(s1.pop());
        }
//        int size = s2.size();
//        String[] result = new String[size];
//        for (int i = 0; i < size; i++) {
//            result[i] = s2.pop();
//        }
//        return result;
        return s2.toArray(new String[s2.size()]);
    }

    private static int cal(String[] elements) {
        Stack<String> numStack = new Stack<>();

        for (String element : elements) {
            if (element.matches("\\d+")){
                numStack.push(element);
            } else {
                String num1 = numStack.pop();
                String num2 = numStack.pop();
                int res = executeNum(num1,num2,element);
                numStack.push(String.valueOf(res));
            }
        }

        return Integer.parseInt(numStack.pop());

    }
    /**
     * 后缀表达式思路：
     * 1、将表达式转成数组或集合
     * 2、从左向右读取元素，如果是数字，存入栈中
     * 3、如果读到计算字符，将栈顶的前两个数字取出进行计算，将结果再压入栈中
     * 4、最后栈中只剩一个数字，即为计算结果
     *
     * @param expression
     * @return
     */
    private static int cal(String expression) {
        if (StringUtils.isBlank(expression)){
            System.out.println("表达式不正确~~~");
            return -1;
        }

        String[] elements = expression.split(" ");
        return cal(elements);
    }

    private static int executeNum(String num1, String num2, String charValue) {
        switch (charValue){
            case "+":
                return Integer.parseInt(num1) + Integer.parseInt(num2);
            case "-":
                return Integer.parseInt(num2) - Integer.parseInt(num1);
            case "*":
                return Integer.parseInt(num1) * Integer.parseInt(num2);
            case "/":
                return Integer.parseInt(num2) / Integer.parseInt(num1);
        }
        return - 1;
    }

    private static boolean isPriority(String element, String firstChar) {
        if (firstChar.equals("(")){
            //"("不算是操作符，优先级最小
            return true;
        }
        return ((element.equals("*") || element.equals("/")) && (firstChar.equals("+") || firstChar.equals("-")));
    }

}



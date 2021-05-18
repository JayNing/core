package com.atguigu.stack;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ningjianjian
 * @Date 2021/5/18 下午4:34
 * @Description 使用数组模拟stack进行入栈和出栈
 */
public class ArrStackDemo {

    public static void main(String[] args) {

//        ArrStack arr = new ArrStack(10);
//        arr.push(3);
//        arr.push('*');
//        arr.push('/');
//        System.out.println("栈元素打印～～～～");
//        arr.show();
//        System.out.println("出栈测试～～～");
//        System.out.println(arr.pop() == '/');

        System.out.println("================");

        ArrStackDemo demo = new ArrStackDemo();

        System.out.println("多位数表达式结果：" + demo.calculateWithMultipleNum("300+20*6-25"));
        System.out.println("单位数表达式结果：" + demo.calculate("3+2*6-2"));
    }

    /**
     * 中缀表达式---多位数版本
     * @param expression
     * @return
     */
    public int calculateWithMultipleNum(String expression){

        if (StringUtils.isBlank(expression)){
            System.out.println("表达式不能为空~~~~");
            return -1;
        }

        ArrStack numStack = new ArrStack(10);
        ArrStack charStack = new ArrStack(10);

        StringBuilder curNumber = new StringBuilder();
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char curChar = chars[i];
            if (!numStack.isChar(curChar)){
                //说明是数字, 再检查下一个字符是否是数字
                curNumber.append(curChar);
                continue;
            } else {
                //说明是符号
                if (curNumber.length() > 0){
                    //先保存之前未入栈的数字
                    numStack.push(Integer.parseInt(curNumber.toString()));
                    curNumber = new StringBuilder();
                }
                //说明是符号
                if (charStack.isEmpty()){
                    charStack.push(curChar);
                } else {
                    //取出栈顶的字符
                    int headChar = charStack.pop();
                    //比较优先级，如果当前操作符比栈顶操作符优先级高，则返回true
                    boolean isPriority = comparePriority(curChar,headChar);
                    if (isPriority) {
                        //headChar不应该被取出来，还要再放进去
                        charStack.push(headChar);
                        //直接入栈
                        charStack.push(curChar);
                    } else {
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int result = cal(num1,num2,headChar);
                        numStack.push(result);
                        charStack.push(curChar);
                    }
                }
            }
        }

        if (curNumber.length() > 0){
            //先保存之前未入栈的数字
            numStack.push(Integer.parseInt(curNumber.toString()));
            curNumber = null;
        }

        //对数栈和符号栈中剩余的数据进行计算
        while (!charStack.isEmpty()){
            int firstChar = charStack.pop();
            //注意出栈数据的先后顺序，计算的结果不一样
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int calResult = cal(num1, num2, firstChar);
            numStack.push(calResult);
        }

        return numStack.pop();
    }


    /**
     *
     * @param expression 要计算的表达式
     * @return 中缀表达式的方式，实现表达式计算结果。 如 3+2*6-2=13
     *
     * 思路：（准备两个栈，分别存储数字和符号）
     * 1、通过一个index值(索引)，来遍历我们的表达式
     * 2、如果发现是数字，直接入数字栈
     * 3、如果发现是一个符号，则分如下情况：
     * 3.1、如果发现当前的符号栈为空，就直接入栈
     * 3.2、如果符号栈不为空含有操作符，就进行比较。
     *   1）如果当前的操作符的优先级小于或者等于栈中的操作符，就需要从数栈中pop出两个数，从符号栈中pop出一个符号，进行运算。
     *      将得到的结果，入数栈，然后将当前的操作符入符号栈。
     *   2）如果当前的操作符的优先级大于栈中的操作符，就直接入符号栈。
     * 4、当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行。
     * 5、最后在数栈中只有一个数字，就是表达式的结果
     */
    public int calculate(String expression){

        if (StringUtils.isBlank(expression)){
            System.out.println("表达式不能为空~~~~");
            return -1;
        }

        ArrStack numStack = new ArrStack(10);
        ArrStack charStack = new ArrStack(10);

        /**
         * 注意：此方法只适用单个数字字符的计算
         */
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char curChar = chars[i];
            if (curChar != '+' && curChar != '-' && curChar != '*' && curChar != '/' ){
                //说明是数字
                numStack.push(Integer.parseInt(String.valueOf(curChar)));
            } else {
                //说明是符号
                if (charStack.isEmpty()){
                    charStack.push(curChar);
                } else {
                    //取出栈顶的字符
                    int headChar = charStack.pop();
                    //比较优先级，如果当前操作符比栈顶操作符优先级高，则返回true
                    boolean isPriority = comparePriority(curChar,headChar);
                    if (isPriority) {
                        //headChar不应该被取出来，还要再放进去
                        charStack.push(headChar);
                        //直接入栈
                        charStack.push(curChar);
                    } else {
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int result = cal(num1,num2,headChar);
                        numStack.push(result);
                        charStack.push(curChar);
                    }
                }
            }
        }

        //对数栈和符号栈中剩余的数据进行计算
        while (!charStack.isEmpty()){
            int firstChar = charStack.pop();
            //注意出栈数据的先后顺序，计算的结果不一样
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int calResult = cal(num1, num2, firstChar);
            numStack.push(calResult);
        }

        return numStack.pop();
    }

    private int cal(int num1, int num2, int headChar) {
        switch (headChar){
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1; //todo 注意顺序
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1; //todo 注意顺序
        }
        return - 1;
    }

    private boolean comparePriority(char curChar, int headChar) {
        //只有curChar优先级高于headChar，才会返回true。
        //但是考虑到只有 +、-、*、/ 四种运算符，所以只有headChar是+或-，curChar是 *或/时，才返回true
        if ((curChar == '*' || curChar == '/') && (headChar == '+' || headChar == '-')){
            return true;
        }
        return false;
    }
}

class ArrStack{

    /**
     * 栈最大存储元素个数
     */
    private int maxSize;
    /**
     * 栈元素个数
     */
    private int size;

    private int[] arr;

    public boolean isChar(char curChar){
        return !(curChar != '+' && curChar != '-' && curChar != '*' && curChar != '/');
    }

    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (maxSize - 1 < size){
            return true;
        }
        return false;
    }

    public int pop(){
        if (size == 0){
            System.out.println("栈为空～～～");
            return -1;
        }
        int data = arr[maxSize - size];
        arr[maxSize - size] = 0;
        size--;
        System.out.println("出栈元素：" + data);
        return data;
    }

    public void show(){
        if (arr == null || arr.length == 0){
            System.out.println("栈为空～～～");
            return;
        }
        for (int i = (maxSize - size); i < maxSize; i++){
            System.out.println("栈元素:" + arr[i]);
        }
    }

    public void push(int data){

        if (maxSize - 1 < size){
            System.out.println("数组以存满，不能再进行存储～～～");
            return;
        }

        if (size == 0){
            //第一个元素插入栈底
            arr[maxSize - 1] = data;
        } else {
            arr[maxSize - 1 - size] = data;
        }
        size++;
    }

    public ArrStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

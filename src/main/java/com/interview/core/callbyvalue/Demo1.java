package com.interview.core.callbyvalue;

import org.junit.Test;

/**
 * ClassName: Demo1
 * Description: 值传递测试
 *
 *  按值调用(call by value)表示方法接收的是调用者提供的值，而按引用调用（call by reference)表示方法接收的是调用者提供的变量地址。
 *  一个方法可以修改传递引用所对应的变量值，而不能修改传递值调用所对应的变量值
 *
 * date: 2021/2/19 15:38
 *
 * @author ningjianjian
 */
public class Demo1 {

    /**
     * Java 程序设计语言总是采用按值调用。也就是说，方法得到的是所有参数值的一个拷贝，也就是说，方法不能修改传递给它的任何参数变量的内容。
     */
    @Test
    public void test1(){
        int num1 = 10;
        int num2 = 20;
        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        /**
         * 在 swap 方法中，a、b 的值进行交换，并不会影响到 num1、num2。因为，a、b 中的值，只是从 num1、num2 的复制过来的。
         * 也就是说，a、b 相当于 num1、num2 的副本，副本的内容无论怎么修改，都不会影响到原件本身。
         */
    }

    private void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    /**
     * 一个方法不能修改一个基本数据类型的参数，而对象引用作为参数就不一样，看 test2.
     */
    @Test
    public void test2(){
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
        /**
         * 方法得到的是对象引用的拷贝，对象引用及其他的拷贝同时引用同一个对象。
         */
    }

    public static void change(int[] array) {
        // 将数组的第一个元素变为0
        array[0] = 0;
    }

    @Test
    public void test3(){
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
        /**
         * 方法并没有改变存储在变量 s1 和 s2 中的对象引用。swap 方法的参数 x 和 y 被初始化为两个对象引用的拷贝，这个方法交换的是这两个拷贝
         */
    }

    public static void swap(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }


    @Test
    public void test4(){
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        swapName(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());
        /**
         * 方法并没有改变存储在变量 s1 和 s2 中的对象引用。swap 方法的参数 x 和 y 被初始化为两个对象引用的拷贝，这个方法交换的是这两个拷贝
         */
    }

    private void swapName(Student x, Student y) {
        String temp = x.getName();
        x.setName(y.getName());
        y.setName(temp);
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }

    /***
     * 总结
     *
     * Java 程序设计语言对对象采用的不是引用调用，实际上，对象引用是按 值传递的。
     * 下面再总结一下 Java 中方法参数的使用情况：
     *  一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）。
     *  一个方法可以改变一个对象参数的状态。
     *  一个方法不能让对象参数引用一个新的对象。
     */
}

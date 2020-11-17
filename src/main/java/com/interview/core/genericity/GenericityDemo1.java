package com.interview.core.genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenericityDemo1
 * Description: 通过两个例子证明Java类型的类型擦除
 * date: 2020/10/16 9:56
 *
 * @author ningjianjian
 */
public class GenericityDemo1 {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List<Integer> integers = new ArrayList<>();
        List<String> strings = new ArrayList<> ();

        integers.add(123);
        strings.add("123");

        //获取.class类型
        System.out.println(integers.getClass() == strings.getClass());

    }

}

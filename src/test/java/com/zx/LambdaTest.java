package com.zx;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * lambdaTest类
 *
 * @author ning
 * @create 2018-06-11 17:19
 **/
public class LambdaTest {

    public static void main(String[] args){

        new Thread(() -> {System.out.println("lambda创建一个新线程");}).start();

        List<String> listStr = Arrays.asList("Java","C","C++","C#","Python","PHP");
        StringBuilder sb = new StringBuilder();
        listStr.forEach(n -> System.out.println(sb.append(",").append(n)));

        /**
         * 用特殊符号拼接
         * */
        String collect = listStr.stream().collect(Collectors.joining(","));
        System.out.println(collect);
        String collect1 = listStr.stream().collect(Collectors.joining("#"));
        System.out.println(collect1);

        listStr.sort((a,b) -> a.compareTo(b));
        System.out.println(listStr);

        String abc = "hello";
        Consumer<String> consumer = (a) -> {};

        Function<String,String> function = x -> x.toUpperCase();
        String zsdf = function.apply("zsdf");
        System.out.println(zsdf);
    }
}
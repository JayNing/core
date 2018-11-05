package com.zx;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        /**
         * 静态方法引用
         * 语法格式- - 类目::staticMethod
         */
        //只有一个输出
        Supplier<String> supplier = LambdaTest::put;
        System.out.println(supplier.get());
        //只有一个输入
        Consumer<String> c1 = LambdaTest::consume;
        c1.accept("张三");
        //一个输入，一个输出
        Function<String, String> f1 = LambdaTest::convertUp;
        System.out.println(f1.apply("a"));
        //两个输入，一个输出
        BiFunction<String,String,Integer> biFunction = LambdaTest::getLength;
        System.out.println(biFunction.apply("abc","123"));
        //////////////////////  方法的引用 - start  ////////////////////////
        /**
         * 实例方法引用
         * 语法格式- - 实例::实例Method
         */
        Supplier<String> s1 = new LambdaTest()::put1;
        System.out.println(s1.get());
        LambdaTest lt = new LambdaTest();
        Consumer<String> c2 = lt::consume1;
        c2.accept("王五");

        /**
         * 对象方法引用
         * 定义：抽象方法的第一个参数类型【最好是自定义的类型】刚好是实例方法的类型【言外之意，必需有参数】，抽象方法剩余的参数恰好可以当作实例方法的参数。
         * 如果函数式接口的实现能用上面说的实例方法调用来实现的话，那么就可以使用对象方法引用
         * 语法格式- - 类名::实例Method
         */
        Consumer<Too> c3 = (Too too) -> new Too().too();
        c3.accept(new Too());
        Consumer<Too> c4 = Too::too;
        c4.accept(new Too());
        BiConsumer<Too,String> c5 = (too, ac) -> new Too().too1(ac);
        c5.accept(new Too(),"宁大人");
        //两个输入，一个输出
        BiFunction<Too, String, Integer> biFunction1 = (p,s) -> new Too().too2(s);
        BiFunction<Too, String, Integer> biFunction2 = Too::too2;
        System.out.println(biFunction1.apply(new Too(),"123"));
        System.out.println(biFunction2.apply(new Too(),"123"));
        /**
         * 构造方法的引用
         * 定义：如果函数式接口的实现恰好可以通过调用一个类的构造方法来实现，那么就可以使用构造方法引用
         * 语法格式- - 类名::new
         */
        Supplier<Person> s2 = () -> new Person();
        s2.get();
        Supplier<Person> s3 = Person::new;
        s3.get();
        //含有无参构造函数都可以使用Supplier，如下：
        Supplier<List> s4 = ArrayList::new;
        Supplier<Thread> s5 = Thread::new;
        Supplier<Set> s6 = HashSet::new;
        Supplier<String> s7 = String::new;

        //含有有参构造函数的
        Consumer<Integer> c6 = Account::new;
        c6.accept(123);

        Function<String, Integer> f2 = Integer::new;
        System.out.println(f2.apply("456"));

        //////////////////////  方法的引用 - end  ////////////////////////

        //////////////////////  Stream API - start  ////////////////////////

        /***
         * stream的创建
         * */
        //1、数组
        String[] arr = {"1","b","c"};
        Integer[] arr1 = {1,2,3,4};
        Stream<String> stream1 = Stream.of(arr);
        Stream<Integer> stream2 = Stream.of(arr1);
        //2、集合
        List<String> list1 = Arrays.asList("1","2","3");
        Stream<String> stream = list1.stream();

        /**
         * 中间操作
         * */
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).forEach(System.out::println);
        int max = Arrays.asList(1, 2, 3, 4, 5, 6).stream().max((a1,b1) -> a1-b1).get();
        System.out.println(max);
        Integer min = Arrays.asList(1, 2, 3, 4, 5, 6).stream().min((a1, b1) -> a1 - b1).get();
        System.out.println(min);
        //求集合元素数量
        long count = Arrays.asList(1, 2, 3, 4, 5).stream().count();
        System.out.println(count);
        //截取
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().limit(3).forEach(System.out::println);
        System.out.println("===================================");
        //求平均值
        double asDouble = Arrays.asList(1, 2, 3, 4, 5, 6).stream().mapToInt(x -> x).average().getAsDouble();
        System.out.println(asDouble);
        //查找任意匹配的元素
        Optional<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).findAny();
        System.out.println(first.get());
        System.out.println("*********************************");
        List<Integer> collect3 = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(collect3);
        System.out.println("##############################");
        //查找第一个匹配的元素
        Optional<Integer> first1 = Arrays.asList(1, 2, 3, 4, 5, 6).stream().filter(x -> x % 2 == 0).sorted((a,b) -> b -a).findFirst();
        System.out.println(first1.get());
        //从1-50里面的所有偶数找出来，放到一个list中
        List<Integer> list2 = Stream.iterate(1, x -> x + 1).limit(50).filter(n -> n % 2 == 0).collect(Collectors.toList());
        list2.forEach(System.out::println);
        //集合元素去重
        Arrays.asList(1,2,3,4,5,4,3,5,6,7,3,8).stream().distinct().forEach(System.out::println);
        //将流转成set集合
        Set<Integer> collect2 = Arrays.asList(1, 2, 3, 4, 5, 4, 3, 5, 6, 7, 3, 8).stream().collect(Collectors.toSet());
        System.out.println(collect2);
        //从1-50里面的所有偶数找出来，忽略前10个，放到一个list中
        List<Integer> list3 = Stream.iterate(1, x -> x + 1).limit(50).filter(n -> n % 2 == 0).skip(10).collect(Collectors.toList());
        System.out.println(list3);
        //类似分页效果, skip(10).limit(10) ：跳过前10条，相当于查询第二页，每页10条
        List<Integer> list4 = Stream.iterate(1, x -> x + 1).limit(50).sorted((a,b) -> b -a).skip(10).limit(10).collect(Collectors.toList());
        System.out.println(list4);
        //////////////////////  Stream API - end  ////////////////////////
    }

    String put1(){
        return "world";
    }

    static String put(){
        return "hello";
    }

    void consume1(String string){
        System.out.println(string + ", 哈哈哈");
    }
    static void consume(String string){
        System.out.println(string + ", 哈哈哈");
    }
    static String convertUp(String a){
        return a.toUpperCase();
    }

    static Integer getLength(String a, String b){
        return a.length() + b.length();
    }
}

class Account{
    public Account(int age){
        System.out.println(age);
    }
}

class Person{
    public Person(){
        System.out.println("person 构造方法调用了");
    }
}

class Too{
    public void too(){
        System.out.println("invoke.............");
    }

    public void too1(String str){
        System.out.println(str + ",invoke.............");
    }

    public Integer too2(String p) {
        return 1;
    }
}

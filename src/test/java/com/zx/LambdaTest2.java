package com.zx;

import com.zx.entity.Book;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamApi实战测试类
 *
 * @author ning
 * @create 2018-06-12 9:25
 **/
public class LambdaTest2 {

    @Test
    public void test1(){
        //将get参数解析成map
        String str = "username=zhangsan&age=123&token=et34t423t4&key=f34t435y34&sigature=fsd043f4";
        Map<String, String> collect3 = Stream.of(str.split("&")).map(x -> x.split("=")).collect(Collectors.toMap(a -> a[0], a -> a[1]));
        System.out.println(collect3);
    }

    @Test
    public void test2(){
        //将books的id转换成List<Integer>
        List<Integer> collect = books().stream().map(Book::getId).collect(Collectors.toList());
        System.out.println(collect);
    }
    @Test
    public void test3(){
        //将books的id取出用字符串拼接
        //使用joining，参数必需先转成字符串
        String collect = books().stream().map(x -> x.getId() + "").collect(Collectors.joining(","));
        System.out.println(collect);
        //使用joining，参数必需先转成字符串，还可以加括号
        String collect1 = books().stream().map(x -> x.getId() + "").collect(Collectors.joining(",","(",")"));
        System.out.println(collect1);
        //使用joining，参数必需先转成字符串，还可以加括号,还可以加引号分割
        String collect2 = books().stream().map(x -> "'" + x.getId() + "'").collect(Collectors.joining(",","(",")"));
        System.out.println(collect2);
    }
    @Test
    public void test4(){
        //找出所有类型
        List<String> collect = books().stream().map(Book::getType).collect(Collectors.toList());
        System.out.println(collect);
        //去重
        List<String> collect1 = books().stream().map(Book::getType).distinct().collect(Collectors.toList());
        System.out.println(collect1);
        Set<String> collect2 = books().stream().map(Book::getType).collect(Collectors.toSet());
        System.out.println(collect2);
    }

    /**
     *  //排序
     */
    @Test
    public void test5(){

        //1、根据价格
        //Double.compare(b2.getPrice(), b1.getPrice()) 倒序
        List<Book> collect = books().stream().sorted((b1, b2) -> Double.compare(b2.getPrice(), b1.getPrice())).collect(Collectors.toList());
        System.out.println(collect);
        // Double.compare(b1.getPrice(), b2.getPrice()) 正序
        Comparator<Book> comp = (b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice());
        books().stream().sorted(comp).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        //另一种倒叙，使用Comparator的reversed()方法
        books().stream().sorted(comp.reversed()).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        //多条件排序
        //先根据价格排序，然后根据出版时间最近的排序
        Comparator<Book> comp2 = (b1, b2) -> b1.getPublishDate().isAfter(b2.getPublishDate()) ? 1 : -1;
        books().stream().sorted(comp.thenComparing(comp2)).forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        books().stream().sorted(Comparator.comparing(Book::getPrice).thenComparing(Comparator.comparing(Book::getPublishDate).reversed())).forEach(System.out::println);
    }

    @Test
    public void test6(){
        //将list集合转换成map，key是id，value是book对象
        Map<Integer, Book> collect = books().stream().collect(Collectors.toMap(Book::getId, b -> b));
        System.out.println(collect);
    }

    /**
     * 统计
     */
    @Test
    public void test7(){
        //找出价格最贵的那本书
        Book book = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice))).get();
        System.out.println(book);
        //找出价格最低的那本书
        Book book1 = books().stream().collect(Collectors.minBy(Comparator.comparing(Book::getPrice))).get();
        System.out.println(book1);
        //找出出版日期最近的那本书
        Book book2 = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPublishDate))).get();
        System.out.println(book2);
        //找到最大的价格
        double max = books().stream().collect(Collectors.summarizingDouble(Book::getPrice)).getMax();
        System.out.println(max);
        //找到平均数
        double v = books().stream().collect(Collectors.averagingDouble(Book::getPrice)).doubleValue();
        System.out.println(v);
        //找出价格最贵的那本书，如果不止一本，找到出版日期最近的那本
        Book book3 = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice).thenComparing(Comparator.comparing(Book::getPublishDate)))).get();
        System.out.println(book3);
        //找出价格最贵的那本书，如果不止一本，找到出版日期最远的那本
        Book book4 = books().stream().collect(Collectors.maxBy(Comparator.comparing(Book::getPrice).thenComparing(Comparator.comparing(Book::getPublishDate).reversed()))).get();
        System.out.println(book4);
    }

    /**
     * 分组
     */
    @Test
    public void test8(){
        //按照类型分组
        Map<String, List<Book>> collect = books().stream().collect(Collectors.groupingBy(Book::getType));
        collect.keySet().forEach(key -> {
            System.out.println(key);
            System.out.println(collect.get(key));
            System.out.println("----------------------------------------------");
        });
        //统计每种类型有多少本书
        Map<String, Long> collect1 = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.counting()));
        System.out.println(collect1);
        System.out.println("----------------------------------------------");
        //单独统计编程语言有多少本
        Long collect2 = books().stream().filter(book -> "编程语言".equals(book.getType())).collect(Collectors.counting());
        System.out.println(collect2);
        //统计每种类型数据的总价格，先分类，再按类型求和
        Map<String, Double> collect3 = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.summingDouble(Book::getPrice)));
        System.out.println(collect3);
        //统计每种类型数据，先分类，再求每种类型的平均价格
        Map<String, Double> collect4 = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.averagingDouble(Book::getPrice)));
        System.out.println(collect4);
        //统计每种类型数据，先分类，再求每种类型最贵的那本书
        Map<String, Optional<Book>> collect5 = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.maxBy(Comparator.comparing(Book::getPrice))));
        System.out.println(collect5);
        System.out.println("----------------------------------------------");
        collect5.keySet().forEach(key -> {
            System.out.println(key);
            System.out.println(collect5.get(key));
            System.out.println("----------------------------------------------");
        });
        //统计每种类型数据，先分类，再求每种类型最便宜的那本书
        Map<String, Optional<Book>> collect6 = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.minBy(Comparator.comparing(Book::getPrice))));
        System.out.println(collect6);
        System.out.println("----------------------------------------------");
        collect6.keySet().forEach(key -> {
            System.out.println(key);
            System.out.println(collect6.get(key));
            System.out.println("----------------------------------------------");
        });
        //统计每种类型数据，先分类，再求每种类型最晚出版的那本书
        Map<String, Optional<Book>> collect7 = books().stream().collect(Collectors.groupingBy(Book::getType, Collectors.maxBy(Comparator.comparing(Book::getPublishDate))));
        System.out.println(collect7);
        System.out.println("----------------------------------------------");
        collect7.keySet().forEach(key -> {
            System.out.println(key);
            System.out.println(collect7.get(key));
            System.out.println("----------------------------------------------");
        });
    }

    /**
     * 过滤
     */
    @Test
    public void test9(){
        //过滤加排序
        List<Book> collect = books().stream().filter(book -> book.getPrice() > 60).sorted(Comparator.comparing(Book::getPublishDate).reversed()).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }


    List<Book> books(){
        List<Book> books = new ArrayList<>();
        books.add(new Book(1,"tomcat",50d,"服务器",LocalDate.parse("2016-10-01")));
        books.add(new Book(2,"jetty",54d,"服务器",LocalDate.parse("2015-10-01")));
        books.add(new Book(3,"nginx",54d,"服务器",LocalDate.parse("2014-12-01")));
        books.add(new Book(4,"java",65d,"编程语言",LocalDate.parse("2011-04-01")));
        books.add(new Book(5,"ruby",22d,"编程语言",LocalDate.parse("2016-01-01")));
        books.add(new Book(6,"php",98d,"编程语言",LocalDate.parse("2016-10-25")));
        books.add(new Book(7,"html",90d,"编程语言",LocalDate.parse("2002-10-11")));
        books.add(new Book(8,"oracle",67d,"数据库",LocalDate.parse("2016-10-11")));
        books.add(new Book(9,"mysql",34d,"数据库",LocalDate.parse("2012-10-01")));
        books.add(new Book(10,"ssh",45d,"编程语言",LocalDate.parse("2013-10-01")));
        books.add(new Book(11,"设计模式",56d,"其他",LocalDate.parse("2014-10-01")));
        books.add(new Book(12,"代码重构",87d,"其他",LocalDate.parse("2015-10-01")));
        books.add(new Book(13,"并发编程",34d,"其他",LocalDate.parse("2006-10-01")));
        books.add(new Book(14,"spring源码分析",79d,"其他",LocalDate.parse("2016-05-01")));
        books.add(new Book(15,"大型web项目实战",57d,"其他",LocalDate.parse("2016-10-07")));
        books.add(new Book(16,"php2",98d,"编程语言",LocalDate.parse("2018-10-25")));
        return books;
    }



}
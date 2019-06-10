package com.zx.guava;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * @Author JAY
 * @Date 2019/6/10 16:19
 * @Description GuavaTest
 **/
public class GuavaTester {

    public static void main(String[] args) {
        GuavaTester guavaTester = new GuavaTester();
//        testOptional(guavaTester);
//        testListsAndMaps(guavaTester);
        testString(guavaTester);

    }

    private static void testString(GuavaTester guavaTester) {
        //拼接
        ImmutableList<String> list = ImmutableList.of("aa","bb","cc");
        String join = Joiner.on("-").skipNulls().join(list);
        System.out.println(join);
        //分割
        Iterable<String> split = Splitter.on("-").trimResults().split(join);
        System.out.println(split);
    }

    private static void testListsAndMaps(GuavaTester guavaTester) {
        ImmutableList<String> list = ImmutableList.of("aa","bb","cc");
        System.out.println(list);
        ImmutableMap<String, Integer> map = ImmutableMap.of("a",1,"b",2,"c",3);
        System.out.println(map);
    }

    private static void testOptional(GuavaTester guavaTester) {
        Integer value1 =  null;
        Integer value2 =  new Integer(10);
        //Optional.fromNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.fromNullable(value1);
        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        System.out.println(guavaTester.sum(a,b));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        //Optional.isPresent - checks the value is present or not
        System.out.println("First parameter is present: " + a.isPresent());

        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.or - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.or(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();

        return value1 + value2;
    }

}

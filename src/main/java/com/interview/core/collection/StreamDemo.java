package com.interview.core.collection;

import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc:
 * createBy: Ningjianjian
 */
public class StreamDemo {

    @Test
    public void test1() {
        Stream<String> stream = Stream.of("aaa","bbb","cccc","ddd","bbb");

        List<String> list = stream.collect(Collectors.toList());
        System.out.println(list);

        /**
         * 备注：切记Stream流只能被消费一次,流就失效了。
         * 上方 stream.collect(Collectors.toList()) 执行后，流就失效了。
         *  所以执行下面 stream.collect(Collectors.toSet()) ，
         *  会报 java.lang.IllegalStateException: stream has already been operated upon or closed
         */
        Set<String> collect = stream.collect(Collectors.toSet());
        System.out.println(collect);
    }
}

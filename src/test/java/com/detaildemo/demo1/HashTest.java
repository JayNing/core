package com.detaildemo.demo1;

import org.junit.Test;

import java.time.LocalDateTime;

public class HashTest {

    public static void main(String[] args) {
        String abc = "abc";
        String def = "def";

        System.out.println("abc hashcode : " + abc.hashCode() % 2);
        System.out.println("def hashcode : " + def.hashCode()  % 2);

        System.out.println(LocalDateTime.now());
    }
    @Test
    public void test(){
        String abc = "abc";
        String def = "def";

        System.out.println("test abc hashcode : " + abc.hashCode() % 2);
        System.out.println("test def hashcode : " + def.hashCode()  % 2);

        System.out.println(LocalDateTime.now());
    }

}

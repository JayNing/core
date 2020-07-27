package com.jay.demo.serializable.hessian;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * author JayNing
 * created by 2020/7/27 14:27
 **/
@Getter
@Setter
public class Student implements Serializable {
    private String name;
    private int age;
    public static String hobby = "eat";
    transient private String address;

    public static String getHobby() {
        return hobby;
    }
}

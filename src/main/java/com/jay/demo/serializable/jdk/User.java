package com.jay.demo.serializable.jdk;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

/**
 * author JayNing
 * created by 2020/7/27 14:43
 **/
@Getter
@Setter
public class User implements Serializable {
    private String username;
    private String password;
    private int age;
    private transient  String address;
}

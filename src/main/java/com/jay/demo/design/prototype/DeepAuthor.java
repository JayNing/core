package com.jay.demo.design.prototype;

import java.io.Serializable;

/**
 * @Author JAY
 * @Date 2018/11/11 10:01
 * @Description 作者--深复制
 **/
public class DeepAuthor implements Serializable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DeepBook{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

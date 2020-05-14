package com.dynamic.code.bean;
import java.util.Date;

public class User {

    private String username;
    public void setUsername(String username){
    this.username = username;
    }

    public String getUsername(){
    return this.username;
    }

    private Long age;
    public void setAge(Long age){
    this.age = age;
    }

    public Long getAge(){
    return this.age;
    }

    private Date birthday;
    public void setBirthday(Date birthday){
    this.birthday = birthday;
    }

    public Date getBirthday(){
    return this.birthday;
    }

}
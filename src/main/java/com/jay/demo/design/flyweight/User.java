package com.jay.demo.design.flyweight;

/**
 * @Author JAY
 * @Date 2018/11/25 15:13
 * @Description 网站用户账号
 **/
public class User {

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

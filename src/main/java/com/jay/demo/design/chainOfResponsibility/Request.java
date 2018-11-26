package com.jay.demo.design.chainOfResponsibility;

/**
 * @Author JAY
 * @Date 2018/11/24 15:50
 * @Description 申请请求类
 *      申请一般包括 申请人， 申请内容， 申请数量
 **/
public class Request {

    private String name;
    private String content;
    private int count;

    public Request() {
    }

    public Request(String name, String content, int count) {
        this.name = name;
        this.content = content;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

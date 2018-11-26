package com.jay.demo.design.interpreter;

/**
 * @Author JAY
 * @Date 2018/11/25 16:00
 * @Description 指令内容类
 **/
public class Content {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Content{" +
                "content='" + content + '\'' +
                '}';
    }
}

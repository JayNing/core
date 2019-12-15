package com.elasticsearch.csdn;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    public static DataFactory dataFactory = new DataFactory();

    private DataFactory() {
    }

    public DataFactory getInstance() {
        return dataFactory;
    }

    public static List<Blog> getInitJsonData() {
        List<Blog> list = new ArrayList<>();
        list.add(new Blog(1, "git简介", "2016-06-19", "SVN与Git最主要的区别..."));
        list.add(new Blog(2, "Java中泛型的介绍与简单使用", "2016-06-19", "学习目标 掌握泛型的产生意义..."));
        list.add(new Blog(3, "SQL基本操作", "2016-06-19", "基本操作：CRUD ..."));
        list.add(new Blog(4, "Hibernate框架基础", "2016-06-19", "Hibernate框架基础..."));
        list.add(new Blog(5, "Git基本知识git", "2016-06-19", "Shell是什么..."));
        list.add(new Blog(6, "C++基本知识", "2016-06-19", "Shell是什么..."));
        list.add(new Blog(7, "Mysql基本知识", "2016-06-19", "git是什么..."));
        return list;
    }
}

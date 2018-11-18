package com.jay.demo.design.iterator;

/**
 * @Author JAY
 * @Date 2018/11/18 16:14
 * @Description 容器角色(Aggregate):  一般是一个接口，提供一个iterator()方法，
 * 例如java中的Collection接口，List接口，Set接口等
 **/
public interface Aggrerate {
    void add(Object obj);
    Object get(int index);
    Iterator iterator();
    int getSize();
}

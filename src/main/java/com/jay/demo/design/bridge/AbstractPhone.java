package com.jay.demo.design.bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JAY
 * @Date 2018/11/20 21:38
 * @Description 抽象手机类
 **/
public abstract class AbstractPhone {

    //可以是聚合集合，也可以是聚合对象
    private List<AbstractSoft> softList = new ArrayList<>();

    public void addSoft(AbstractSoft abstractSoft){
        this.softList.add(abstractSoft);
    }

    public List<AbstractSoft> getSoftList() {
        return softList;
    }

    public void setSoftList(List<AbstractSoft> softList) {
        this.softList = softList;
    }

    public abstract void run();

}

package com.jay.demo.design.composite;

/**
 * @Author JAY
 * @Date 2018/11/17 22:54
 * @Description 人事部
 **/
public class HRDepartment extends Company {

    public HRDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        System.out.println("人事部没有新增部门功能");
    }

    @Override
    public void remove(Company company) {
        System.out.println("人事部没有删除部门功能");
    }

    @Override
    public void display(int depty) {
        System.out.println("深度：" + depty + "，名称：" + name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(name + "人事部履行职责");
    }
}

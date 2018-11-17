package com.jay.demo.design.composite;

/**
 * @Author JAY
 * @Date 2018/11/17 22:59
 * @Description 财务部
 **/
public class FinanceDepartment extends Company {
    public FinanceDepartment(String name) {
        super(name);
    }

    @Override
    public void add(Company company) {
        System.out.println("财务部没有新增部门功能");
    }

    @Override
    public void remove(Company company) {
        System.out.println("财务部没有删除部门功能");
    }

    @Override
    public void display(int depty) {
        System.out.println("深度：" + depty + "，名称：" + name);
    }

    @Override
    public void lineOfDuty() {
        System.out.println(name + "财务部履行职责");
    }
}

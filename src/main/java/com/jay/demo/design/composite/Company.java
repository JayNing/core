package com.jay.demo.design.composite;

/**
 * @Author JAY
 * @Date 2018/11/17 22:48
 * @Description 公司抽象类
 **/
public abstract class Company {

    protected String name;

   public Company(String name){
       this.name = name;
   }
   //增加（部门/分公司用同一个方法）
   public abstract void add(Company company);
   //删除
   public abstract void remove(Company company);
   //显示
   public abstract void display(int depty);
   //履行职责
   public abstract void lineOfDuty();



}

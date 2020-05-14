package com.dynamic.code.bean;
import com.dynamic.code.bean.table.TableA;
import com.dynamic.code.bean.table.TableB;

import java.util.Date;
import java.util.List;


public class Person {

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

    private List<TableB> TableB;
    public void setTableB(List<TableB> TableB){
    this.TableB = TableB;
    }

    public List<TableB> getTableB(){
    return this.TableB;
    }

    private List<TableA> TableA;
    public void setTableA(List<TableA> TableA){
    this.TableA = TableA;
    }

    public List<TableA> getTableA(){
    return this.TableA;
    }

}
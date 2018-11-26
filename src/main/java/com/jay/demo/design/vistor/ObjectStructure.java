package com.jay.demo.design.vistor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JAY
 * @Date 2018/11/25 16:40
 * @Description 对象结构
 **/
public class ObjectStructure {

    private List<Person> people = new ArrayList<>();

    //add
    public void add(Person person){
        people.add(person);
    }
    //remove
    public void remove(Person person){
        people.remove(person);
    }
    //查看不同
    public void display(Action action){
        for (Person person : people) {
            person.accept(action);
        }
    }

}

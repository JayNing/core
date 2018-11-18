package com.jay.demo.design.iterator;

/**
 * @Author JAY
 * @Date 2018/11/18 16:24
 * @Description 迭代器demo
 **/
public class IteratorDemo {

    public static void main(String[] args) {

        ConcreteAggrerate aggrerate = new ConcreteAggrerate();
        aggrerate.add("张三");
        aggrerate.add("李四");
        aggrerate.add("王五");

        Iterator iterator = aggrerate.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}

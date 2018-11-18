package com.jay.demo.design.iterator;

import java.util.List;

/**
 * @Author JAY
 * @Date 2018/11/18 16:09
 * @Description 具体迭代器角色（Concrete Iterator）：实现迭代器接口中定义的方法，完成集合的迭代
 **/
public class ConcreteIterator implements Iterator{

    private Aggrerate list = null;
    private int index;

    ConcreteIterator(Aggrerate list){
        super();
        this.list = list;
    }

    @Override
    public Object next() {
        Object obj = list.get(index);
        index ++;
        return obj;
    }

    @Override
    public boolean hasNext() {
        if (index >= list.getSize()){
            return false;
        }
        return true;
    }

}

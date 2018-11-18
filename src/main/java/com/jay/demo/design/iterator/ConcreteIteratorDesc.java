package com.jay.demo.design.iterator;

/**
 * @Author JAY
 * @Date 2018/11/18 16:09
 * @Description 具体迭代器角色---倒序
 **/
public class ConcreteIteratorDesc implements Iterator{

    private Aggrerate list = null;
    private int index;

    ConcreteIteratorDesc(Aggrerate list){
        super();
        this.index = list.getSize() - 1;
        this.list = list;
    }

    @Override
    public Object next() {
        Object obj = list.get(index);
        index --;
        return obj;
    }

    @Override
    public boolean hasNext() {
        if (index < 0 ){
            return false;
        }
        return true;
    }

}

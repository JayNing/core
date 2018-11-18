package com.jay.demo.design.iterator;

/**
 * @Author JAY
 * @Date 2018/11/18 16:15
 * @Description 具体容器角色（ConcreteAggregate）：就是抽象容器的具体实现类，
 * 比如List接口的有序列表实现ArrayList，List接口的链表实现LinkList
 **/
public class ConcreteAggrerate implements Aggrerate {

    private Object[] list;
    private int size = 0;
    private int index = 0;

    public ConcreteAggrerate(){
        list = new Object[100];
        index = 0;
        size = 0;
    }

    @Override
    public void add(Object obj) {
        list[index++] = obj;
        size++;
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public Iterator iterator() {

        //倒序
        return new ConcreteIteratorDesc(this);
        //正序
//        return new ConcreteIterator(this);
    }

    @Override
    public int getSize() {
        return size;
    }
}

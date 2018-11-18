package com.jay.demo.design.iterator;

/**
 * @Author JAY
 * @Date 2018/11/18 16:07
 * @Description 迭代器角色（Iterator）:定义遍历元素所需要的方法，一般来说会有这么三个方法：取得下一个元素的方法next()，
 * 判断是否遍历结束的方法hasNext()），移出当前对象的方法remove()
 **/
public interface Iterator {

    public Object next();
    public boolean hasNext();

}

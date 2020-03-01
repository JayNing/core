package com.jay.demo.design.prototype;

import org.springframework.beans.BeanUtils;

/**
 * author JayNing
 * created by 2020/3/1 14:14
 *  测试BeanUtils.copyProperties使用的克隆方式
 **/
public class BeanUtilsDemo {
    public static void main(String[] args) {
        DeepBook deepBook = new DeepBook();
        deepBook.setName("大话设计模式");
        DeepAuthor deepAuthor = new DeepAuthor();
        deepAuthor.setName("程杰");
        deepAuthor.setAge(35);
        deepBook.setDeepAuthor(deepAuthor);
        System.out.println(deepBook);

        /**
         * BeanUtils 使用的是浅克隆
         */

        //复制一个原对象赋值给新对象，看看后面浅克隆后，改变克隆的对象的引用属性，对这个赋值的新对象有没有影响
        DeepBook newDeepBook = deepBook;
        DeepBook cloneDeepBook = new DeepBook();

        BeanUtils.copyProperties(deepBook,cloneDeepBook);
        System.out.println("克隆后的结果：" + cloneDeepBook);
        System.out.println(deepBook == cloneDeepBook);
        System.out.println(deepBook.getDeepAuthor() == cloneDeepBook.getDeepAuthor());
        System.out.println(deepBook.getName() == cloneDeepBook.getName());

        System.out.println("修改克隆后的对象，对原对象的影响-----------：" );
        DeepAuthor author = cloneDeepBook.getDeepAuthor();
        author.setName("吴承恩");
        author.setAge(320);
        cloneDeepBook.setDeepAuthor(author);
        System.out.println(deepBook.getDeepAuthor() == cloneDeepBook.getDeepAuthor());
        System.out.println(cloneDeepBook.getDeepAuthor());
        System.out.println(deepBook.getDeepAuthor());
        //查看赋值的新对象的引用属性有没有被改变
        System.out.println(newDeepBook.getDeepAuthor());

    }
}

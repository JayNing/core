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

        DeepBook cloneDeepBook = new DeepBook();
        /**
         * BeanUtils 使用的是浅克隆
         */

        BeanUtils.copyProperties(deepBook,cloneDeepBook);
        System.out.println("克隆后的结果：" + cloneDeepBook);
        System.out.println(deepBook == cloneDeepBook);
        System.out.println(deepBook.getDeepAuthor() == cloneDeepBook.getDeepAuthor());
        System.out.println(deepBook.getName() == cloneDeepBook.getName());

    }
}

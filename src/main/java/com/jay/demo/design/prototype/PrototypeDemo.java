package com.jay.demo.design.prototype;

import java.io.IOException;

/**
 * @Author JAY
 * @Date 2018/11/11 10:03
 * @Description 原型模式的demo
 **/
public class PrototypeDemo {

    public static void main(String[] args) {
        Book book = new Book();
        book.setName("大话设计模式");
        Author author = new Author();
        author.setName("程杰");
        author.setAge(35);
        book.setAuthor(author);
        System.out.println(book);

        Book cloneBook = book.clone();
        System.out.println("克隆后的结果：" + cloneBook);
        System.out.println(book == cloneBook);
        System.out.println(book.getAuthor() == cloneBook.getAuthor());
        System.out.println(book.getName() == cloneBook.getName());
       /** 由输出的结果可以验证说到的结论。由此我们发现：虽然复制出来的对象重新在堆上开辟了内存空间，
        * 但是，对象中各属性确保持相等。对于基本数据类型很好理解，但对于引用数据类型来说，
        * 则意味着此引用类型的属性所指向的对象本身是相同的， 并没有重新开辟内存空间存储。
        * 换句话说，引用类型的属性所指向的对象并没有复制。
        由此，我们将其称之为浅复制。*/

        System.out.println("------------------------------------------------------------");

        /**
         * 当复制后的对象的引用类型的属性所指向的对象也重新得以复制，此时，称之为深复制。
         *
         * 二、深复制：
         *
         *  Java中的深复制一般是通过对象的序列化和反序列化得以实现。序列化时，需要实现Serializable接口。
         *
         * 下面还是以Book为例，看下深复制的一般实现过程：
         *
         * 1.定义DeepBook类和DeepAuthor类（注意：不仅DeepBook类需要实现Serializable接口，DeepAuthor同样也需要实现Serializable接口!!）：
         */

        DeepBook deepBook = new DeepBook();
        deepBook.setName("大话设计模式");
        DeepAuthor deepAuthor = new DeepAuthor();
        deepAuthor.setName("程杰");
        deepAuthor.setAge(35);
        deepBook.setDeepAuthor(deepAuthor);
        System.out.println(deepBook);

        try {
            DeepBook cloneDeepBook = deepBook.deepClone();
            System.out.println("克隆后的结果：" + cloneDeepBook);
            System.out.println(deepBook == cloneDeepBook);
            System.out.println(deepBook.getDeepAuthor() == cloneDeepBook.getDeepAuthor());
            System.out.println(deepBook.getName() == cloneDeepBook.getName());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 从输出结果中可以看出，深复制不仅在堆内存上开辟了空间以存储复制出的对象，
         * 甚至连对象中的引用类型的属性所指向的对象也得以复制，重新开辟了堆空间存储。
         */

    }

}

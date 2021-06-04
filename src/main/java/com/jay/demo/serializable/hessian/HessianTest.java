package com.jay.demo.serializable.hessian;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * author JayNing
 * created by 2020/7/27 14:28
 * 从  test1() 结果可以得出以下结论：
 *   静态属性不能被序列化；
 *   transient关键字修饰的属性不能被序列化；
 *
 * 从  test2() 结果可以得出结论：
 *  使用hessian序列化时，一定要注意子类和父类不能有同名字段
 *
 * 跟Serializable序列化的比较：
 *   hessian序列化的效率更高，且序列化的数据更小，在基于RPC的调用方式中性能更好。
 *
 **/
public class HessianTest {
    public static void main(String[] args) throws IOException {
//       test1();
       test2();
    }

    private static void test2() throws IOException {
        Student2 stu = new Student2();
        stu.setAddress("屋子科");
        stu.setName("ymz");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(os);
        output.writeObject(stu);
        output.close();

        ByteArrayInputStream bis = new ByteArrayInputStream(os.toByteArray());
        Hessian2Input input = new Hessian2Input(bis);
        Student2 student = (Student2) input.readObject();
        System.out.println(student.getName());
        /**
         * 理论上输出的结果应该为“ymz”,但现在为null,原因如下:
         *
         * 1、hessian序列化的时候会取出对象的所有自定义属性，相同类型的属性是子类在前，父类在后的顺序；
         * 2、hessian在反序列化的时候，是将对象所有属性取出来，存放在一个map中 key = 属性名 value是反序列类，
         *          相同名字的会以子类为准进行反序列化；
         * 3、相同名字的属性 在反序列化的是时候，由于子类在父类前面，子类的属性总是会被父类的覆盖，由于java多态属性，
         *      在上述例子中父类 student.name = null。
         *
         */
    }

    private static void test1() throws IOException {
        Student stu = new Student();
        stu.setAddress("屋子科");
        stu.setAge(10);
        stu.setName("ymz");

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(os);
        output.writeObject(stu);
        output.close();

        /**
         * 读出来的静态属性的值是改变后的值，说明静态变量不参与序列化
         */
        Student.hobby = "drink";

        ByteArrayInputStream bis = new ByteArrayInputStream(os.toByteArray());
        Hessian2Input input = new Hessian2Input(bis);
        Student student = (Student) input.readObject();
        System.out.println(student.getAge());
        /**
         * transient修饰的属性的值为null,说明被transient关键字修饰的属性依然不参与序列化。
         */
        System.out.println(student.getAddress());
        System.out.println(student.getName());
        System.out.println(Student.getHobby());
    }
}

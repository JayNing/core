package com.jay.demo.serializable.jdk;

import com.caucho.hessian.io.Hessian2StreamingInput;
import com.caucho.hessian.io.Hessian2StreamingOutput;
import com.util.GsonUtils;
import org.springframework.util.StopWatch;

import java.io.*;
import java.net.URL;

/**
 * author JayNing
 * created by 2020/7/27 14:45
 *
 *  比较hessian序列化和java序列化，根据结果得出：
 *  1、同一个对象(本例中的测试对象)，hessian序列化后的大小，比java序列化之后的大小，小1/3
 *  2、对同一个对象(本例中的测试对象)进行反序列化，java序列化耗时平均是hessian耗时的6倍
 *
 *  总结：hession序列化比java序列化更省空间，更高效
 *
 **/
public class JavaSerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setAge(12);
        user.setAddress("苏州");

        serializable(user);
        serializableHessian(user);

        StopWatch sw = new StopWatch();
        sw.start("derializer");
        User newUser = derializer();
        sw.stop();
        sw.start("derializerHessian");
        User newUser2 = derializerHessian();
        sw.stop();
        System.out.println(sw.prettyPrint());

//        System.out.println(GsonUtils.toJsonString(user));
//        System.out.println(GsonUtils.toJsonString(newUser));
//        System.out.println(user.toString());
//        System.out.println(newUser.toString());
    }

    private static User derializerHessian() throws IOException, ClassNotFoundException {
        String pathname = "C:\\Users\\LENOVO\\Desktop\\HessianUser.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(pathname)));
        Hessian2StreamingInput hes = new Hessian2StreamingInput(ois);
        User user = (User) hes.readObject();
        hes.close();
        ois.close();
        return user;
    }

    private static void serializableHessian(User user) throws IOException {
        String pathname = "C:\\Users\\LENOVO\\Desktop\\HessianUser.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(pathname)));
        Hessian2StreamingOutput hes = new Hessian2StreamingOutput(oos);
        hes.writeObject(user);
        hes.close();
        oos.close();
    }

    private static User derializer() throws IOException, ClassNotFoundException {
        String pathname = "C:\\Users\\LENOVO\\Desktop\\User.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(pathname)));
        User user = (User) ois.readObject();
        ois.close();
        return user;
    }

    private static void serializable(User user) throws IOException {
        String pathname = "C:\\Users\\LENOVO\\Desktop\\User.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(pathname)));
        oos.writeObject(user);
        oos.close();
    }
}

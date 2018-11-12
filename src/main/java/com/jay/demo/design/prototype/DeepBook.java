package com.jay.demo.design.prototype;

import java.io.*;

/**
 * @Author JAY
 * @Date 2018/11/11 10:01
 * @Description 书籍--深复制
 **/
public class DeepBook implements Serializable {

    private String name;

    private DeepAuthor deepAuthor;

    public DeepBook deepClone() throws IOException, ClassNotFoundException {
        // 写入当前对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 读出二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (DeepBook) ois.readObject();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepAuthor getDeepAuthor() {
        return deepAuthor;
    }

    public void setDeepAuthor(DeepAuthor deepAuthor) {
        this.deepAuthor = deepAuthor;
    }

    @Override
    public String toString() {
        return "DeepBook{" +
                "name='" + name + '\'' +
                ", deepAuthor=" + deepAuthor +
                '}';
    }
}

package com.jay.demo.serializable.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * author JayNing
 * created by 2020/7/27 16:16
 **/
public class ProtoUserTest {
    public static void main(String[] args) {
        try {
            /** Step1：生成 protoUser 对象 */
            // ProtoUser 构造器
            ProtoUserProtos.ProtoUser.Builder personBuilder = ProtoUserProtos.ProtoUser.newBuilder();
            // protoUser 赋值
            personBuilder.setName("Jet Chen");
            personBuilder.setEmail("ckk505214992@gmail.com");
            personBuilder.setSex(ProtoUserProtos.ProtoUser.Sex.MALE);

            // 内部的 PhoneNumber 构造器
            ProtoUserProtos.ProtoUser.PhoneNumber.Builder phoneNumberBuilder = ProtoUserProtos.ProtoUser.PhoneNumber.newBuilder();
            // PhoneNumber 赋值
            phoneNumberBuilder.setType(ProtoUserProtos.ProtoUser.PhoneNumber.PhoneType.MOBILE);
            phoneNumberBuilder.setNumber("17717037257");

            // protoUser 设置 PhoneNumber
            personBuilder.addPhone(phoneNumberBuilder);

            // 生成 protoUser 对象
            ProtoUserProtos.ProtoUser protoUser = personBuilder.build();

            /** Step2：序列化和反序列化 */
            // 方式一 byte[]：
            // 序列化
            byte[] bytes = protoUser.toByteArray();
            // 反序列化
            ProtoUserProtos.ProtoUser protoUserResult = ProtoUserProtos.ProtoUser.parseFrom(bytes);
            System.out.println(String.format("反序列化得到的信息，姓名：%s，性别：%d，手机号：%s", protoUserResult.getName(), protoUser.getSexValue(), protoUser.getPhone(0).getNumber()));



            // 方式二 ByteString：
            // 序列化
//            ByteString byteString = protoUser.toByteString();
//            System.out.println(byteString.toString());
//             反序列化
//            ProtoUserProtos.ProtoUser protoUserResult = ProtoUserProtos.ProtoUser.parseFrom(byteString);
//            System.out.println(String.format("反序列化得到的信息，姓名：%s，性别：%d，手机号：%s", protoUserResult.getName(), protoUser.getSexValue(), protoUser.getPhone(0).getNumber()));



            // 方式三 InputStream
            // 粘包,将一个或者多个protobuf 对象字节写入 stream
            // 序列化
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//            protoUser.writeDelimitedTo(byteArrayOutputStream);
//            // 反序列化，从 steam 中读取一个或者多个 protobuf 字节对象
//            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
//            ProtoUserProtos.ProtoUser protoUserResult = ProtoUserProtos.ProtoUser.parseDelimitedFrom(byteArrayInputStream);
//            System.out.println(String.format("反序列化得到的信息，姓名：%s，性别：%d，手机号：%s", protoUserResult.getName(), protoUser.getSexValue(), protoUser.getPhone(0).getNumber()));

        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

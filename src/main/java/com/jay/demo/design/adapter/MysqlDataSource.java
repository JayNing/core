package com.jay.demo.design.adapter;

/**
 * @Author JAY
 * @Date 2018/11/13 21:54
 * @Description mysql数据库的连接
 **/
public class MysqlDataSource extends AbstractDataSource {

    @Override
    public void createConnection() {
        System.out.println("建立 mysql 类型的数据库连接");
    }
}

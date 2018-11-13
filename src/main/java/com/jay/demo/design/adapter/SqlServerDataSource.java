package com.jay.demo.design.adapter;

/**
 * @Author JAY
 * @Date 2018/11/13 21:54
 * @Description sqlserver数据库的连接
 **/
public class SqlServerDataSource extends AbstractDataSource {

    @Override
    public void createConnection() {
        System.out.println("建立 sqlserver 类型的数据库连接");
    }
}

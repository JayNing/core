package com.jay.demo.design.adapter;

/**
 * @Author JAY
 * @Date 2018/11/13 21:54
 * @Description oracle数据库的连接
 **/
public class OracleDataSource extends AbstractDataSource {

    @Override
    public void createConnection() {
        System.out.println("建立 oracle 类型的数据库连接");
    }
}

package com.jay.demo.design.adapter;

/**
 * @Author JAY
 * @Date 2018/11/13 21:57
 * @Description 适配器demo
 **/
public class AdapterDemo {

    public static void main(String[] args) {
        //建立mysql连接
        AbstractDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.createConnection();
        //建立sqlserver连接
        AbstractDataSource sqlServerDataSource = new SqlServerDataSource();
        sqlServerDataSource.createConnection();
        //建立oracle连接
        AbstractDataSource oracleDataSource = new OracleDataSource();
        oracleDataSource.createConnection();
        System.out.println("---------------------------------------------");
        //建立新类型数据库的连接
        //因为新类型数据库的连接方法和抽象类的不一样，无法像其他几种一样建立连接
        //使用适配器
        AbstractDataSource dataSourceAdapter = new DataSourceAdapter();
        dataSourceAdapter.createConnection();

    }
}

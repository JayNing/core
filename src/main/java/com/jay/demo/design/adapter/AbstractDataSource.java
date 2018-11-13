package com.jay.demo.design.adapter;

/**
 * @Author JAY
 * @Date 2018/11/13 21:51
 * @Description 抽象数据库类
 **/
public abstract class AbstractDataSource {

    /**
     * 建立数据库连接
     */
    public abstract void createConnection();

}

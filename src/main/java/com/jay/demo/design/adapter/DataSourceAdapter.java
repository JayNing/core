package com.jay.demo.design.adapter;

/**
 * @Author JAY
 * @Date 2018/11/13 22:01
 * @Description 数据库连接适配器
 **/
public class DataSourceAdapter extends AbstractDataSource{

    //内部包装一个要适配的对象，把源接口转向目标接口
    private NewTypeDataSource newTypeDataSource = new NewTypeDataSource();

    @Override
    public void createConnection() {
        //内部包装一个要适配的对象，把源接口转向目标接口
        this.newTypeDataSource.generationConnection();
    }
}

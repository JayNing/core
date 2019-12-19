package com.jay.demo.design.proxy.dynamicproxy.demo02;

public class CollectionServiceImpl implements CollectionService {
    @Override
    public void collectionData(String modelCode) {
        System.out.println("收集到模型[" + modelCode + "]的数据");
    }
}

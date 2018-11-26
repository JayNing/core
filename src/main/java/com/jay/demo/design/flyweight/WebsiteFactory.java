package com.jay.demo.design.flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author JAY
 * @Date 2018/11/25 14:57
 * @Description 网站类工厂
 **/
public class WebsiteFactory {
    private Map<String, AbstractWebsite> websiteMap = new HashMap<>();

    //获取网站类型
    public AbstractWebsite getWebsite(String type){
        if (!websiteMap.keySet().contains(type)){
            websiteMap.put(type, new ConcreteWebsite(type));
        }
        return websiteMap.get(type);
    }

    //获取网站分类总数
    public int getWebsiteCount(){
        return websiteMap.size();
    }

}

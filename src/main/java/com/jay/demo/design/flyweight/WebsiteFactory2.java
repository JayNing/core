package com.jay.demo.design.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author JAY
 * @Date 2018/11/25 14:57
 * @Description 网站类工厂2
 **/
public class WebsiteFactory2 {
    private Map<String, AbstractWebsite2> websiteMap = new HashMap<>();

    //获取网站类型
    public AbstractWebsite2 getWebsite(String type){
        if (!websiteMap.keySet().contains(type)){
            websiteMap.put(type, new ConcreteWebsite2(type));
        }
        return websiteMap.get(type);
    }

    //获取网站分类总数
    public int getWebsiteCount(){
        return websiteMap.size();
    }

}

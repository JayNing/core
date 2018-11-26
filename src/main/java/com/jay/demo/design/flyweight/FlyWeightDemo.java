package com.jay.demo.design.flyweight;

/**
 * @Author JAY
 * @Date 2018/11/25 15:06
 * @Description 享元模式demo
 **/
public class FlyWeightDemo {
    public static void main(String[] args) {
        WebsiteFactory factory = new WebsiteFactory();
        AbstractWebsite boke = factory.getWebsite("boke");
        boke.use();

        AbstractWebsite productDisplay = factory.getWebsite("productDisplay");
        productDisplay.use();

        System.out.println(factory.getWebsiteCount());

        System.out.println("-----------------------------------------");
        /**每个网站都有一个自己的专属账号
         * 账号随着网站不同而改变，是属于外部状态
         */
        WebsiteFactory2 factory2 = new WebsiteFactory2();
        AbstractWebsite2 boke2 = factory2.getWebsite("boke");
        boke2.use(new User("张三","123456"));

        AbstractWebsite2 productDisplay2 = factory2.getWebsite("productDisplay");
        productDisplay2.use(new User("李四","88897978"));

    }
}

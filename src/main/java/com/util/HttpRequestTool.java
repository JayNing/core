package com.util;

import com.dynamic.code.bean.Person;
import com.dynamic.code.bean.User;
import com.dynamic.code.model.PageModel;
import com.dynamic.code.model.Response;
import com.zx.util.HttpUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author JayNing
 * created by 2020/5/14 19:06
 **/
public class HttpRequestTool {

    private String appId;

    private String appSecret;

    public HttpRequestTool(String appId,String appSecret){
        this.appId = appId;
        this.appSecret = appSecret;
    }

    public String requestMethod(String params){
        System.out.println(params);

        Map<String, Object> stringObjectMap = GsonUtils.toMap(params);
        //1、解析认证参数
        System.out.println("======================");
        System.out.println(stringObjectMap);
        System.out.println("appId = " + appId + ", appSecret = " + appSecret);

        User user = new User();
        user.setAge(10L);
        user.setUsername("张三");
        user.setBirthday(new Date());

        //2、解析bizParam
        try {
            String s = HttpUtil.doPost("https://www.baidu.com", "UTF-8");
            System.out.println("request http response");
            System.out.println(s);
        } catch (Exception e) {
            System.out.println("request http Exception " + e);
            e.printStackTrace();
        }
        //json 没有分页
        String json = "{\n" +
                "    \"code\": \"2000\",\n" +
                "    \"message\": null,\n" +
                "    \"data\": [\n" +
                "            {\n" +
                "                \"username\": \"其他通讯服务\",\n" +
                "                \"age\": 84634,\n" +
                "                \"birthday\": \"2020-05-15 00:00:00\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"username\": \"李四\",\n" +
                "                \"age\": 123,\n" +
                "                \"birthday\": \"2020-05-16 00:00:00\"\n" +
                "            }\n" +
                "        ],\n" +
                "    \"placeholder\": null,\n" +
                "    \"errorMsg\": null\n" +
                "}";

        //json 带分页
//
//        String json = "{\n" +
//                "    \"code\": \"2000\",\n" +
//                "    \"message\": null,\n" +
//                "    \"data\": {\n" +
//                "        \"content\": [\n" +
//                "            {\n" +
//                "                \"username\": \"其他通讯服务\",\n" +
//                "                \"age\": 84634,\n" +
//                "                \"birthday\": \"2020-05-15 00:00:00\"\n" +
//                "            },\n" +
//                "            {\n" +
//                "                \"username\": \"李四\",\n" +
//                "                \"age\": 123,\n" +
//                "                \"birthday\": \"2020-05-16 00:00:00\"\n" +
//                "            }\n" +
//                "        ],\n" +
//                "        \"pageNum\": 1,\n" +
//                "        \"pageSize\": 50,\n" +
//                "        \"totalElements\": 1,\n" +
//                "        \"pages\": 1\n" +
//                "    },\n" +
//                "    \"placeholder\": null,\n" +
//                "    \"errorMsg\": null\n" +
//                "}";

        return json;
    }

}

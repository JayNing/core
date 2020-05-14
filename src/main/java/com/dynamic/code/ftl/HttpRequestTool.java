package com.dynamic.code.ftl;

import com.util.GsonUtils;
import com.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * author JayNing
 * created by 2020/5/14 19:06
 **/
@Component
public class HttpRequestTool {
    @Autowired
    private HttpClientUtil httpClientUtil;

    public static String requestMethod(String params){
        Map<String, Object> stringObjectMap = GsonUtils.toMap(params);
        //1、解析认证参数

        //2、解析bizParam

        //3、封装真实请求参数

        return null;
    }

}

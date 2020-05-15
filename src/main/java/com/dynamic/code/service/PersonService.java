package com.dynamic.code.service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.dynamic.code.bean.Person;
import com.dynamic.code.bean.Person;


import org.springframework.beans.factory.annotation.Autowired;
import com.util.HttpRequestTool;
import com.util.GsonUtils;
import com.dynamic.code.model.PageModel;
import com.dynamic.code.model.Response;

public class PersonService {

    @Autowired
    private HttpRequestTool httpRequestTool;

    public Response requestPerson(Person params ){
        String json = httpRequestTool.requestMethod(GsonUtils.toJsonString(params));
        Response response = GsonUtils.toBean(json, Response.class);
        String code = response.getCode();
        if ("2000".equals(code)){
            Object data = response.getData();
            PageModel pageModel = GsonUtils.toBean(GsonUtils.toJsonString(data), PageModel.class);
            String content = GsonUtils.toJsonString(pageModel.getContent());
            List<Person> users = GsonUtils.toList(content, Person.class);
            System.out.println("responseBean List: " + GsonUtils.toJsonString(users));
        }
        return response;
    }
    public Response requestUser(Person params ){
        String json = httpRequestTool.requestMethod(GsonUtils.toJsonString(params));
        Response response = GsonUtils.toBean(json, Response.class);
        String code = response.getCode();
        if ("2000".equals(code)){
            Object data = response.getData();
            String content = GsonUtils.toJsonString(data);
            List<Person> users = GsonUtils.toList(content, Person.class);
            System.out.println("responseBean List: " + GsonUtils.toJsonString(users));
        }
        return response;
    }

}
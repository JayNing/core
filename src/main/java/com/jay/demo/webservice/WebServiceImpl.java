package com.jay.demo.webservice;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @Author JAY
 * @Date 2019/5/22 13:15
 * @Description SEI的具体实现
 **/
//使用@WebService注解标注WebServiceI接口的实现类WebServiceImpl
@WebService
public class WebServiceImpl implements WebServiceI {

    @Override
    public String sayHello(@WebParam(name = "username",targetNamespace = "http://webservice.demo.jay.com/")  String name) {
        System.out.println("WebService sayHello "+name);
        return "sayHello "+name;
    }

    @Override
    public String save(String name, String pwd) {
        System.out.println("WebService save "+name+"， "+pwd);
        return "save Success:"+name+"， "+pwd;
    }
}

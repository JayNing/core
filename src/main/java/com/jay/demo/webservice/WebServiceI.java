package com.jay.demo.webservice;

/**
 * @Author JAY
 * @Date 2019/5/22 13:15
 * @Description 定义SEI(WebService EndPoint Interface(终端)
 **/

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

//使用@WebService注解标注WebServiceI接口
@WebService
public interface WebServiceI {

    //使用@WebMethod注解标注WebServiceI接口中的方法
    @WebMethod
    String sayHello(@WebParam(name = "username",targetNamespace = "http://webservice.demo.jay.com/")  String name);

    @WebMethod
    String save(@WebParam(name = "username",targetNamespace = "http://webservice.demo.jay.com/")String name,
                @WebParam(name = "password",targetNamespace = "http://webservice.demo.jay.com/")String pwd);
}
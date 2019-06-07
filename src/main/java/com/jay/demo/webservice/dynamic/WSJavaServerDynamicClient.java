package com.jay.demo.webservice.dynamic;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import javax.xml.namespace.QName;

/**
 * @Author JAY
 * @Date 2019/5/22 13:44
 * @Description 动态调用java版本的webservice接口客户端
 **/
public class WSJavaServerDynamicClient {
    public static void main(String[] args) {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://172.19.10.37:8081/WS_Server/Webservice?wsdl");
        // url为调用webService的wsdl地址
        QName name = new QName("http://webservice.demo.jay.com/", "save");
        // namespace是命名空间，methodName是方法名
        String xmlStr = "aaaaaaaa";
        String username = "张三";
        String password = "123456";
        // paramvalue为参数值
        Object[] objects;
        try {
            objects = client.invoke(name, username, password);
            System.out.println(objects[0].toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

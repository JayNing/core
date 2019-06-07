package com.jay.demo.webservice.dynamic;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.ws.commons.schema.constants.Constants;

import javax.xml.namespace.QName;

/**
 * @Author JAY
 * @Date 2019/5/22 13:44
 * @Description 动态调用.net版本的webservice接口客户端
 **/
public class WSNetServerDynamicClient {
    public static void main(String[] args) {
        Textaxis();
    }


    //通过axis方式调用webservice接口
    public static void Textaxis() {
        try {
            // 指出service所在完整的URL
            String endpoint = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl";
            //调用接口的targetNamespace
            //targetNamespace 就是你用浏览器打开endpoint 路径加上?wsdl，即http://xxx/WebService1.asmx?wsdl 中的targetNamespace属性值
            String targetNamespace = "http://WebXml.com.cn/";
            //所调用接口的方法method
            String method = "getSupportCityString";
            // 创建一个服务(service)调用(call)
            Service service = new Service();
            Call call = (Call) service.createCall();// 通过service创建call对象
            // 设置service所在URL
            call.setTargetEndpointAddress(new java.net.URL(endpoint));
            call.setOperationName(new QName(targetNamespace, method));
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("http://WebXml.com.cn/getSupportCityString");
            
            //变量最好只是用String类型，其他类型会报错
            call.addParameter(new QName(targetNamespace, "getSupportCityString"),
                    Constants.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);//设置参数名 state  第二个参数表示String类型,第三个参数表示入参  
            call.setReturnType(Constants.XSD_STRING);// 设置返回类型

            String jsonString = (String) call.invoke("getSupportCityString",new Object[]{"苏州"});//此处为数组，有几个变量传几个变量
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

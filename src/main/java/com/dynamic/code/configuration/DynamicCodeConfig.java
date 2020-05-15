package com.dynamic.code.configuration;

import com.dynamic.code.service.PersonService;
import com.util.HttpRequestTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DynamicCodeConfig {

@Value("${mdmv2.appId}")
private String appId;

@Value("${mdmv2.appSecret}")
private String appSecret;

@Bean
public HttpRequestTool httpRequestTool(){
return new HttpRequestTool(appId,appSecret);
}


    @Bean
    public PersonService PersonService(){
     return new PersonService();
    }


}
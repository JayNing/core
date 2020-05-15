package com.dynamic.code.configuration;

import com.util.HttpRequestTool;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

${imports}

@Configuration
public class DynamicCodeConfig {

@Value("${appId}")
private String appId;

@Value("${appSecret}")
private String appSecret;

@Bean
public HttpRequestTool httpRequestTool(){
return new HttpRequestTool(appId,appSecret);
}


<#list params as param>
    @Bean
    public ${param.serviceName?cap_first} ${param.serviceName}(){
     return new ${param.serviceName?cap_first}();
    }

</#list>

}
package ${classPackage};
${imports}

import org.springframework.beans.factory.annotation.Autowired;
import com.util.HttpRequestTool;
import com.util.GsonUtils;
import com.dynamic.code.model.PageModel;
import com.dynamic.code.model.Response;

public class ${beanName?cap_first} {

    @Autowired
    private HttpRequestTool httpRequestTool;

<#list params as param>
    public Response request${param.methodName?cap_first}(${param.requestBean} params ){
        String json = httpRequestTool.requestMethod(GsonUtils.toJsonString(params));
        Response response = GsonUtils.toBean(json, Response.class);
        String code = response.getCode();
        if ("2000".equals(code)){
            Object data = response.getData();
        <#if param.isPage == "true">
            PageModel pageModel = GsonUtils.toBean(GsonUtils.toJsonString(data), PageModel.class);
            String content = GsonUtils.toJsonString(pageModel.getContent());
            List<${param.responseBean}> dataList = GsonUtils.toList(content, ${param.responseBean}.class);
            pageModel.setContent(dataList);
            response.setData(pageModel);
            System.out.println("responseBean List: " + GsonUtils.toJsonString(dataList));
        </#if>
        <#if param.isPage == "false">
            String content = GsonUtils.toJsonString(data);
            List<${param.responseBean}> dataList = GsonUtils.toList(content, ${param.responseBean}.class);
            response.setData(dataList);
            System.out.println("responseBean List: " + GsonUtils.toJsonString(dataList));
        </#if>
        }
        return response;
    }
</#list>

}
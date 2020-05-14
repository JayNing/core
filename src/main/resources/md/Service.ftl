package ${classPackage};
${imports}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.util.HttpClientUtil

@Component
public class ${beanName?cap_first} {

    @Autowired
    private HttpRequestTool httpRequestTool;

    public static ${responseBean} requestMethod(${requestBean} params ){

       String str = httpClientUtil.doRequest(GsonUtils.toJsonString(params));

       return GsonUtils.toBean(str,${responseBean}.class);
    }


}
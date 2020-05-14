package com.dynamic.code.ftl;

import com.zx.util.FileUtil;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.util.Map;

/**
 * @author Page.Yang
 * @date 2019/5/21 0021
 */
public class FreemarkerUtil {

    private static Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
    private static final String BACKAGE_PATH = "//src//main//java//";

    /**
     * freemarker模板替换字符串
     *
     * @param templateStr 模板字符串
     * @param formBeanMap 替换参数map
     * @return
     * @throws Exception
     */
    public static String freemarkerProcess(String templateStr, Map<String, Object> formBeanMap) throws Exception {
        configuration.setDefaultEncoding("UTF-8");
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        String templateStrTemp = "";
        stringLoader.putTemplate(templateStrTemp, templateStr);
        configuration.setTemplateLoader(stringLoader);
        Template template = configuration.getTemplate(templateStrTemp);
        String st = FreeMarkerTemplateUtils.processTemplateIntoString(template, formBeanMap);
        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath.replace("\\","//")
                + BACKAGE_PATH
                + formBeanMap.get("classPackage").toString().replaceAll("\\.","//");

        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String beanName = formBeanMap.get("beanName").toString();
//        beanName = beanName.substring(0,1).toUpperCase() + beanName.substring(1);
        FileUtil.writeToFile(filePath + "//" + beanName +  ".java",
                st.getBytes("UTF-8"));

        return st;
    }
}

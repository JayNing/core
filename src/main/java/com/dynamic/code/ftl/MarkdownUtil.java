package com.dynamic.code.ftl;

import com.dynamic.code.enums.ParamTypeEnum;
import com.dynamic.code.model.ApiField;
import com.dynamic.code.model.ApiFilterModel;
import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.toc.SimTocExtension;
import com.vladsch.flexmark.ext.toc.TocExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.ParserEmulationProfile;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.builder.Extension;
import com.vladsch.flexmark.util.options.MutableDataSet;
import com.zx.util.CollectionUtils;
import com.zx.util.StringUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.util.*;
import java.util.stream.Collectors;

public class MarkdownUtil {

    private static String MD_CSS = "";
    private static String MD_FTL = "";
    private static String REQUEST_FILTER_BEAN = "";
    private static String RESPONSE_FIELD_BEAN = "";
    private static String SERVICE_BEAN = "";
    private static String CONFIG_BEAN = "";
    private static String BEAN_PACKAGE = "com.dynamic.code.bean";
    private static String SERVICE_BEAN_PACKAGE = "com.dynamic.code.service";
    private static String CONFIG_BEAN_PACKAGE = "com.dynamic.code.configuration";
    private static String RESPONSE_BEAN_PACKAGE = "com.dynamic.code.bean.table";
    private final static String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws Exception {
//        testFilterBean("User");
//        testFieldBean("Person");
        testServiceBean("PersonService");
//        testConfigurationBean();
    }

    private static void testConfigurationBean() throws Exception {
        Map<String, Object>  formBeanMap = new HashMap<String, Object>();
        formBeanMap.put("beanName", "DynamicCodeConfig");
        formBeanMap.put("classPackage", CONFIG_BEAN_PACKAGE);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = stringBuilder.append("import java.util.Date;").append("\n");
        stringBuilder = stringBuilder.append("import java.util.List;").append("\n");
        stringBuilder = stringBuilder.append("import " + SERVICE_BEAN_PACKAGE + ".PersonService;").append("\n");
        formBeanMap.put("imports",stringBuilder.toString());

        List<Map<String, String>> paramsList = new ArrayList<Map<String, String>>();

        Map<String, String> tmpParamMap = new HashMap<String, String>();
        tmpParamMap.put("serviceName", "PersonService");
        paramsList.add(tmpParamMap);

        formBeanMap.put("params", paramsList);
        formBeanMap.put("appId", "${mdmv2.appId}");
        formBeanMap.put("appSecret", "${mdmv2.appSecret}");

        String s = FreemarkerUtil.freemarkerProcess(CONFIG_BEAN, formBeanMap);
        System.out.println(s);
    }

    private static void testServiceBean(String beanName) throws Exception {
        Map<String, Object>  formBeanMap = new HashMap<String, Object>();
        formBeanMap.put("beanName", beanName);
        formBeanMap.put("classPackage", SERVICE_BEAN_PACKAGE);
        String requestBean = "Person";
        String responseBean = "Person";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = stringBuilder.append("import java.util.Date;").append("\n");
        stringBuilder = stringBuilder.append("import java.util.List;").append("\n");
        stringBuilder = stringBuilder.append("import java.util.Map;").append("\n");
        stringBuilder = stringBuilder.append("import java.util.HashMap;").append("\n");
        stringBuilder = stringBuilder.append("import " + BEAN_PACKAGE + "." + requestBean + ";").append("\n");
        stringBuilder = stringBuilder.append("import " + BEAN_PACKAGE + "." + responseBean + ";").append("\n");


        formBeanMap.put("imports",stringBuilder.toString());

        List<Map<String, String>> paramsList = new ArrayList<Map<String, String>>();

        Map<String, String> tmpParamMap = new HashMap<String, String>();
        tmpParamMap.put("methodName", "Person");
        tmpParamMap.put("requestBean", requestBean);
        tmpParamMap.put("responseBean", requestBean);
        tmpParamMap.put("isPage", "true");
        paramsList.add(tmpParamMap);

        Map<String, String> tmpParamMap2 = new HashMap<String, String>();
        tmpParamMap2.put("methodName", "User");
        tmpParamMap2.put("requestBean", requestBean);
        tmpParamMap2.put("responseBean", requestBean);
        tmpParamMap2.put("isPage", "false");
        paramsList.add(tmpParamMap2);

        formBeanMap.put("params", paramsList);

        String s = FreemarkerUtil.freemarkerProcess(SERVICE_BEAN, formBeanMap);
        System.out.println(s);

    }


    private static void testFieldBean(String beanName) {
        try {
            //处理参数
            List<ApiField> apiFields = new ArrayList<>();

            ApiField field1 = new ApiField();
            field1.setFieldResponseName("username");
            field1.setFieldType("String");
            field1.setModelPropType("single");
            apiFields.add(field1);

            ApiField field2 = new ApiField();
            field2.setFieldResponseName("age");
            field2.setFieldType("Num");
            field2.setModelPropType("single");
            apiFields.add(field2);

            ApiField field3 = new ApiField();
            field3.setFieldResponseName("birthday");
            field3.setFieldType("Date");
            field3.setModelPropType("single");
            apiFields.add(field3);


            ApiField field4 = new ApiField();
            field4.setFieldResponseName("aaa");
            field4.setFieldType("String");
            field4.setModelPropType("table");
            field4.setFieldTableCode("tableA");

            ApiField field5 = new ApiField();
            field5.setFieldResponseName("bbb");
            field5.setFieldType("Num");
            field5.setModelPropType("table");
            field5.setFieldTableCode("tableA");

            ApiField field6 = new ApiField();
            field6.setFieldResponseName("ccc");
            field6.setFieldType("String");
            field6.setModelPropType("table");
            field6.setFieldTableCode("tableB");

            ApiField field7 = new ApiField();
            field7.setFieldResponseName("ddd");
            field7.setFieldType("Num");
            field7.setModelPropType("table");
            field7.setFieldTableCode("tableB");

            apiFields.add(field4);
            apiFields.add(field5);
            apiFields.add(field6);
            apiFields.add(field7);

            Map<String, Object>  formBeanMap = generateFieldBeanMap(apiFields,beanName);

            String s = createFilterBean(formBeanMap);
            System.out.println("======================================");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static Map<String, Object> generateFieldBeanMap(List<ApiField> apiFieldModels, String beanName) {
        Map<String, Object>  formBeanMap = new HashMap<String, Object>();
        formBeanMap.put("beanName", beanName);
        formBeanMap.put("classPackage", BEAN_PACKAGE);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = stringBuilder.append("import java.util.Date;").append("\n");
        stringBuilder = stringBuilder.append("import java.util.List;").append("\n");
        stringBuilder = stringBuilder.append("import java.util.Map;").append("\n");
        stringBuilder = stringBuilder.append("import java.util.HashMap;").append("\n");

        //2、判断是否含有多值列表
        List<ApiField> table = apiFieldModels.stream().filter(apiFieldModel ->
        {
            return apiFieldModel.getModelPropType().equals("table");
        }).collect(Collectors.toList());
        List<Map<String, String>> paramsList = new ArrayList<Map<String, String>>();
        if (CollectionUtils.isEmpty(table)){
            //3、没有，直接封装处理map
            for (ApiField apiFieldModel : apiFieldModels) {
                Map<String, String> tmpParamMap = new HashMap<String, String>();
                tmpParamMap.put("paramType", ParamTypeEnum.getValue(apiFieldModel.getFieldType()));
                tmpParamMap.put("paramName", apiFieldModel.getFieldResponseName());
                paramsList.add(tmpParamMap);
            }

        } else {
            boolean removeAll = apiFieldModels.removeAll(table);
            if (removeAll){
                for (ApiField apiFieldModel : apiFieldModels) {
                    Map<String, String> tmpParamMap = new HashMap<String, String>();
                    tmpParamMap.put("paramType", ParamTypeEnum.getValue(apiFieldModel.getFieldType()));
                    tmpParamMap.put("paramName", apiFieldModel.getFieldResponseName());
                    paramsList.add(tmpParamMap);
                }
            }
            //4、有，根据多值列表编码分组
            Map<String, List<ApiField>> collect = table.stream().collect(Collectors.groupingBy(ApiField::getFieldTableCode));
            //5、先封装生成多值列表属性组成的bean

            for (Map.Entry<String, List<ApiField>> entry : collect.entrySet()) {
                String tableCode = entry.getKey();
                String firstUpTableCode = StringUtil.getFirstUp(tableCode);
                List<ApiField> tableFields = entry.getValue();
                List<Map<String, String>> tableParamsList = new ArrayList<Map<String, String>>();
                for (ApiField apiFieldModel : tableFields) {
                    Map<String, String> tmpParamMap = new HashMap<String, String>();
                    tmpParamMap.put("paramType", ParamTypeEnum.getValue(apiFieldModel.getFieldType()));
                    tmpParamMap.put("paramName", apiFieldModel.getFieldResponseName());
                    tableParamsList.add(tmpParamMap);
                }
                try {
                    Map<String, Object>  tableBeanMap = new HashMap<String, Object>();
                    tableBeanMap.put("beanName", firstUpTableCode);
                    tableBeanMap.put("classPackage", RESPONSE_BEAN_PACKAGE);
                    tableBeanMap.put("params",tableParamsList);

                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2 = stringBuilder2.append("import java.util.Date;").append("\n");
                    stringBuilder2 = stringBuilder2.append("import java.util.List;").append("\n");
                    stringBuilder2 = stringBuilder2.append("import java.util.Map;").append("\n");
                    stringBuilder2 = stringBuilder2.append("import java.util.HashMap;").append("\n");
                    tableBeanMap.put("imports",stringBuilder2);

                    createFilterBean(tableBeanMap);

                    Map<String, String> tmpParamMap = new HashMap<String, String>();

                    tmpParamMap.put("paramName", firstUpTableCode);
                    tmpParamMap.put("paramType", "List<" + firstUpTableCode + ">");
                    paramsList.add(tmpParamMap);
                    //追加import依赖类
                    String imports = "import " + RESPONSE_BEAN_PACKAGE + "." + firstUpTableCode + ";";
                    stringBuilder = stringBuilder.append(imports).append("\n");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //6、再生成最终的返回参数生成的bean
        formBeanMap.put("imports",stringBuilder.toString());
        formBeanMap.put("params", paramsList);

        return formBeanMap;
    }

    private static Map<String, Object> generateFilterBeanMap(List<ApiFilterModel> apiFilterModels, String beanName) {
        Map<String, Object>  formBeanMap = new HashMap<String, Object>();
        formBeanMap.put("beanName", beanName);
        formBeanMap.put("classPackage", BEAN_PACKAGE);

        List<Map<String, String>> paramsList = new ArrayList<Map<String, String>>();
        for (ApiFilterModel apiFilterModel : apiFilterModels) {
            Map<String, String> tmpParamMap = new HashMap<String, String>();
            tmpParamMap.put("paramType", ParamTypeEnum.getValue(apiFilterModel.getFieldType()));
            tmpParamMap.put("paramName", apiFilterModel.getFieldRequestName());
            paramsList.add(tmpParamMap);
        }

        formBeanMap.put("params", paramsList);
        return formBeanMap;
    }

    static {
        // 加载markdown样式
        try {
            ClassPathResource classPathResource = new ClassPathResource("md/markdown.css");
            MD_CSS = IOUtils.toString(classPathResource.getInputStream(), "UTF-8");
        } catch (Exception e) {
            MD_CSS = "";
            e.printStackTrace();
        }
        // 加载markdown模版
        try {
            ClassPathResource classPathResource = new ClassPathResource("md/markdown.ftl");
            MD_FTL = IOUtils.toString(classPathResource.getInputStream(), "UTF-8");
        } catch (Exception e) {
            MD_FTL = "";
            e.printStackTrace();
        }
        // 加载markdown模版
        try {
            ClassPathResource classPathResource = new ClassPathResource("md/filterBean.ftl");
            REQUEST_FILTER_BEAN = IOUtils.toString(classPathResource.getInputStream(), "UTF-8");
        } catch (Exception e) {
            REQUEST_FILTER_BEAN = "";
            e.printStackTrace();
        }
        // 加载markdown模版
        try {
            ClassPathResource classPathResource = new ClassPathResource("md/fieldBean.ftl");
            RESPONSE_FIELD_BEAN = IOUtils.toString(classPathResource.getInputStream(), "UTF-8");
        } catch (Exception e) {
            RESPONSE_FIELD_BEAN = "";
            e.printStackTrace();
        }
        // 加载markdown模版
        try {
            ClassPathResource classPathResource = new ClassPathResource("md/Service.ftl");
            SERVICE_BEAN = IOUtils.toString(classPathResource.getInputStream(), "UTF-8");
        } catch (Exception e) {
            SERVICE_BEAN = "";
            e.printStackTrace();
        }
        try {
            ClassPathResource classPathResource = new ClassPathResource("md/Configuration.ftl");
            CONFIG_BEAN = IOUtils.toString(classPathResource.getInputStream(), "UTF-8");
        } catch (Exception e) {
            CONFIG_BEAN = "";
            e.printStackTrace();
        }

    }

    public static String createFilterBean(Map<String, Object>  formBeanMap) throws Exception {
        return FreemarkerUtil.freemarkerProcess(REQUEST_FILTER_BEAN,formBeanMap);
    }


    public static String createFieldBean(Map<String, Object>  formBeanMap) throws Exception {



        return FreemarkerUtil.freemarkerProcess(REQUEST_FILTER_BEAN,formBeanMap);
    }


    public static String generateMarkdownDesc() throws Exception {
        Map<String, Object>  formBeanMap = new HashMap<String, Object>();
        formBeanMap.put("beanName", "testBean");
        List<Map<String, String>> paramsList = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 4; i++) {
            Map<String, String> tmpParamMap = new HashMap<String, String>();
            tmpParamMap.put("paramType", "String");
            tmpParamMap.put("paramName", "param" + i);
            paramsList.add(tmpParamMap);
        }
        formBeanMap.put("params", paramsList);
        return FreemarkerUtil.freemarkerProcess(MD_FTL, formBeanMap);
    }

    /**
     * markdown转html
     * @param mdContent markdown内容
     * @param toc 是否生成目录
     * @return
     */
    public static String md2html(String mdContent, boolean toc) {
        if (toc) {
            // level：生成目录的最大标题级别，支持逗号分隔，如：level=1,2,3或者level=1-3
            mdContent = "[TOC level=1-3]" + LINE_SEPARATOR + mdContent;
        }
        MutableDataSet options = new MutableDataSet();
        options.setFrom(ParserEmulationProfile.MARKDOWN);
        options.set(Parser.EXTENSIONS,
                Arrays.asList(new Extension[] { TablesExtension.create(),
                        JekyllTagExtension.create(),
                        TocExtension.create(),
                        SimTocExtension.create()}))
                .set(TocExtension.LEVELS, 255)
                .set(TocExtension.TITLE, "接口描述文档")
                .set(TocExtension.DIV_CLASS, "toc");
        Parser parser = Parser.builder(options).build();
        HtmlRenderer htmlRenderer = HtmlRenderer.builder(options).build();
        Document document = parser.parse(mdContent);
        String html = htmlRenderer.render(document);
        String style = "<style type='text/css'>" + MD_CSS + "</style>" + LINE_SEPARATOR;
        return style + html;
    }


    private static void testFilterBean(String beanName) {
        try {
            //处理参数
            List<ApiFilterModel> apiFilterModels = new ArrayList<>();

            ApiFilterModel filter1 = new ApiFilterModel();
            filter1.setFieldRequestName("username");
            filter1.setFieldType("String");
            apiFilterModels.add(filter1);

            ApiFilterModel filter2 = new ApiFilterModel();
            filter2.setFieldRequestName("age");
            filter2.setFieldType("Num");
            apiFilterModels.add(filter2);

            ApiFilterModel filter3 = new ApiFilterModel();
            filter3.setFieldRequestName("birthday");
            filter3.setFieldType("Date");
            apiFilterModels.add(filter3);

            Map<String, Object>  formBeanMap = generateFilterBeanMap(apiFilterModels,beanName);

            String s = createFilterBean(formBeanMap);
            System.out.println("======================================");
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package com.util;

import com.util.event.SysintergrationApiEvent;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 名称: HttpClientUtil.java<br>
 * 描述:<br>
 * 类型: JAVA<br>
 * 最近修改时间:2017年1月5日 下午6:12:31<br>
 *
 * @author Eric
 * @version [版本号, V1.0]
 */
public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private HttpClientUtilProperties properties;
    private PoolingHttpClientConnectionManager connManager;

    public HttpClientUtil(HttpClientUtilProperties properties) {
        this.properties = properties;

        connManager = new PoolingHttpClientConnectionManager();
        connManager.setMaxTotal(properties.getMaxTotal());
        connManager.setDefaultMaxPerRoute(properties.getDefaultMaxPerRoute());
        connManager.setDefaultConnectionConfig(ConnectionConfig.custom()
                .setMalformedInputAction(CodingErrorAction.IGNORE)
                .setUnmappableInputAction(CodingErrorAction.IGNORE)
                .setCharset(Consts.UTF_8).build());
    }

    public HttpClientUtilProperties getProperties() {
        return properties;
    }
    /**
     * 提供post方法,参数为json类型
     *
     * @param url
     * @param parmMap
     * @param headerMap
     * @param sendCharset
     * @return
     * @throws Exception String
     */
    public String get(String url, Map<String, String> parmMap,
                      Map<String, String> headerMap, String sendCharset) throws Exception {
        String paramString = "";
        StringBuilder paramBuilder = new StringBuilder();
        if (!CollectionUtils.isEmpty(parmMap)) {
            paramBuilder.append("?");
            if (StringUtils.isEmpty(sendCharset)) {
                sendCharset = "UTF-8";
            }
            for (String key : parmMap.keySet()) {
                try {
                    paramBuilder.append(key + "=" + URLEncoder.encode(parmMap.get(key) , sendCharset) + "&");
                } catch (UnsupportedEncodingException e) {
                    logger.error("参数编码失败", e);
                    throw new Exception(e);
                }
            }
            paramString = paramBuilder.substring(0,paramBuilder.length() - 1);
        }
        String apiCode = url;
        url = getUrl(url);
        HttpGet httpGet = new HttpGet(url + paramString);
        return execute(httpGet, headerMap, url, GsonUtils.toJsonString(parmMap),apiCode);
    }

    /**
     * 提供post方法,参数为key-value类型
     *
     * @param url
     * @param parmMap
     * @param headerMap
     * @param sendCharset
     * @return
     * @throws Exception String
     */
    public String post(String url, Map<String, String> parmMap,
                       Map<String, String> headerMap, String sendCharset) throws Exception {
        String apiCode = url;
        url = getUrl(url);
        HttpPost httpPost = new HttpPost(url);
        if (!CollectionUtils.isEmpty(parmMap)) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (String key : parmMap.keySet()) {
                nvps.add(new BasicNameValuePair(key, parmMap.get(key)));
            }
            if (StringUtils.isEmpty(sendCharset)) {
                sendCharset = "UTF-8";
            }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, sendCharset));
            } catch (UnsupportedEncodingException e) {
                logger.error("参数编码失败", e);
                throw new Exception(e);
            }
        }
        return execute(httpPost, headerMap, url, GsonUtils.toJsonString(parmMap),apiCode);
    }

    /**
     * 提供post方法,参数为json类型
     *
     * @param url
     * @param content
     * @param headerMap
     * @param sendCharset
     * @return
     * @throws Exception String
     */
    public String post(String url, String content,
                       Map<String, String> headerMap, String sendCharset) throws Exception {
        String apiCode = url;
        url = getUrl(url);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(content,
                StringUtils.isEmpty(sendCharset) ? "UTF-8" : sendCharset));
        httpPost.setHeader("Content-Type", "application/json");
        return execute(httpPost, headerMap, url, content,apiCode);
    }

    public CloseableHttpResponse getResponse(String url, Map<String, String> parmMap,
                      Map<String, String> headerMap, String sendCharset) throws Exception {
        String paramString = "";
        StringBuilder paramBuilder = new StringBuilder();
        if (!CollectionUtils.isEmpty(parmMap)) {
            paramBuilder.append("?");
            if (StringUtils.isEmpty(sendCharset)) {
                sendCharset = "UTF-8";
            }
            for (String key : parmMap.keySet()) {
                try {
                    paramBuilder.append(key + "=" + URLEncoder.encode(parmMap.get(key) , sendCharset) + "&");
                } catch (UnsupportedEncodingException e) {
                    logger.error("参数编码失败", e);
                    throw new Exception(e);
                }
            }
            paramString = paramBuilder.substring(0,paramBuilder.length() - 1);
        }
        String apiCode = url;
        url = getUrl(url);
        HttpGet httpGet = new HttpGet(url + paramString);
        return responseExecute(httpGet, headerMap, url,GsonUtils.toJsonString(parmMap),apiCode);
    }

    /**
     * 提供post方法,参数为key-value类型， 返回是CloseableHttpResponse对象
     *
     * @param url
     * @param parmMap
     * @param headerMap
     * @param sendCharset
     * @return CloseableHttpResponse
     * @throws Exception String
     */
    public CloseableHttpResponse postReturnResponse(String url, Map<String, String> parmMap,
                       Map<String, String> headerMap, String sendCharset) throws Exception {
        String apiCode = url;
        url = getUrl(url);
        HttpPost httpPost = new HttpPost(url);
        if (!CollectionUtils.isEmpty(parmMap)) {
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            for (String key : parmMap.keySet()) {
                nvps.add(new BasicNameValuePair(key, parmMap.get(key)));
            }
            if (StringUtils.isEmpty(sendCharset)) {
                sendCharset = "UTF-8";
            }
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(nvps, sendCharset));
            } catch (UnsupportedEncodingException e) {
                logger.error("参数编码失败", e);
                throw new Exception(e);
            }
        }
        return responseExecute(httpPost, headerMap, url,GsonUtils.toJsonString(parmMap),apiCode);
    }

    /**
     * 提供post方法,参数为json类型， 返回是CloseableHttpResponse对象
     *
     * @param url
     * @param content
     * @param headerMap
     * @param sendCharset
     * @return CloseableHttpResponse
     * @throws Exception String
     */
    public CloseableHttpResponse postReturnResponse(String url, String content,
                       Map<String, String> headerMap, String sendCharset) throws Exception {
        String apiCode = url;
        url = getUrl(url);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(content,
                StringUtils.isEmpty(sendCharset) ? "UTF-8" : sendCharset));
        httpPost.setHeader("Content-Type", "application/json");
        return responseExecute(httpPost, headerMap, url,content,apiCode);
    }
//都要调用的方法
    private CloseableHttpResponse responseExecute(HttpRequestBase httpRequest,
        Map<String, String> headerMap, String url,String json,String apiCode) throws Exception {

        if (!CollectionUtils.isEmpty(headerMap)) {
            for (String key : headerMap.keySet()) {
                httpRequest.addHeader(key, headerMap.get(key));
            }
        }

        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(properties.getSocketTimeout())
                .setConnectTimeout(properties.getConnectTimeout())
                .setConnectionRequestTimeout(properties
                        .getConnectionRequestTimeout()).build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(connManager)
                .setConnectionManagerShared(true)
                .setConnectionTimeToLive(properties
                        .getConnectTimeoutToLive(), TimeUnit.SECONDS)
                .setDefaultRequestConfig(requestConfig).build();

        CloseableHttpResponse response;
        Date startTime = new Date();
        String requestPayload = json;
        String responePayload ="";
        String responseStatus="";
        String status = "1";
        try {
            response = httpclient.execute(httpRequest);
            responseStatus= response.getStatusLine().getStatusCode()+"";
//            responePayload = EntityUtils.toString(response.getEntity(), "utf-8");

            String headerJson = null;
            if (headerMap != null){
                headerJson = GsonUtils.toJsonString(headerMap);
            }
            logger.info("responseExecute  请求地址：{}，请求头参数：{}，请求报文：{}", url,headerJson, json);
        } catch (IOException e) {
            logger.error("远程调用失败: " + url, e);
            status = "0";
            throw new Exception(e);
        }finally {
            long end = System.currentTimeMillis()-startTime.getTime();
            //发布事件
            if(!apiCode.startsWith("http://")&&!apiCode.startsWith("https://")) {
                ApplicationContext context = SpringBootBeanUtil.getApplicationContext();
                context.publishEvent(new SysintergrationApiEvent(new Object(), apiCode,startTime,(int)end,requestPayload,responePayload,status,responseStatus));
            }
        }

        return response;
    }
    //健康查看返回状态
    public String getHealthy(String url) throws Exception {
        HttpGet httpGet = new HttpGet(url );
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(properties.getSocketTimeout())
                .setConnectTimeout(properties.getConnectTimeout())
                .setConnectionRequestTimeout(properties
                        .getConnectionRequestTimeout()).build();

        CloseableHttpClient httpclient = HttpClients.custom()
                .setConnectionManager(connManager)
                .setConnectionManagerShared(true)
                .setConnectionTimeToLive(properties
                        .getConnectTimeoutToLive(), TimeUnit.SECONDS)
                .setDefaultRequestConfig(requestConfig).build();

        CloseableHttpResponse response;
        String responseStatus = "";
        try {
            response = httpclient.execute(httpGet);
            responseStatus= response.getStatusLine().getStatusCode()+"";

        } catch (IOException e) {
            logger.error("远程调用失败: " + url, e);
            throw new Exception(e);
        }finally {
        }

        return responseStatus;
    }
    private String execute(HttpRequestBase httpRequest,
        Map<String, String> headerMap, String url, String json,String apiCode) throws Exception {
        CloseableHttpResponse response;
        String result = "";
        try {
            response = responseExecute(httpRequest,headerMap,url,json,apiCode);
        } catch (IOException e) {
            logger.error("远程调用失败: " + url, e);
            throw new Exception(e);
        }

        if (null != response) {
            HttpEntity entity = response.getEntity();
            try {
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                    String headerJson = null;
                    if (headerMap != null){
                        headerJson = GsonUtils.toJsonString(headerMap);
                    }
                    logger.info("请求地址：{}，请求头参数：{}，请求报文：{}，返回报文：{}", url,headerJson, json, result);
                }
                EntityUtils.consume(entity);
            } catch (Exception ex) {
                logger.error("远程调用失败: " + url, ex);
                throw new Exception(ex);
            } finally {
                if (null != response) {
                    try {
                        response.close();
                    } catch (IOException e) {
                        logger.error("Response关闭失败: " + url, e);
                    }
                }
            }
        }
        return result;
    }
//apiCode转url
    String getUrl(String url){
//        if(!url.startsWith("http://")&&!url.startsWith("https://")){
//           url = redisCacheService.getCache(BaseDictKey.PLATFORM_APICODE_URL+url);
////           if(Strings.isNotBlank(jsonString)) {
////               JSONObject jsonObject = JSON.parseObject(jsonString);
////               url = jsonObject.get("apiAddress").toString();
////               if (BaseDictKey.API_TYPE_WEBSERVICE.equals(jsonObject.get("apiType").toString())){
////                   //如果是webservice方法
////                   String methodName = jsonObject.get("methodName").toString();
////               }
////           }
//        }
        return url;
    }

    public String postXML(String url, String content, Map<String,String> headerMap, String sendCharset) throws Exception {
        String apiCode = url;
        url = getUrl(url);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(content,
                StringUtils.isEmpty(sendCharset) ? "UTF-8" : sendCharset));
        httpPost.setHeader("Content-Type", "text/xml");
        return execute(httpPost, headerMap, url, content,apiCode);
    }

    @ConfigurationProperties(prefix = "httpclient")
    public static class HttpClientUtilProperties {
        /**
         * 取回数据超时时间，单位毫秒
         */
        private int socketTimeout = 1200 * 1000;
        /**
         * 建立连接超时时间，单位毫秒
         */
        private int connectTimeout = 10 * 1000;
        /**
         * 连接池最大并发连接数
         */
        private int maxTotal = 200;
        /**
         * 单路由最大并发数
         */
        private int defaultMaxPerRoute = 20;
        /**
         * 描述：连接池中连接最大存活时间，单位由参数指定
         */
        private int connectTimeoutToLive = 5 * 60;
        /**
         * 描述：从连接池中获取连接超时时间，单位毫秒
         */
        private int connectionRequestTimeout = 10 * 1000;

        public int getSocketTimeout() {
            return socketTimeout;
        }

        public void setSocketTimeout(int socketTimeout) {
            this.socketTimeout = socketTimeout;
        }

        public int getConnectionRequestTimeout() {
            return connectionRequestTimeout;
        }

        public void setConnectionRequestTimeout(int connectionRequestTimeout) {
            this.connectionRequestTimeout = connectionRequestTimeout;
        }

        public int getConnectTimeout() {
            return connectTimeout;
        }

        public void setConnectTimeout(int connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

        public int getMaxTotal() {
            return maxTotal;
        }

        public void setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
        }

        public int getDefaultMaxPerRoute() {
            return defaultMaxPerRoute;
        }

        public void setDefaultMaxPerRoute(int defaultMaxPerRoute) {
            this.defaultMaxPerRoute = defaultMaxPerRoute;
        }

        public int getConnectTimeoutToLive() {
            return connectTimeoutToLive;
        }

        public void setConnectTimeoutToLive(int connectTimeoutToLive) {
            this.connectTimeoutToLive = connectTimeoutToLive;
        }
    }
}

package com.zx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

public class HttpUtil {
	private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

	public static String doPost(String inputurl, String content) {
		if (StringUtil.notEmpty(inputurl)) {
			logger.info("****** Post Url[" + inputurl + "] ******");
			HttpURLConnection httpUrlConn = null;
			PrintWriter pw = null;
			BufferedReader bufferedReader = null;
			try {
				URL url = new URL(inputurl);
				httpUrlConn = (HttpURLConnection) url.openConnection();
				httpUrlConn.setDoOutput(true);
				httpUrlConn.setDoInput(true);
				httpUrlConn.setUseCaches(false);
				httpUrlConn.setRequestMethod("POST");
				logger.info("****** Post ParamString[" + content + "] ******");
				if (StringUtil.notEmpty(content)) {
					pw = new PrintWriter(new OutputStreamWriter(httpUrlConn.getOutputStream(), "UTF-8"));
					pw.print(content);
					pw.flush();
				}
				bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream(), "UTF-8"));
				String line = null;
				StringBuffer buffer = new StringBuffer();
				while ((line = bufferedReader.readLine()) != null) {
					buffer.append(line);
				}
				return buffer.toString();
			} catch (Exception e) {
				logger.error("****** Post[" + inputurl + "] error ******", e);
				e.printStackTrace();
			} finally {
				if (httpUrlConn != null) {
					httpUrlConn.disconnect();
				}
				if (pw != null) {
					pw.close();
				}
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return null;
	}

	public static String doPost(String inputurl, Map<String, Object> params) {
		if (StringUtil.notEmpty(inputurl)) {
			String paramsString = null;
			if (params != null && params.size() > 0) {
				paramsString = JsonMVCUtil.toJson(params);
				logger.info("****** Post ParamString[" + paramsString + "] ******");
			}
			return doPost(inputurl, paramsString);
		}
		return null;
	}

	public static String doGet(String inputurl, Map<String, Object> params) {
		if (StringUtil.notEmpty(inputurl)) {
			String paramsString = contactParams(inputurl, params);
			if (StringUtil.notEmpty(paramsString)) {
				inputurl += paramsString;
			}
			logger.info("****** Get Url[" + inputurl + "] ******");
			HttpURLConnection httpUrlConn = null;
			BufferedReader bufferedReader = null;
			try {
				URL url = new URL(inputurl);
				httpUrlConn = (HttpURLConnection) url.openConnection();

				httpUrlConn.setDoOutput(false);
				httpUrlConn.setDoInput(true);
				httpUrlConn.setUseCaches(false);

				httpUrlConn.setRequestMethod("GET");
				httpUrlConn.connect();

				bufferedReader = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream(), "utf-8"));

				String str = null;
				StringBuffer buffer = new StringBuffer();
				while ((str = bufferedReader.readLine()) != null) {
					buffer.append(str);
				}
				return buffer.toString();
			} catch (Exception e) {
				logger.error("****** Get[" + inputurl + "] error ******", e);
				e.printStackTrace();
			} finally {
				if (httpUrlConn != null) {
					httpUrlConn.disconnect();
				}
				if (bufferedReader != null) {
					try {
						bufferedReader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return null;
	}
	
	public static String contactParams(String inputurl, Map<String, Object> params) {
		StringBuffer buffer = new StringBuffer();
		if (params != null && params.size() > 0) {
			if(StringUtil.isEmpty(inputurl) || inputurl.indexOf("?") == -1){
				buffer.append("?");
			}else{
				buffer.append("&");
			}
			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				buffer.append(key + "=" + params.get(key) + "&");
			}
			if (buffer.length() > 0) {
				buffer.deleteCharAt(buffer.length() - 1);
			}
			return buffer.toString();
		}
		return null;
	}
}

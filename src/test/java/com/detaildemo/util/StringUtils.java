package com.detaildemo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.Query;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 *
 * @author hawods
 * @version 2018-03-17
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	private static Logger logger = LoggerFactory.getLogger(StringUtils.class);
	private static final char SEPARATOR = '_';
	private static final Pattern IE_PATTERN = Pattern.compile(".*MSIE.*?;.*");
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("####.####");
	private static final NumberFormat NUMBER_FORMAT;

	static {
		NUMBER_FORMAT = NumberFormat.getInstance();
		NUMBER_FORMAT.setGroupingUsed(false);
		NUMBER_FORMAT.setMaximumFractionDigits(15);
	}

	public static <T> List<Map<String, T>> convertToList(String jsonString) {
		//自定义序列化
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(new TypeToken<List<Map<String, T>>>() {
				}.getType(), new MapTypeAdapter()).create();
		List<Map<String, T>> list = (List)gson.fromJson(jsonString, (new TypeToken<List<Map<String, T>>>() {
		}).getType());
		return list;
	}


	/**
	 * 驼峰命名法工具
	 *
	 * @return toCamelCase(" hello_world ") == "helloWorld"
	 * toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCamelCase(String s) {
		if (s == null) {
			return null;
		}

		s = s.toLowerCase();

		StringBuilder sb = new StringBuilder(s.length());
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == SEPARATOR) {
				upperCase = true;
			} else if (upperCase) {
				sb.append(Character.toUpperCase(c));
				upperCase = false;
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	/**
	 * 驼峰命名法工具
	 *
	 * @return toCamelCase(" hello_world ") == "helloWorld"
	 * toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toUnderScoreCase(String s) {
		if (s == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			boolean nextUpperCase = true;

			if (i < (s.length() - 1)) {
				nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
			}

			if ((i > 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					sb.append(SEPARATOR);
				}
				upperCase = true;
			} else {
				upperCase = false;
			}

			sb.append(Character.toLowerCase(c));
		}

		return sb.toString();
	}

	/**
	 * 浮点数转字符串，去掉无用小数点
	 *
	 * @param number
	 * @return
	 */
	public static String decimalFormat(Float number) {
		if (number == null) {
			return EMPTY;
		}

		return DECIMAL_FORMAT.format(number);
	}

	/**
	 * 浮点数转字符串，去掉无用小数点
	 *
	 * @param number
	 * @return
	 */
	public static String decimalFormat(Double number) {
		if (number == null) {
			return EMPTY;
		}

		return DECIMAL_FORMAT.format(number);
	}

	/**
	 * 任意对象转为字符串，数字最高保留小数点前后15位，并去掉无用的小数位0
	 *
	 * @param object
	 * @return
	 */
	public static String format(Object object) {
		if (object == null) {
			return EMPTY;
		}

		try {
			return NUMBER_FORMAT.format(object);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return String.valueOf(object);
	}

	/**
	 * @return
	 * @throws MalformedObjectNameException
	 * 获取当前机器的端口号
	 */
	public static String getLocalPort(){

		MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
		Set<ObjectName> objectNames = null;
		try {
			objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),
					Query.match(Query.attr("protocol"), Query.value("HTTP/1.1")));
			String port = objectNames.iterator().next().getKeyProperty("port");
			return port;
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @return
	 * 获取当前机器的IP
	 */
	public static String getLocalIP() {
		InetAddress addr = null;
		try {
			addr = InetAddress.getLocalHost();
		} catch (Exception e) {
			e.printStackTrace();
		}


		byte[] ipAddr = addr.getAddress();
		String ipAddrStr = "";
		for (int i = 0; i < ipAddr.length; i++) {
			if (i > 0) {
				ipAddrStr += ".";
			}
			ipAddrStr += ipAddr[i] & 0xFF;
		}
		return ipAddrStr;
	}
}



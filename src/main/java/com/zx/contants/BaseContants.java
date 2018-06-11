package com.zx.contants;

import java.util.HashSet;
import java.util.Set;

/**
 * 基础常量类
 *
 * @author ning
 * @create 2018-06-11 10:28
 **/
public class BaseContants {

    /*
    * 时间秒
    * */
    public static final long ONE_MIN_MSECONDS = 60L * 1000;
    public static final long ONE_HOUR_MSECONDS = 60L * 60 * 1000;
    public static final long ONE_DAY_MSECONDS = 24L * 60L * 60 * 1000;
    /**根目录*/
    public static final String BASE_PATH = "/home/ningjianjian/";
    /**
     * 多语言
     * */
    public static final String LANGUAGE_CN = "zh_CN";
    public static final String LANGUAGE_EN = "en_US";

    public static final int ONE_THOUSAND = 1000;

    /**
     * 特殊符号常量
     * */
    public static final String QUESTION_MARK = "?";
    public static final String EQUAL_MARK = "=";
    public static final String AND_MARK = "&";
    public static final String COMMA_CHAR = ",";
    public static final String LINE_CHAR = "-";
    public static final String COLON_CHAR = ":";

    /*登录用户session存储key*/
    public static final String LOGIN_USER_SESSION_KEY = "login_user_session_key";

    /**
     * 验证字段长度类型，是最大还是最小
     */
    public static final String MAX = "max";
    public static final String MIN = "min";

    /**
     * 操作类型
     **/
    public static final String ADD = "add";
    public static final String EDIT = "edit";
    public static final String DEL = "delete";
    public static final String UPDATE = "update";
    /**
     * excel文档格式
     **/
    public static final String XLS = ".xls";
    public static final String XLSX = ".xlsx";
    /***
     * 数据统计查询时间类型
     * */
    public static final String SEARCH_DATE_TYPE_DAY = "day";
    public static final String SEARCH_DATE_TYPE_MONTH = "month";
    public static final String SEARCH_DATE_TYPE_YEAR = "year";
    /**
     *
     * 字段验证常用的属性长度常量
     *
     */
    public static final int SIXTEEN = 16;
    public static final int THIRTY_SIX = 36;
    public static final int SIXTH_FOUR = 64;
    public static final int ONE_HUNDRED_AND_TWENTY_EIGHT = 128;
    public static final int TWO_HUNDRED_AND_FIFTY_SIX = 256;
    public static final int FIVE_HUNDRED_AND_TWELVE = 512;
    public static final int ONT_THOUSAND_AND_TWENTY_FOUR = 1024;
    public static final int TWO_THOUSAND_AND_FORTY_EIGHT = 2048;
    public static final int FOUR_THOUSAND_AND_NINETY_SIX = 4096;
    public static final int SIX_FIVE_FIVE_THREE_FIVE = 65535;

    /*上传文件格式验证集合*/
    public static final Set<String> WX_UPLOAD_JPG_EXT;
    public static final Set<String> WX_UPLOAD_PIC_EXT;
    public static final Set<String> WX_UPLOAD_EXCEL_EXT;
    public static final Set<String> WX_UPLOAD_MUSIC_EXT;

    static {
        WX_UPLOAD_MUSIC_EXT = new HashSet<>();
        WX_UPLOAD_MUSIC_EXT.add("mp3");
        WX_UPLOAD_MUSIC_EXT.add("mp4");
        WX_UPLOAD_MUSIC_EXT.add("wav");
    }

    static {
        WX_UPLOAD_JPG_EXT = new HashSet<>();
        WX_UPLOAD_JPG_EXT.add("jpg");
        WX_UPLOAD_JPG_EXT.add("jpeg");
    }

    static {
        WX_UPLOAD_PIC_EXT = new HashSet<>();
        WX_UPLOAD_PIC_EXT.add("bmp");
        WX_UPLOAD_PIC_EXT.add("png");
        WX_UPLOAD_PIC_EXT.add("jpg");
        WX_UPLOAD_PIC_EXT.add("jpeg");
        WX_UPLOAD_PIC_EXT.add("gif");
    }

    static {
        WX_UPLOAD_EXCEL_EXT = new HashSet<>();
        WX_UPLOAD_EXCEL_EXT.add("xls");
        WX_UPLOAD_EXCEL_EXT.add("xlsx");
    }

}
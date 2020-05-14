package com.dynamic.code.enums;

/**
 * author JayNing
 * created by 2020/5/14 16:15
 **/
public enum  ParamTypeEnum {
    STRING("String","String"),
    DATE("Date","Date"),
    NUM("Num","Long")
    ;

    ParamTypeEnum(String type,String value){
        this.type = type;
        this.value = value;
    }
    private String type;
    private String value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String getValue(String fieldType) {
        ParamTypeEnum[] paramTypeEnums = ParamTypeEnum.values();
        for (ParamTypeEnum typeEnum : paramTypeEnums) {
            if (typeEnum.type.equals(fieldType)){
                return typeEnum.value;
            }
        }
        return null;
    }
}

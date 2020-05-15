package com.dynamic.code.model;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Response<T> {
    public static final String SUCCESS_CODE = "2000";
    /**
     * 通用业务失败代码
     */
    public static final String FAILURE_CODE = "4000";
    /**
     * 验证code
     */
    public static final String VALIDATE_CODE = "4060";

    public static final String VERSION_CONSIST = "2010";

    private String code;
    private String message;
    private T data;
    private List<Object> placeholder;
    private String errorMsg;

    public Response() {
    }

    public Response(Builder<T> builder){
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
        this.placeholder = builder.placeholder;
    }

    public static <T> Response<T> succeed(T data) {
        Response<T> response = new Response<>();
        response.setCode(SUCCESS_CODE);
        response.setData(data);
        return response;
    }
    public static <T> Response<T> succeed() {
        Response<T> response = new Response<>();
        response.setCode(VERSION_CONSIST);
        return response;
    }
    public static <T> Response<T> succeed(T data, String message) {
        Response<T> response = new Response<>();
        response.setCode(SUCCESS_CODE);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public static Response<String> fail(String message) {
        Response response = new Response();
        response.setCode(FAILURE_CODE);
        response.setMessage(message);
        return response;
    }

    public static Response<String> fail(String code, String message) {
        Response response = new Response();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public static Response<String> fail(String code, String message,String data,String errorMsg) {
        Response response = new Response();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        response.setErrorMsg(errorMsg);
        return response;
    }



    public static Response<String> fail(String code, String message,String data) {
        Response response = new Response();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Object> getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(List<Object> placeholder) {
        this.placeholder = placeholder;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class Builder<T> {
        private String code;
        private String message;
        private T data;
        private List<Object> placeholder;
        public Builder code(String code){
            this.code = code;
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }
        public Builder data(T data){
            this.data = data;
            return this;
        }
        public Builder placeholder(Object... placeholder){
            this.placeholder = Arrays.asList(placeholder);
            return this;
        }

        public Response buildSuccess() {
            this.code = SUCCESS_CODE;
            return new Response(this);
        }

    }

    //省略了getter\setter 方法

    public static Response fromJson(String json, Class clazz) {
        Gson gson = new Gson();
//        Type listType = new ParameterizedType() {
//            public Type getRawType() {
//                return List.class;
//            }
//            public Type[] getActualTypeArguments() {
//                return new Type[]{clazz};
//            }
//            public Type getOwnerType() {
//                return null;
//            }
//        };
        Type objectType = new ParameterizedType() {
            public Type getRawType() {
                return Response.class;
            }
            public Type[] getActualTypeArguments() {
                return new Type[]{clazz};
            }
            public Type getOwnerType() {
                return null;
            }
        };
        return gson.fromJson(json, objectType);
    }
}
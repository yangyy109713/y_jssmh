package com.yangyy.hadoop.utils;

public class Result {
    public static final String SUCCESS = "0000";
    public static final String FAILURE = "0001";

    private String code;

    private String message;

    private Object data;

    public Result(String s1, String s2){
        this.code = s1;
        this.message = s2;
    }

    public Result(String code, String message, Object data){
        this.code = code;
        this.message = message;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

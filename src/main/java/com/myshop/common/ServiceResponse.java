package com.myshop.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServiceResponse<T> implements Serializable {
    private int status;
    private String msg;
    private T date;

    private ServiceResponse(int status) {
        this.status = status;
    }

    private ServiceResponse(int status, T date) {
        this.status = status;
        this.date = date;
    }

    private ServiceResponse(String msg) {
        this.msg = msg;
    }

    private ServiceResponse(String msg, T date) {
        this.msg = msg;
        this.date = date;
    }

    private ServiceResponse(int status, String msg, T date) {
        this.status = status;
        this.msg = msg;
        this.date = date;
    }

    private ServiceResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    //    调用枚举类
    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess() {
        return this.status == ReseponseCode.SUCCESS.getCode();
    }


    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public T getDate() {
        return date;
    }


    public static <T> ServiceResponse<T> createBySuccess() {
        return new ServiceResponse<T>(ReseponseCode.SUCCESS.getCode());
    }

    public static <T> ServiceResponse<T> createBySuccessMessage(String msg) {
        return new ServiceResponse<T>(ReseponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServiceResponse<T> createBySuccess(T date) {
        return new ServiceResponse<T>(ReseponseCode.SUCCESS.getCode(), date);
    }

    public static <T> ServiceResponse<T> createBySuccess(String msg, T date) {
        return new ServiceResponse<T>(ReseponseCode.SUCCESS.getCode(), msg, date);
    }

    public static <T> ServiceResponse<T> createByError() {
        return new ServiceResponse<T>(ReseponseCode.ERROR.getCode(), ReseponseCode.ERROR.getDesc());
    }

    public static <T> ServiceResponse<T> createByErrorMessage(String errorMsg) {
        return new ServiceResponse<T>(ReseponseCode.ERROR.getCode(), errorMsg);
    }

    public static <T> ServiceResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage) {
        return new ServiceResponse<T>(errorCode, errorMessage);
    }
}

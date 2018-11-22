package com.myshop.common;

import java.io.Serializable;

public class ServiceResponse<T> implements Serializable{
    private int status;
    private String msg;
    private T date;

    private ServiceResponse (int status){
        this.status=status;
    }
    private ServiceResponse(int status,T date){
        this.status=status;
        this.date=date;
    }
    private ServiceResponse(String msg){
        this.msg=msg;
    }
    private ServiceResponse(String msg,T date){
        this.msg=msg;
        this.date=date;
    }
    private ServiceResponse(int status,String msg,T date){
        this.status=status;
        this.msg=msg;
        this.date=date;
    }
    private ServiceResponse(int status,String msg){
        this.status=status;
        this.msg=msg;
    }

//    调用枚举类
    public boolean isSuccess(){
        return this.status==ReseponseCode.SUCCESS.getCode();
    }


    public int getStatus(){
        return status;
    }
    public String getMsg(){
        return msg;
    }
    public T getDate() {
        return date;
    }
}
